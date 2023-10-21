package com.example.MoviesMicroservice.SprinBootProject1.Services;

import com.example.MoviesMicroservice.SprinBootProject1.ApiResponses.MovieApiResponse;
import com.example.MoviesMicroservice.SprinBootProject1.DTOs.MovieDto;
import com.example.MoviesMicroservice.SprinBootProject1.Models.Movie;
import com.example.MoviesMicroservice.SprinBootProject1.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Value("${TMDB.API_KEY}")
    private String ApiKey;

    public void saveTopRatedMovies() {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + ApiKey;

        RestTemplate restTemplate = new RestTemplate();
        MovieApiResponse response = restTemplate.getForObject(url, MovieApiResponse.class);

        if (response != null && response.getResults() != null) {
            for (MovieDto movieDto : response.getResults()) {
                Movie movie = new Movie();
                movie.setId(movieDto.getId());
                movie.setTitle(movieDto.getTitle());
                movie.setOverview(movieDto.getOverview());
                movie.setVote_average(movieDto.getVote_average());
                movieRepository.save(movie);
            }
        }
    }
    public List<Movie> getMoviesPaginated(int pageNo, int pageSize){
        PageRequest pageable = PageRequest.of(pageNo-1,pageSize);
        return movieRepository.findAll(pageable).getContent();
    }
    public void getMovieDetails(String movieID){
        String url = "https://api.themoviedb.org/3/movie/"+movieID;

    }
}
