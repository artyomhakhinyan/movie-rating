package aca.demo.movierating.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MovieRepository {
    private List<Movie> movies = new ArrayList<>();
    public Optional<Movie> findByTitle(String title) {
        log.debug("Starts findByTitle method with title{}",title);
        return movies.stream().filter(movie->movie.getTitle().equals(title)).findAny();
    }
    public List<Movie> findByGenre(Genre genre) {
        log.debug("Starts MovieRepository.findByGenre() method with genre{}",genre);
        return movies.stream().filter(movie->movie.getGenre().equals(genre)).collect(Collectors.toList());
    }
    public void save(CreateMovie createMovie) {
        log.debug("Starts MovieRepository.save() method with movie{}",createMovie.toString());
        Movie movie=new Movie(createMovie);
        movies.add(movie);
    }

}
