package com.example.springboothatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Messages {

    private String role;
    private ImageRequest imageRequest;//prom
}
