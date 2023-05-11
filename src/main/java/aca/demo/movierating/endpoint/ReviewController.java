package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.*;
import aca.demo.movierating.review.CreateReview;
import aca.demo.movierating.review.Review;
import aca.demo.movierating.review.ReviewService;
import aca.demo.movierating.review.UpdateReview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("movies/{id}/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) {
        return reviewService.getById(id);

    }
    @PostMapping
    public ResponseEntity create(@RequestBody CreateReview createReview){
        reviewService.create(createReview);
        return  ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).build();
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable Long id, @RequestBody UpdateReview updateReview) {
        reviewService.update(id,updateReview);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.delete(id);
    }

    @GetMapping
    public List<Review> search(@RequestParam String description,@RequestParam Instant updatedBefore,@RequestParam Instant updatedAfter,
                               @RequestParam  Long userId,@RequestParam double ratingHigherThan,@RequestParam double ratingLowerThan) {
        return reviewService.search(description, updatedBefore, updatedAfter, userId, ratingHigherThan, ratingLowerThan);
    }
}
