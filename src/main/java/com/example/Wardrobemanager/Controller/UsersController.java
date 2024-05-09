package com.example.Wardrobemanager.Controller;

import com.example.Wardrobemanager.Service.UsersService;
import com.example.Wardrobemanager.dto.RequestDto.AddUserRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.LoginUserRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddUserResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.LoginUserResponseDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    UsersService usersService;

//    @Value("${jwt.secret}")
    private static final String SECRET_KEY= "astha#24@wardrobeManager";

    @PostMapping("/register")
    public ResponseEntity<Object> addUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        try {
            // Call your existing addUser method to register the user
            AddUserResponseDto userResponse = usersService.addUser(addUserRequestDto);

            // Generate a JWT token for the registered user
            String token = generateToken(userResponse.getUserId().toString());

            // Add the token to the response
            userResponse.setToken(token);

            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto, HttpServletResponse response) {
        try {
            LoginUserResponseDto userResponse = usersService.loginUser(loginUserRequestDto);
            System.out.println("UserResponse: " + userResponse);
            System.out.println("UserId: " + userResponse.getUserId());

            // Generate a JWT token for the logged-in user
            String token = generateToken(userResponse.getUserId().toString()); // Assuming the response contains the userId
            System.out.println("Token: " + token);
            // set the token in the response header
            userResponse.setToken(token);
            return ResponseEntity.status(HttpStatus.OK).body(userResponse); // Return the token in the response
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private String generateToken(String userId) {
        try {

            UUID.fromString(userId); // Validate the user ID
            // Set the expiration time for the token (e.g., 7 days)
            Date expiryDate = new Date(System.currentTimeMillis() + 604800000); // 7 days in milliseconds

            // Create the JWT token
            return Jwts.builder()
                    .setSubject(userId)
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid user ID format", e);
        }
    }
}