package ru.kinonavigator.exception;

public class MovieNotFoundException extends RuntimeException {

    private final int movieId;

    public MovieNotFoundException(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String getMessage() {
        return "Movie with id = " + movieId + " not found";
    }
}
