package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.ShoesService;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.AddShoesRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddShoesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
