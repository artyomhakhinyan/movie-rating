package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.MovieNotFoundException;
import aca.demo.movierating.review.ReviewNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler
  public ResponseEntity<ErrorResponse> handle(MovieNotFoundException ex) {
        ErrorResponse errorResponse =new ErrorResponse(1001,ex.getMessage(),null);
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler
   public ResponseEntity<ErrorResponse> handle(IllegalArgumentException ex) {
        ErrorResponse errorResponse =new ErrorResponse(1002,ex.getMessage(),null);
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler
   public ResponseEntity<ErrorResponse> handle(RuntimeException ex) {
        ErrorResponse errorResponse =new ErrorResponse(1100,ex.getMessage(),null);
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(ReviewNotFoundException ex){

        ErrorResponse errorResponse =new ErrorResponse(1003,ex.getMessage(),null);
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(400).body(errorResponse);
    }


}
