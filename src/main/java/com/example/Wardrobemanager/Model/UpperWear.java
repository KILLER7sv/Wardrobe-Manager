package com.example.Wardrobemanager.Model;

import com.example.Wardrobemanager.Enum.Color;
import com.example.Wardrobemanager.Enum.Color_type;
import com.example.Wardrobemanager.Enum.Gender;
import com.example.Wardrobemanager.Enum.Genre;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "upperwear")
@Getter
@Setter
public class UpperWear {

    @Id
    String id;

    String name;
    Genre genre;
    Color color;
    Gender gender;
    Color_type color_type;

    // You can keep @Getter and @Setter annotations here if you prefer
}
