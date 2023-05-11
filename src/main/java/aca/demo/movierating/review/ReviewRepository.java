package aca.demo.movierating.review;


import aca.demo.movierating.movie.Genre;
import aca.demo.movierating.movie.Movie;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();

    public Optional<Review> findById(Long id) {
        log.debug("Starts findById method with id -{}",id);
        return reviews.stream().filter(review->review.getId().equals(id)).findAny();
    }


    public void persist(Review review) {
        log.debug("Starts persist method with review -{}",review);
        reviews.add(review);
    }

    void delete(Review review) {
        log.debug("Starts delete method with review -{}",review);
        Optional<Review> reviewOptional=reviews.stream().filter(movie1->movie1.getId().equals(review.getId())).findAny();
        if(reviewOptional.isPresent())
            reviews.remove(review);
    }


    List<Review> search(String description, Instant updatedBefore,Instant updatedAfter,
                        Long userId,double ratingHigherThan,double ratingLowerThan) {
        log.debug("Starts search review whith description->{},updatedBefore->{},updatedAfter->{},userId->,ratingHigherThan->{},ratingLowerthen->{}",
         description,updatedBefore,updatedAfter,userId,ratingHigherThan,ratingLowerThan);
        return reviews.stream().filter(review ->
                                ( description==null ||review.getDescription().equals(description))&&
                                 (userId==null || review.getUserId().equals(userId))&&
                                (updatedBefore==null ||review.getUpdatedAt().isAfter(updatedBefore))&&
                                (updatedAfter==null ||review.getUpdatedAt().isBefore(updatedAfter))&&
                                (ratingHigherThan==0||ratingHigherThan> review.getRating())&&
                                 (ratingLowerThan==00||ratingLowerThan< review.getRating())).
                collect(Collectors.toUnmodifiableList());


    }


}
