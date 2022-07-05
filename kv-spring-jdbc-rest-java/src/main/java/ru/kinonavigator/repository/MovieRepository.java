package ru.kinonavigator.repository;

import ru.kinonavigator.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<Movie> getAll();
    Optional<Movie> getMovieById(int id);

    void insertMovie(String title, String director, int rating);

    void updateMovie(String title, String director, int rating, int id);

    void deleteMovieById(int id);
}
