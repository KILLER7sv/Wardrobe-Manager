package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.BottomService;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.AddTopRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddTopResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bottom")
public class BottomController {

    @Autowired
    BottomService bottomService;

    @PostMapping("/add")
    public ResponseEntity addTop(@RequestBody AddBottomRequestDto addBottomRequestDto){
        try{
            AddBottomResponseDto bottomResponse = bottomService.addBottom(addBottomRequestDto);
            return new ResponseEntity(bottomResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
