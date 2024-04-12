package com.example.Wardrobemanager.Service;

import com.example.Wardrobemanager.Enum.Color;
import com.example.Wardrobemanager.Enum.Genre;
import com.example.Wardrobemanager.Model.Bottom;
import com.example.Wardrobemanager.Repository.BottomRepository;
import com.example.Wardrobemanager.dto.RequestDto.AddBottomRequestDto;
import com.example.Wardrobemanager.dto.ResponseDto.AddBottomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        addBottomResponseDto.setMessage("Congrats! Your "+savedBottom.getName() +" with ID : "+savedBottom.getId() + " is Added");

        return addBottomResponseDto;
    }

    public List<Bottom> getByColor(String color) {
        List<Bottom> bottoms = bottomRepository.getColor(color);
        // directly return this, contains all object

//        to return a specific entity
//        List<String> ans = new ArrayList<>();
//        for(Bottom b : bottoms){
//            ans.add(b.getName());
//        }

        return bottoms;
    }

    public List<Bottom> getByGenre(String genre) {
        List<Bottom> bottoms = bottomRepository.getGenre(genre);
//        List<String> ans = new ArrayList<>();
//        for(Bottom b : bottoms){
//            ans.add(b.getName());
//        }
        return bottoms;
    }

    @Transactional
    public int deleteByColor(String color) {
        Color colorEnum = Color.valueOf(color.toUpperCase());
        return bottomRepository.deleteByColor(colorEnum);
    }

    @Transactional
    public int deleteByGenre(String genre) {
        Genre genreEnum = Genre.valueOf(genre.toUpperCase());
        return bottomRepository.deleteByGenre(genreEnum);
    }
}
