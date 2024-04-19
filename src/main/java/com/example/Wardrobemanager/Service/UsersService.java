package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.Users;
import com.example.Wardrobemanager.Repository.UsersRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddUserRequestDto;
import com.example.Wardrobemanager.dto.RequestDto.LoginUserRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddUserResponseDto;
import com.example.Wardrobemanager.dto.ResponseDto.LoginUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public AddUserResponseDto addUser(AddUserRequestDto addUserRequestDto) {
        Users user = new Users();
        user.setUsername(addUserRequestDto.getUsername());
        user.setPassword(addUserRequestDto.getPassword());
        user.setUserId(UUID.randomUUID().toString());

        Users savedUser = usersRepository.save(user);

        AddUserResponseDto addUserResponseDto = new AddUserResponseDto();
        addUserResponseDto.setUserId(savedUser.getUserId());
        return addUserResponseDto;
    }

    public LoginUserResponseDto loginUser(LoginUserRequestDto loginUserRequestDto) throws AuthenticationException {
        Users user = usersRepository.findByUsername(loginUserRequestDto.getUsername());
        if (user != null && user.getPassword().equals(loginUserRequestDto.getPassword())) {
            LoginUserResponseDto userResponseDto = new LoginUserResponseDto();
            userResponseDto.setUserId(user.getUserId());
            return userResponseDto;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}
