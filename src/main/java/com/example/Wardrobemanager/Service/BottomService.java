package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Repository.BottomRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BottomService {
    @Autowired
    BottomRepository bottomRepository;

    public AddBottomResponseDto addBottom(AddBottomRequestDto addBottomRequestDto) {
        Bottom bottom = new Bottom();
        bottom.setName(addBottomRequestDto.getName());
        bottom.setColor(addBottomRequestDto.getColor());
        bottom.setGender(addBottomRequestDto.getGender());
        bottom.setGenre(addBottomRequestDto.getGenre());
        bottom.setColor_type(addBottomRequestDto.getColor_type());

        Bottom savedBottom = bottomRepository.save(bottom);

        AddBottomResponseDto addBottomResponseDto = new AddBottomResponseDto();
        addBottomResponseDto.setName(addBottomRequestDto.getName());
        addBottomResponseDto.setGenre(savedBottom.getGenre());
        addBottomResponseDto.setMessage("Congrats! Your "+savedBottom.getName() + " is Uploaded");

        return addBottomResponseDto;
    }
}
