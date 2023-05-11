package aca.demo.movierating.review;

import aca.demo.movierating.movie.UpdateMovie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Slf4j
@ToString
public class Review {
    @EqualsAndHashCode.Include
    Long id;
    Long movieId;
    Long userId;
    String description;
    double rating;
    Instant createdAt;
    Instant updatedAt;

    public Review(CreateReview createReview){
        this.id= createReview.getId();
        this.movieId=createReview.getMovieId();
        this.userId=createReview.getUserId();
        this.description=createReview.getDescription();
        this.rating=createReview.getRating();
        this.createdAt=createReview.getCreatedAt();
        this.updatedAt=createReview.getCreatedAt();
    }
    public void update(UpdateReview updateReview){
        this.userId=updateReview.getUserId();
        this.description= updateReview.getDescription();
        this.rating= updateReview.getRating();
        this.updatedAt=updateReview.getUpdatedAt();
    }

}
