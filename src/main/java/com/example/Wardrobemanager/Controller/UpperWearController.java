package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Model.UpperWear;
import com.example.Wardrobemanager.Service.UpperWearService;
import com.example.Wardrobemanager.dto.RequestDto.AddTopRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddTopResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getByColor")
    public List<UpperWear> getByColor(@RequestParam("color") String color){
        List<UpperWear> tops = upperWearService.getByColor(color);
        return tops;
    }

    @GetMapping("/getByGenre")
    public List<UpperWear> getByGenre(@RequestParam("Genre") String genre){
        List<UpperWear> tops = upperWearService.getTopsByGenre(genre);
        return tops;
    }
}
