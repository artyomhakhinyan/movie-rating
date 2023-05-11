package aca.demo.movierating.review;

import lombok.Value;

import java.time.Instant;
@Value
public class UpdateReview {
    Long userId;
    String description;
    double rating;
    Instant updatedAt;
}
