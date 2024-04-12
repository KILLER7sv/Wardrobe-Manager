package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Model.UpperWear;
import com.example.Wardrobemanager.Repository.UpperWearRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddTopRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddTopResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpperWearService {
    @Autowired
    UpperWearRepository upperWearRepository;
    public AddTopResponseDto addTop(AddTopRequestDto addTopRequestDto) {
        UpperWear upperWear = new UpperWear();
        upperWear.setName(addTopRequestDto.getName());
        upperWear.setGender(addTopRequestDto.getGender());
        upperWear.setColor(addTopRequestDto.getColor());
        upperWear.setColor_type(addTopRequestDto.getColor_type());
        upperWear.setGenre(addTopRequestDto.getGenre());

        UpperWear savedUpperWear = upperWearRepository.save(upperWear);

        AddTopResponseDto addTopResponseDto = new AddTopResponseDto();
        addTopResponseDto.setName(savedUpperWear.getName());
        addTopResponseDto.setGenre(savedUpperWear.getGenre());
        addTopResponseDto.setMessage("Congrats! Your " + savedUpperWear.getName()+ " is Added");

        return addTopResponseDto;
    }

    public List<UpperWear> getByColor(String color) {
        return upperWearRepository.getTopsByColor(color);
    }

    public List<UpperWear> getTopsByGenre(String genre) {
        return upperWearRepository.getTopsByGenre(genre);
    }
}
