import domain.Movie;
import domain.MovieRepository;
import model.MovieModel;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        MovieModel movieModel = new MovieModel(movies);
        movieModel.startReservation();
        // TODO 구현 진행
    }
}
