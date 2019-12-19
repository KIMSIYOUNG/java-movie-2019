package model;

import java.io.IOException;
import java.util.List;

import domain.Movie;
import domain.User;
import view.InputView;
import view.OutputView;

public class MovieModel {
    private static final String START_PAYMENT = "결제를 시작합니다. 예약목록은 아래에 표기됩니다.";
    private static final double[] PAYMENT_METHOD = new double[]{0.95,0.97};
    private static List<Movie> movies;
    private static InputView inputView;
    private static User user;

    public MovieModel(List<Movie> movies) {
        this.movies = movies;
        user = new User();
        inputView = new InputView(movies);
    }

    public void reserve() throws IOException {
        do {
            inputAndAddToUser();
        } while (!inputView.moreOrStop());
        startPayment();
    }

    private void startPayment() {
        System.out.println(START_PAYMENT);
        System.out.println(user.toString());
        int totalPayment = user.howMuchShouldPay();
        System.out.println(totalPayment);
    }

    private void inputAndAddToUser() throws IOException {
        int movieId = inputView.inputMovieId();
        OutputView.printSelectedMovie(movies, movieId);
        int movieTime = inputMovieTime(movieId);
        int howMany = inputView.inputHowManyPeople(movieId, movieTime);
        Movie movieById = getMovieById(movieId);
        movieById.reserve(movieById.getPlaySchedules().get(movieTime),howMany);
        user.addMovie(movieById,movieById.getPlaySchedules().get(movieTime),howMany);
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
            if(movie.getId() == movieId)
                return movie;
        }
        return movies.get(movieId);
    }

//    private Movie movieIdCompareToUserInput(int movieId, Movie movie) {
//        if(movie.getId()==movieId){
//            return movie;
//        }
//        return null;
//    }
}
