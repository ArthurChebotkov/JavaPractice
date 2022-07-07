package ru.kinonavigator.service;

import ru.kinonavigator.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie getMovie(int personId);

    void createMovie(String title, String director, int rating);

    void updateMovie(String title, String director, int rating, int id);

    void deleteMovie(int id);
}
