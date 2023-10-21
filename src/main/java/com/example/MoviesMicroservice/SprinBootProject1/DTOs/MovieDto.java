package com.example.MoviesMicroservice.SprinBootProject1.DTOs;

import lombok.Data;

@Data
public class MovieDto {
    private String id;
    private String title;
    private String overview;
    private double vote_average;
}
