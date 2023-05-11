package aca.demo.movierating.review;

import lombok.Value;

import java.time.Instant;
@Value
public class CreateReview {
    Long id;
    Long movieId;
    Long userId;
    String description;
    double rating;
    Instant createdAt;
}
