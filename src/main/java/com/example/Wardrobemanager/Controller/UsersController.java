package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.UsersService;
import com.example.Wardrobemanager.dto.RequestDto.AddUserRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.LoginUserRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddUserResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.LoginUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Object> addUser(@RequestBody AddUserRequestDto addUserRequestDto){
        try {
            AddUserResponseDto userResponse = usersService.addUser(addUserRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto){
        try {
            LoginUserResponseDto userResponse = usersService.loginUser(loginUserRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
