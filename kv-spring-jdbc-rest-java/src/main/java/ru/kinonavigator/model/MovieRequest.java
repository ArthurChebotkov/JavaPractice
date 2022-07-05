package ru.kinonavigator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record MovieRequest(
        @NotNull
        String title,
        @NotNull
        String director,
        @NotNull
        @Max(10)
        @Min(0)
        Integer rating
) {
}
