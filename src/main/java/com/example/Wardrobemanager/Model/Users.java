package com.example.Wardrobemanager.Model;

import com.example.Wardrobemanager.Enum.ItemType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Users")
public class Users {
    String userId;
    String username;
    String password;
}
