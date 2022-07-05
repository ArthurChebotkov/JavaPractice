package ru.kinonavigator.model;

public record Movie(
        int id,
        String title,
        String director,
        int rating
) {
}
