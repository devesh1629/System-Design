import enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatreId;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show> shows = new ArrayList<>();
    public int getTheatreId() { return theatreId; }
    public void setTheatreId(int theatreId) { this.theatreId = theatreId; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public List<Screen> getScreens() { return screens; }
    public void setScreens(List<Screen> screens) { this.screens = screens; }
    public List<Show> getShows() { return shows; }
    public void setShows(List<Show> shows) { this.shows = shows; }
    public Screen getScreenById(int id) {
        for(Screen screen : screens) {
            if(screen.getScreenId() == id)
                return screen;
        }
        return null;
    }
    public Show getShowById(int id) {
        for(Show show : shows) {
            if(show.getShowId() == id)
                return show;
        }
        return null;
    }

}
