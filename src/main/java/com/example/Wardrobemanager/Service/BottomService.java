package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Repository.BottomRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        bottom.setUserId(addBottomRequestDto.getUserId());
        bottom.setImageUrl(addBottomRequestDto.getImageUrl());

        Bottom savedBottom = bottomRepository.save(bottom);

        AddBottomResponseDto addBottomResponseDto = new AddBottomResponseDto();
        addBottomResponseDto.setName(addBottomRequestDto.getName());
        addBottomResponseDto.setGenre(savedBottom.getGenre());
        addBottomResponseDto.setMessage("Congrats! Your "+savedBottom.getName() +" with ID : "+savedBottom.getId() + " is Added with imageUrl :" +savedBottom.getImageUrl() );

        return addBottomResponseDto;
    }

    public List<Bottom> getByColor(String color, String userId) {
        List<Bottom> bottoms = bottomRepository.findByColor(color);
        List<Bottom> result = bottoms.stream().filter(e -> Objects.equals(e.getUserId(), userId)).toList();
        return result;
    }

    public List<Bottom> getByGenre(String genre, String userId) {
        List<Bottom> bottoms = bottomRepository.findByGenre(genre);
        List<Bottom> result = bottoms.stream().filter(e -> Objects.equals(e.getUserId(), userId)).toList();
        return result;
    }

    @Transactional
    public int deleteByColor(String color) {
        return bottomRepository.deleteByColor(color);
    }

    @Transactional
    public int deleteByGenre(String genre) {
        return bottomRepository.deleteByGenre(genre);
    }

    public List<Bottom> getAll(String userId) {
        return bottomRepository.findByUserId(userId);
    }
}
