package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Service.BottomService;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getByColor")
    public List<Bottom> getByColor(@RequestParam("color") String color){
        List<Bottom> bottoms = bottomService.getByColor(color);
        return bottoms;
    }
    @GetMapping("/getByGenre")
    public List<Bottom> getByGenre(@RequestParam("Genre") String genre){
        List<Bottom> bottoms = bottomService.getByGenre(genre);
        return bottoms;
    }

    @DeleteMapping("/deleteByColor")
    public String deleteByColor(@RequestParam("color") String color) {
        int deletedCount = bottomService.deleteByColor(color);
        return "Deleted " + deletedCount + " items with color: " + color;
    }

    @DeleteMapping("/deleteByGenre")
    public String deleteByGenre(@RequestParam("genre") String genre) {
        int deletedCount = bottomService.deleteByGenre(genre);
        return "Deleted " + deletedCount + " items with genre: " + genre;
    }
}
