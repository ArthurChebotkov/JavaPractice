package ru.kinonavigator.service;

import org.springframework.stereotype.Service;
import ru.kinonavigator.exception.MovieNotFoundException;
import ru.kinonavigator.model.Movie;

import java.util.List;


@Service
public class MovieServiceMock implements MovieService {

    @Override
    public Movie getMovie(int movieId) {
        // имитируем обращение к БД
        if (movieId == 123) {
            return new Movie(
                    movieId,
                    "Forest Gump",
                    "Spilberg",
                    9
            );
        } else {
            throw new MovieNotFoundException(movieId);
        }
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public void createMovie(String title, String director, int rating) {
    }

    @Override
    public void updateMovie(String title, String director, int rating, int id) {
    }

    @Override
    public void deleteMovie(int id) {
    }
}
