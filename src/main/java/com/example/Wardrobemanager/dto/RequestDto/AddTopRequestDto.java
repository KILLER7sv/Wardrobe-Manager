package com.example.Wardrobemanager.dto.RequestDto;

import com.example.Wardrobemanager.Enum.Color;
import com.example.Wardrobemanager.Enum.Color_type;
import com.example.Wardrobemanager.Enum.Gender;
import com.example.Wardrobemanager.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddTopRequestDto {
    String name;
    Color color;
    Color_type color_type;
    Gender gender;
    Genre genre;
    String userId;
    String imageUrl;
}
