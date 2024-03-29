package aca.demo.movierating.review;

import aca.demo.movierating.movie.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Component
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public Review getById(Long id,Long movieId) {
        if(movieRepository.findById(movieId).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        Optional<Review> review=reviewRepository.findById(id);
        if(review.isPresent()){
            return review.get();
        }
        else
            throw new ReviewNotFoundException("Review not found");
    }

    public void create(CreateReview createReview) {
        if(movieRepository.findById(createReview.getMovieId()).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        if(reviewRepository.findById(createReview.getId()).isPresent()){
            throw new IllegalArgumentException(" id already exists");
        }
        else reviewRepository.persist(new Review(createReview));
    }

    public void update(Long id,Long movieId,UpdateReview updateReview) {
        if(movieRepository.findById(movieId).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        if(reviewRepository.findById(id).isEmpty()){
            throw new ReviewNotFoundException("Review not found");
        }
        else {
            reviewRepository.findById(id).get().update(updateReview);
        }
    }

    public  void delete(Long id,Long movieId) {
        if(movieRepository.findById(movieId).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        if(reviewRepository.findById(id).isEmpty()){
            throw new ReviewNotFoundException("Review not found");
        }
        else reviewRepository.delete(reviewRepository.findById(id).get());
    }

    public List<Review> search(Long movieId,String description, Instant updatedBefore, Instant updatedAfter,
                              Long userId, double ratingHigherThan, double ratingLowerThan) {
        if(movieRepository.findById(movieId).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        return  reviewRepository.search(description, updatedBefore, updatedAfter, userId, ratingHigherThan, ratingLowerThan);
    }

}
