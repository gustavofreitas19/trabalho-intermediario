package com.example.Projeto_Intermediario.service;

import com.example.Projeto_Intermediario.movie.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    private final String apiKey = "46b7ed01";
    private final String apiUrl = "http://www.omdbapi.com/?apikey=" + apiKey;

    private final RestTemplate restTemplate;
    private final List<Movie> movieList = new ArrayList<>();

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie fetchMovieFromApi(String title) {
        String url = apiUrl + "&t=" + title;

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> movieData = response.getBody();

        if (movieData != null && movieData.get("Title") != null && movieData.get("Year") != null && movieData.get("Plot") != null) {
            String movieTitle = (String) movieData.get("Title");
            String movieYear = (String) movieData.get("Year");
            String moviePlot = (String) movieData.get("Plot");
            return new Movie(movieTitle, movieYear, moviePlot);
        }
        return null;
    }

    public String saveMovie(Movie movie) {
        movieList.add(movie);
        return "Filme salvo: " + movie.getTitle() + " (" + movie.getYear() + ")";
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }
}
