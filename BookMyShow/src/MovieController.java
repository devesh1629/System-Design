import enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> moviesInCity;
    List<Movie> allMovies;

    MovieController() {
        moviesInCity = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = moviesInCity.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        moviesInCity.put(city, movies);
    }

    Movie getMovieByName(String movieName) {
        for(Movie movie : allMovies) {
            if(movie.getMovieName().equals(movieName))
                return movie;
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city) {
        return moviesInCity.get(city);
    }

    void removeMovie(City city, Movie movie) {
        moviesInCity.get(city).remove(movie);
    }

}
