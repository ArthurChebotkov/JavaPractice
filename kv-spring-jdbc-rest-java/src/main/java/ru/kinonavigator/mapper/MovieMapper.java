package ru.kinonavigator.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kinonavigator.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("director"),
                rs.getInt("rating")
        );
    }
}
