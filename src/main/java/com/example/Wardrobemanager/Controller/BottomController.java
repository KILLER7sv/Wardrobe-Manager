package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Model.UpperWear;
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

    @GetMapping("")
    public List<Bottom> getAll(@RequestParam("userId") String userId) {
        return bottomService.getAll(userId);
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addBottom(@RequestBody AddBottomRequestDto addBottomRequestDto){
        try {
            AddBottomResponseDto bottomResponse = bottomService.addBottom(addBottomRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(bottomResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getByColor")
    public ResponseEntity<Object> getByColor(@RequestParam("color") String color, @RequestParam("userId") String userId){
        List<Bottom> bottoms = bottomService.getByColor(color, userId);
        if (bottoms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bottoms found with color: " + color);
        }
        return ResponseEntity.ok(bottoms);
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<Object> getByGenre(@RequestParam("genre") String genre, @RequestParam("userId") String userId){
        List<Bottom> bottoms = bottomService.getByGenre(genre, userId);
        if (bottoms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bottoms found with genre: " + genre);
        }
        return ResponseEntity.ok(bottoms);
    }

    @DeleteMapping("/deleteByColor")
    public ResponseEntity<Object> deleteByColor(@RequestParam("color") String color) {
        int deletedCount = bottomService.deleteByColor(color);
        return ResponseEntity.ok("Deleted " + deletedCount + " items with color: " + color);
    }

    @DeleteMapping("/deleteByGenre")
    public ResponseEntity<Object> deleteByGenre(@RequestParam("genre") String genre) {
        int deletedCount = bottomService.deleteByGenre(genre);
        return ResponseEntity.ok("Deleted " + deletedCount + " items with genre: " + genre);
    }
}
