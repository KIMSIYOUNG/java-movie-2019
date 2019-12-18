package controller;

import java.io.IOException;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import model.MovieModel;
import view.OutputView;

public class MovieController {
    public static void play() throws IOException {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        MovieModel movieModel = new MovieModel(movies);
        movieModel.reserve();
    }
}
