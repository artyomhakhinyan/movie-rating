package aca.demo.movierating;
import aca.demo.movierating.movie.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@Slf4j

public class MovieRatingApplication {

	public static void main(String[] args) {



	var applicationContext= SpringApplication.run(MovieRatingApplication.class, args);
	var movieService = applicationContext.getBean(MovieService.class);
//		movieService.create(new CreateMovie("Forest Gumb",Genre.DRAMA));
//		movieService.create(new CreateMovie("Horrible Bosses",Genre.COMEDY));
//		movieService.create(new CreateMovie(" American Beauty",Genre.DRAMA));
//
//		log.debug("Drama movies are{}",movieService.search(Genre.DRAMA).toString());
//		log.debug("Romace movies are{}",movieService.search(Genre.ROMANCE).toString());
//		try{movieService.create(new CreateMovie("Forest Gumb",Genre.COMEDY));}
//		catch(IllegalArgumentException e){
//			log.info("the movie already exists");
//		}




	}


}
