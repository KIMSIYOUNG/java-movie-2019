package domain;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<Movie, PlaySchedule> movieAndSchedules = new HashMap<>();

    public Map<Movie, PlaySchedule> getMovieAndSchedules() {
        return movieAndSchedules;
    }

    public static void addMovie(Movie movie, int time){
        movieAndSchedules.put(movie,movie.getPlaySchedules().get(time));
    }

}
