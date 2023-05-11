package aca.demo.movierating.endpoint;
import aca.demo.movierating.movie.*;

import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getById(id);

    }
    @PostMapping
    public ResponseEntity create(@RequestBody CreateMovie createMovie){
      movieService.create(createMovie);
      return  ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).build();
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable Long id, @RequestBody UpdateMovie updateMovie) {
        movieService.update(id,updateMovie);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        movieService.delete(id);
    }

    @GetMapping
    public List<Movie> search(@RequestParam(required = false) Genre genre,@RequestParam(required = false) String title,
                              @RequestParam(required = false) LocalDate releasedBefore, @RequestParam(required = false) LocalDate releasedAfter) {
       return movieService.search(genre, title, releasedBefore, releasedAfter);
    }

//    @PostMapping("movies")
//    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String title=request.getParameter("title");
//        Genre genre= Genre.valueOf(request.getParameter("genre"));
//        log.info("Movie ->title {},genre {}",title,genre);
//        movieService.create(new CreateMovie(title,genre));
//        response.setStatus(200);
//        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
//        response.getWriter().println("New Movie Created");
//
//    }
//
//    @GetMapping("movies")
//    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Genre genre= Genre.valueOf(request.getParameter("genre"));
//        log.info("genre -> {}",genre);
//        List<Movie> movieList= movieService.search(genre);
//        response.setStatus(200);
//        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
//        response.getWriter().println(movieList);
//
//
//    }
}
