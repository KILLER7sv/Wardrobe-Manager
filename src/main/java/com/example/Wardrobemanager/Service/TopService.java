package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.Top;
import com.example.Wardrobemanager.Repository.TopRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddTopRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddTopResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopService {
    @Autowired
    TopRepository topRepository;
    public AddTopResponseDto addTop(AddTopRequestDto addTopRequestDto) {
        Top top = new Top();
        top.setName(addTopRequestDto.getName());
        top.setGender(addTopRequestDto.getGender());
        top.setColor(addTopRequestDto.getColor());
        top.setColor_type(addTopRequestDto.getColor_type());
        top.setGenre(addTopRequestDto.getGenre());

        Top savedTop =topRepository.save(top);

        AddTopResponseDto addTopResponseDto = new AddTopResponseDto();
        addTopResponseDto.setName(savedTop.getName());
        addTopResponseDto.setGenre(savedTop.getGenre());
        addTopResponseDto.setMessage("Congrats! Your " +savedTop.getName()+ " is Uploaded");

        return addTopResponseDto;
    }
}
