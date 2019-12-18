package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printSelectedMovie(List<Movie> movies, int number){
        movies.stream().filter(s->s.getId()==number).forEach(System.out::print);
    }
}
