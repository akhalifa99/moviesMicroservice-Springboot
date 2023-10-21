package com.example.MoviesMicroservice.SprinBootProject1.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movies")
public class Movie {

    @Id
    private String id;
    private String title;
    private String overview;
    private double vote_average;


}

