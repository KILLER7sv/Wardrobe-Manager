package com.example.Wardrobemanager.dto.ResponseDto;

import com.example.Wardrobemanager.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddTopResponseDto {
    Genre genre;
    String message;
}
