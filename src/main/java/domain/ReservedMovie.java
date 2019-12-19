package domain;

public class ReservedMovie {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int count;

    public ReservedMovie(Movie movie, PlaySchedule playSchedule, int count) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.count = count;
    }

    public int sumOfPayment(){
        return movie.getPrice() * count;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(movie.movieInfo()).append(playSchedule.scheduleInfo())
                .append("예약명수 : ").append(count);
        return sb.toString();
    }

}
