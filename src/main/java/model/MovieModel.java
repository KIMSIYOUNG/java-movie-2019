package model;

import java.io.IOException;
import java.util.List;

import domain.Movie;
import domain.User;
import utils.MoreOrStop;
import view.InputView;
import view.OutputView;

public class MovieModel {
    private static List<Movie> movies;
    private static InputView inputView;
    private static User user;

    public MovieModel(List<Movie> movies) {
        user = new User();
        this.movies = movies;
        inputView = new InputView(movies);
    }

    public void reserve() throws IOException {
        do {
            inputAndAddToUser();
        } while (!inputView.moreOrStop());
    }

    private void inputAndAddToUser() throws IOException {
        int movieId = inputView.inputMovieId();
        OutputView.printSelectedMovie(movies, movieId);
        int movieTime = inputMovieTime(movieId);
        int howMany = inputView.inputHowManyPeople(movieId, movieTime);
        for(int i =0; i< howMany; i++){
            user.addMovie(getMovieById(movieId),movieTime);
        }
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

    private Movie getMovieById(int movieId) {
        for(Movie movie : movies){
            movieIdCompareToUserInput(movieId, movie);
        }
        return null;
    }

    private Movie movieIdCompareToUserInput(int movieId, Movie movie) {
        if(movie.getId()==movieId){
            return movie;
        }
        return null;
    }
}
