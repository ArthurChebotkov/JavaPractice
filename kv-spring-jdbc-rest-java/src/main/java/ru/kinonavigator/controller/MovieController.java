package ru.kinonavigator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kinonavigator.model.Movie;
import ru.kinonavigator.model.MovieRequest;
import ru.kinonavigator.service.MovieService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(value = "/{movieId:\\d+}")
    public Movie getProfile(@PathVariable int movieId) {
        return movieService.getMovie(movieId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@Valid @RequestBody MovieRequest request) {
        movieService.createMovie(
                request.title(),
                request.director(),
                request.rating()
        );
    }

    @PutMapping(value = "/{movieId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMovie(
            @Valid @RequestBody MovieRequest request,
            @PathVariable int movieId
    ) {
        movieService.updateMovie(
                request.title(),
                request.director(),
                request.rating(),
                movieId
        );
    }

    @DeleteMapping(value = "/{movieId:\\d+}")
    public void deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
    }
}
