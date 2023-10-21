package com.example.MoviesMicroservice.SprinBootProject1.Controllers;

import com.example.MoviesMicroservice.SprinBootProject1.Models.Movie;
import com.example.MoviesMicroservice.SprinBootProject1.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/topRated")
    public List<Movie> getTopRated(@RequestParam int pageNo,
                                   @RequestParam int pageSize){
        movieService.saveTopRatedMovies();
        return movieService.getMoviesPaginated(pageNo,pageSize);
    }
    @GetMapping("/{movie_id}")
    public void GetMovieDetails(@PathVariable String movie_id){

    }
}
