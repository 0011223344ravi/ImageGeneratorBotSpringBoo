package com.example.springboothatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageRequest {

    private String prompt ;
    private int n;
    private String size;
}
