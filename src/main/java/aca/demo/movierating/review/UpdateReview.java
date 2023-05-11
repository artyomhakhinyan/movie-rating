package aca.demo.movierating.review;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
@Value
@Jacksonized
@Builder
public class UpdateReview {
    Long userId;
    String description;
    double rating;
    Instant updatedAt;
}
