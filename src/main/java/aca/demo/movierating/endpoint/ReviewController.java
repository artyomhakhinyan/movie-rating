package aca.demo.movierating.endpoint;


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

import java.util.List;

@RestController
@RequestMapping("movies/{id}/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/{revid}")
    public Review getById(@PathVariable("revid") Long id,@PathVariable("id") Long movieId) {
        return reviewService.getById(id,movieId);

    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateReview createReview){
        reviewService.create(createReview);
        return  ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).build();
    }

    @PutMapping("/{revid}")
    public  void update(@PathVariable("revid") Long id,@PathVariable("id") Long movieId,@RequestBody UpdateReview updateReview) {
        reviewService.update(id,movieId,updateReview);
    }
    @DeleteMapping("/{revid}")
    public void delete(@PathVariable("revid") Long id,@PathVariable("id") Long movieId){
        reviewService.delete(id,movieId);
    }

    @GetMapping
    public List<Review> search(@PathVariable("id") Long id, @RequestParam(required = false) String description,
                               @RequestParam(required = false) Instant updatedBefore,
                               @RequestParam(required = false) Instant updatedAfter, @RequestParam(required = false)  Long userId,
                               @RequestParam(required = false) double ratingHigherThan,@RequestParam(required = false) double ratingLowerThan) {
        return reviewService.search(id,description, updatedBefore, updatedAfter, userId, ratingHigherThan, ratingLowerThan);
    }
}
