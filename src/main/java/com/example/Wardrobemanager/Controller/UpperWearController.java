package com.example.Wardrobemanager.Controller;

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
    public ResponseEntity<AddTopResponseDto> addUpperWear(@RequestBody AddTopRequestDto addTopRequestDto) {
        try {
            AddTopResponseDto topResponse = upperWearService.addTop(addTopRequestDto);
            return new ResponseEntity<>(topResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            AddTopResponseDto errorResponse = new AddTopResponseDto();
            errorResponse.setMessage("Error occurred: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByColor")
    public List<UpperWear> getByColor(@RequestParam("color") String color, @RequestParam("userId") String userId) {
        return upperWearService.getByColor(color, userId);
    }

    @GetMapping("/getByGenre")
    public List<UpperWear> getByGenre(@RequestParam("Genre") String genre, @RequestParam("userId") String userId) {
        return upperWearService.getTopsByGenre(genre, userId);
    }
}
