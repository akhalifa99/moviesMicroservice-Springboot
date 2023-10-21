package com.example.MoviesMicroservice.SprinBootProject1.ApiResponses;

import com.example.MoviesMicroservice.SprinBootProject1.DTOs.MovieDto;
import lombok.Data;

import java.util.List;


@Data
public class MovieApiResponse {
    private List<MovieDto> results;


}
