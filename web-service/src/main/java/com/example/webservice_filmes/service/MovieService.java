package com.example.webservice_filmes.service;

import com.example.webservice_filmes.movie.Movie;
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

    // Faz a requisição para a OMDB API pelo título e pega o título, ano e sinopse (Plot)
    public Movie fetchMovieFromApi(String title) {
        String url = apiUrl + "&t=" + title;
        // Faz a requisição para a API e obtém o resultado em JSON
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> movieData = response.getBody();

        if (movieData != null && movieData.get("Title") != null && movieData.get("Year") != null && movieData.get("Plot") != null) {
            String movieTitle = (String) movieData.get("Title");
            String movieYear = (String) movieData.get("Year");
            String moviePlot = (String) movieData.get("Plot");
            return new Movie(movieTitle, movieYear, moviePlot);
        }
        return null; // Se não encontrar o filme ou houver erro
    }

    // Salva o filme na lista local
    public String saveMovie(Movie movie) {
        movieList.add(movie);
        return "Filme salvo: " + movie.getTitle() + " (" + movie.getYear() + ")";
    }

    // Retorna a lista de filmes salvos
    public List<Movie> getAllMovies() {
        return movieList;
    }
}
