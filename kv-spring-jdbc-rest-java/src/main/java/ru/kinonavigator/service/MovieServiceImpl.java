package ru.kinonavigator.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.kinonavigator.exception.MovieNotFoundException;
import ru.kinonavigator.model.Movie;
import ru.kinonavigator.repository.MovieRepository;

import java.util.List;

@Primary
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @Override
    public Movie getMovie(int movieId) {
        return movieRepository.getMovieById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    @Override
    public void createMovie(String title, String director, int rating) {
        movieRepository.insertMovie(title, director, rating);
    }

    @Override
    public void updateMovie(String title, String director, int rating, int id) {
        var movie = movieRepository.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.updateMovie(title, director, rating, movie.id());
    }

    @Override
    public void deleteMovie(int id) {
        var movie = movieRepository.getMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.deleteMovieById(movie.id());
    }
}
