package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Model.Shoes;
import com.example.Wardrobemanager.Service.ShoesService;
import com.example.Wardrobemanager.dto.RequestDto.AddShoesRequestDto;
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
    public ResponseEntity<AddShoesResponseDto> addShoes(@RequestBody AddShoesRequestDto addShoesRequestDto){
        try{
            AddShoesResponseDto shoesResponse = shoesService.addShoes(addShoesRequestDto);
            return new ResponseEntity<>(shoesResponse, HttpStatus.CREATED);
        }
        catch (Exception e) {
            AddShoesResponseDto errorResponse = new AddShoesResponseDto();
            errorResponse.setMessage("Error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByColor")
    public ResponseEntity<List<Shoes>> getByColor(@RequestParam("color") String color){
        List<Shoes> shoes = shoesService.getByColor(color);
        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<List<Shoes>> getByGenre(@RequestParam("Genre") String genre){
        List<Shoes> shoes = shoesService.getShoesByGenre(genre);
        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }
}
