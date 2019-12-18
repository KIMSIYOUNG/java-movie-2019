package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int ZERO = 0;

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public boolean canReserve(){
        int sumOfSchedule = ZERO;
        for (PlaySchedule i : playSchedules){
            sumOfSchedule += i.getCapacity();
        }
        return sumOfSchedule != ZERO;
    }

    public boolean canReserve(int time, int howMany){
        return getPlaySchedules().get(time).getCapacity() >= howMany;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}
