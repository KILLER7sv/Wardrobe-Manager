package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Model.Shoes;
import com.example.Wardrobemanager.Model.UpperWear;
import com.example.Wardrobemanager.Service.ShoesService;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.AddShoesRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddShoesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesController {

    @Autowired
    ShoesService shoesService;

    @PostMapping("/add")
    public ResponseEntity addShoes(@RequestBody AddShoesRequestDto addShoesRequestDto){
        try{
            AddShoesResponseDto shoesResponse = shoesService.addShoes(addShoesRequestDto);
            return new ResponseEntity(shoesResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByColor")
    public List<Shoes> getByColor(@RequestParam("color") String color){
        List<Shoes> shoes = shoesService.getByColor(color);
        return shoes;
    }

    @GetMapping("/getByGenre")
    public List<Shoes> getByGenre(@RequestParam("Genre") String genre){
        List<Shoes> shoes = shoesService.getShoesByGenre(genre);
        return shoes;
    }
}
