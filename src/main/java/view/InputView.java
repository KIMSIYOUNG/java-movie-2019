package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import domain.Movie;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String ERROR_FORMAT = "잘못된 입력입니다. 다시 입력해주세요.";
    private static final String ERROR_NUMBER_INPUT = "잘못된 수를 입력하셨습니다. 다시 입력해주세요";
    private static final int ZERO = 0;
    private static final String INPUT_MOVIE_TIME = "예매할 시간표를 선택하세요. (위에서부터 1번)";

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
        if(movieNumber > ZERO && movieNumber <= movieList.size()
                && movieList.get(movieNumber).canReserve()){
            return movieNumber;
        }
        System.out.println(ERROR_NUMBER_INPUT);
        return inputMovieId();
    }

}
