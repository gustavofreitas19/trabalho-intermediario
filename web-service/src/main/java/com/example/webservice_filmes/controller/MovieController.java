package com.example.webservice_filmes.controller;

import com.example.webservice_filmes.movie.Movie;
import com.example.webservice_filmes.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Rota GET para buscar filme pelo título na API externa (OMDB)
    @GetMapping("/search")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        Movie movie = movieService.fetchMovieFromApi(title);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Rota POST para salvar filme após obter da API externa
    @PostMapping("/save")
    public ResponseEntity<String> saveMovie(@RequestParam String title) {
        Movie movie = movieService.fetchMovieFromApi(title);
        if (movie != null) {
            String result = movieService.saveMovie(movie);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
        }
    }

    // Rota GET para listar todos os filmes salvos localmente
    @GetMapping("/list")
    public ResponseEntity<List<Movie>> listMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/sobre")
    public ResponseEntity<Map<String, String>> getSobre() {
        Map<String, String> sobreInfo = new HashMap<>();
        sobreInfo.put("estudante", "Gustavo De Freitas Cardoso");
        sobreInfo.put("projeto", "Web-Service Busca de Filmes");

        return ResponseEntity.ok(sobreInfo);
    }
}
