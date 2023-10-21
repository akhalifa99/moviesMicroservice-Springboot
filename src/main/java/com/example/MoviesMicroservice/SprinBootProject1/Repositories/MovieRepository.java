package com.example.MoviesMicroservice.SprinBootProject1.Repositories;

import com.example.MoviesMicroservice.SprinBootProject1.Models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {


    @Override
    Optional<Movie> findById(String s);
}
