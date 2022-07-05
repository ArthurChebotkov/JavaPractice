package ru.kinonavigator.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kinonavigator.mapper.MovieMapper;
import ru.kinonavigator.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private static final String SQL_GET_MOVIE_ALL =
            "select * from movie order by id";

    private static final String SQL_GET_MOVIE_BY_ID =
            "select id, title, director, rating from movie where id = :id";

    private static final String SQL_INSERT_MOVIE =
            "insert into movie (title, director, rating) values (:title, :director, :rating)";

    private static final String SQL_UPDATE_MOVIE =
            "update movie set title = :title, director = :director, rating = :rating where id = :id";

    private static final String SQL_DELETE_MOVIE = "delete from movie where id = :id";

    private final MovieMapper movieMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(
            MovieMapper movieMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.movieMapper = movieMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(
                        SQL_GET_MOVIE_ALL,
                        movieMapper
                );
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(
                        SQL_GET_MOVIE_BY_ID,
                        params,
                        movieMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertMovie(String title, String director, int rating) {
        var params = new MapSqlParameterSource();
        params.addValue("title", title);
        params.addValue("director", director);
        params.addValue("rating", rating);
        jdbcTemplate.update(SQL_INSERT_MOVIE, params);
    }

    @Override
    public void updateMovie(String title, String director, int rating, int id) {
        var params = new MapSqlParameterSource();
        params.addValue("title", title);
        params.addValue("director", director);
        params.addValue("rating", rating);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_MOVIE, params);
    }

    @Override
    public void deleteMovieById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_MOVIE, params);
    }
}
