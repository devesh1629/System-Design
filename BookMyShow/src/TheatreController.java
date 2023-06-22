import enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatre;
    List<Theatre> allTheatres;

    TheatreController() {
        cityTheatre = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    void addTheatre(City city, Theatre theatre) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatre.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreShows = new HashMap<>();
        List<Theatre> theatres = cityTheatre.get(city);

        for(Theatre theatre : theatres) {
            List<Show> movieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show : shows) {
                if(show.movie.getMovieId() == movie.getMovieId()) {
                    movieShows.add(show);
                }
            }
            if(!movieShows.isEmpty())
                theatreShows.put(theatre, movieShows);
        }
        return theatreShows;
    }

}
