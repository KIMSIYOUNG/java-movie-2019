package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.Movie;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String ERROR_FORMAT = "잘못된 입력입니다. 다시 입력해주세요.";
    private static final String ERROR_NUMBER_INPUT = "잘못된 수를 입력하셨습니다. 다시 입력해주세요";
    private static final int ZERO = 0;
    private static final String INPUT_MOVIE_TIME = "예매할 시간표를 선택하세요. (위에서부터 1번)";
    private static final String ERROR_NO_SEATS = "그 시간은 이미 마감되었습니다. 다른 시간대를 선택해주세요.";

    private List<Movie> movieList;

    public InputView(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public int inputMovieId() throws IOException {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            return checkCanReserve(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputMovieId();
        }
    }

    private int checkCanReserve(int movieNumber) throws IOException {
        if(movieList.stream()
                .map(s->s.getId()==movieNumber)
                .collect(Collectors.toList())
                .contains(true))
            return movieNumber;
        System.out.println(ERROR_NUMBER_INPUT);
        return inputMovieId();
    }

    public static int inputMovieTime(Movie movie) throws IOException {
        System.out.println(INPUT_MOVIE_TIME);
        try {
            return checkCanReserveTheTime(Integer.parseInt(BR.readLine().trim()), movie);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputMovieTime(movie);
        }
    }

    private static int checkCanReserveTheTime(int movieTime, Movie movie) throws IOException {
        if(movie.getPlaySchedules().get(movieTime).canReserve()){
            return movieTime;
        }
        System.out.println(ERROR_NO_SEATS);
        return inputMovieTime(movie);
    }
}
