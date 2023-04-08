package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> search(Genre genre) {
        log.debug("Starts MovieService.search() method with genre{}",genre);
        return movieRepository.findByGenre(genre);

    }
    public void create(CreateMovie createMovie) {
        log.debug("Starts MovieService.create() method with movie{}",createMovie.toString());
        if(movieRepository.findByTitle(createMovie.getTitle()).isPresent())
            throw new IllegalArgumentException();
        movieRepository.save(createMovie);
    }


}
