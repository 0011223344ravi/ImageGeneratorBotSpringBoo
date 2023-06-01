package com.example.springboothatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageReponse {

    private Date date;

    private List<HashMap<String,String>> data;

}
