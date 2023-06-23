import enums.City;
import enums.Movie;

public class Utils {
    public Movie getMovieByName(String userMovie) {
        for(Movie movie : Movie.values()) {
            if((movie.name()).equals(userMovie))
                return movie;
        }
        return null;
    }
    public City getCityByName(String userCity) {
        for (City city : City.values()) {
            if (city.name().equals(userCity))
                return city;
        }
        return null;
    }
}
