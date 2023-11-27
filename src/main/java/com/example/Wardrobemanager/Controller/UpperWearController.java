package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.UpperWearService;
import com.example.Wardrobemanager.dto.RequestDto.AddTopRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddTopResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/top")
public class UpperWearController {
    @Autowired
    UpperWearService upperWearService;

    @PostMapping("/add")
    public ResponseEntity addUpperWear(@RequestBody AddTopRequestDto addTopRequestDto){
        try{
            AddTopResponseDto topResponse = upperWearService.addTop(addTopRequestDto);
            return new ResponseEntity(topResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
