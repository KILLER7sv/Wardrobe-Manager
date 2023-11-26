package com.example.Wardrobemanager.Model;


import com.example.Wardrobemanager.Enum.Color;
import com.example.Wardrobemanager.Enum.Color_type;
import com.example.Wardrobemanager.Enum.Gender;
import com.example.Wardrobemanager.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(value = EnumType.STRING)
    Genre genre;

    @Enumerated(value = EnumType.STRING)
    Color color;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Enumerated(value = EnumType.STRING)
    Color_type color_type;
}
