package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();

    public Optional<Movie> findById(Long id) {
        log.debug("Starts findById method with id -{}",id);
        return movies.stream().filter(movie->movie.getTitle().equals(id)).findAny();
    }


    public void persist(Movie movie) {
        log.debug("Starts persist method with movie -{}",movie);
        movies.add(movie);
    }

    void delete(Movie movie) {
        log.debug("Starts delete method with movie -{}",movie);
     Optional<Movie> movieOptional=movies.stream().filter(movie1->movie1.getId().equals(movie.getId())).findAny();
     if(movieOptional.isPresent())
        movies.remove(movie);
    }


    List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
            log.debug("Starts search method with genre-{},title-{},released before-{},released after-{}",
                    title,genre,releasedBefore,releasedAfter);
          return movies.stream().filter(movie ->
                   ( title==null ||movie.getTitle().equals(title))&&
                   (genre==null || movie.getGenre().equals(genre))&&
                   (releasedBefore==null ||movie.getReleasedAt().compareTo(releasedBefore)>=0)&&
                   ( releasedAfter==null ||movie.getReleasedAt().compareTo(releasedBefore)<=0) ).
                  collect(Collectors.toUnmodifiableList());


    }

}
