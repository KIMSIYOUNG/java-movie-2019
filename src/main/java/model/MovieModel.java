package model;

import java.io.IOException;
import java.util.List;

import domain.Movie;
import view.InputView;
import view.OutputView;

public class MovieModel {
    private static List<Movie> movies;
    private static InputView inputView;

    public MovieModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void reserve() throws IOException {
        inputView = new InputView(movies);
        inputMovieId();
        int movieId = inputView.inputMovieId();
        OutputView.printSelectedMovie(movies, movieId);
        int movieTime = inputMovieTime(movieId);

    }

    private void inputMovieId() {


    }

    private int inputMovieTime(int movieId) throws IOException {
        int movieTime = 0;
        for (Movie movie : movies) {
            movieTime = inputMovieTime(movieId, movieTime, movie);
        }
        return movieTime;
    }

    private int inputMovieTime(int movieId, int movieTime, Movie movie) throws IOException {
        if (movie.getId() == movieId) {
            movieTime = InputView.inputMovieTime(movie);
        }
        return movieTime;
    }
}
