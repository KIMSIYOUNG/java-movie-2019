package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<ReservedMovie> reservedMovies = new ArrayList<>();

    public void addMovie(Movie movie, PlaySchedule playSchedule, int howMany){
        reservedMovies.add(new ReservedMovie(movie,playSchedule,howMany));
    }

    public int howMuchShouldPay(){
        int totalMoney = 0;
        for (ReservedMovie reservedMovie : reservedMovies){
            totalMoney += reservedMovie.sumOfPayment();
        }
        return totalMoney;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(ReservedMovie reservedMovie : reservedMovies){
            sb.append(reservedMovie.toString());
        }
        return sb.toString();
    }
}
