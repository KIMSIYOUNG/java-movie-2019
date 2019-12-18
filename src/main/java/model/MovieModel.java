package model;

import java.io.IOException;
import java.util.List;

import domain.Movie;
import view.InputView;
import view.OutputView;

public class MovieModel {
    List<Movie> movies;
    public MovieModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void startReservation() throws IOException {
        InputView inputView = new InputView(movies);
        int movieId = inputView.inputMovieId();
        OutputView.printSelectedMovie(movies, movieId);

    }
}
