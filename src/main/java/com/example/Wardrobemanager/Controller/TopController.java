package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.TopService;
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
public class TopController {
    @Autowired
    TopService topService;

    @PostMapping("/add")
    public ResponseEntity addTop(@RequestBody AddTopRequestDto addTopRequestDto){
        try{
            AddTopResponseDto topResponse = topService.addTop(addTopRequestDto);
            return new ResponseEntity(topResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
