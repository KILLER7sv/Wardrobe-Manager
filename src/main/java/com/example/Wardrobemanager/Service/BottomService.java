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
        bottom.setColor(addBottomRequestDto.getColor());
        bottom.setGender(addBottomRequestDto.getGender());
        bottom.setGenre(addBottomRequestDto.getGenre());
        bottom.setColor_type(addBottomRequestDto.getColor_type());

        Bottom savedBottom = bottomRepository.save(bottom);

        AddBottomResponseDto addBottomResponseDto = new AddBottomResponseDto();
        addBottomResponseDto.setGenre(savedBottom.getGenre());
        addBottomResponseDto.setMessage("Congrats! Your Bottom is Uploaded");

        return addBottomResponseDto;
    }
}
