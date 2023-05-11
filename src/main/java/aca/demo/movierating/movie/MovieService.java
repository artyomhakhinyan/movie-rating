package aca.demo.movierating.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Component
public class MovieService {

    private final MovieRepository movieRepository;

   public Movie getById(Long id) {
       Optional<Movie> movie=movieRepository.findById(id);
            if(movie.isPresent()){
                return movie.get();
            }
            else
                throw new MovieNotFoundException("Movie not found");
    }

    public void create(CreateMovie createMovie) {
        if(movieRepository.findById(createMovie.getId()).isEmpty()){
            throw new IllegalArgumentException(" id already exists");
        }
        else movieRepository.persist(new Movie(createMovie));
    }

    public void update(Long id, UpdateMovie updateMovie) {
        if(movieRepository.findById(id).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        else {
            movieRepository.findById(id).get().update(updateMovie);
        }
    }

    public  void delete(Long id) {
        if(movieRepository.findById(id).isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        else movieRepository.delete(movieRepository.findById(id).get());
    }

    public List<Movie> search(Genre genre, String title, LocalDate releasedBefore, LocalDate releasedAfter) {
          return  movieRepository.search(genre, title, releasedBefore, releasedAfter);
    }



//    public List<Movie> search(Genre genre) {
//
//        log.debug("Starts MovieService.search() method with genre{}",genre);
//        return movieRepository.findByGenre(genre);
//
//    }
//    public void create(CreateMovie createMovie) {
//        log.debug("Starts MovieService.create() method with movie{}",createMovie.toString());
//        if(movieRepository.findByTitle(createMovie.getTitle()).isPresent())
//            throw new IllegalArgumentException();
//        movieRepository.save(createMovie);
//    }
//



}
