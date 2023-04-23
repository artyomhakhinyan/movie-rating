package aca.demo.movierating.movie;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
@Value
@Jacksonized
@Builder
public class UpdateMovie {
    String title;
    Genre genre;
    LocalDate releasedAt;
    String director;
    double rating;

}
