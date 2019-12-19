package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int ZERO = 0;

    private final int id;
    private final String name;
    private final int price;
    private int totalBuyNumber = 0;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public int getPrice() {
        return price;
    }

    public void reserve(PlaySchedule playSchedule, int howMany){
        playSchedule.decreaseReservedCapacity(howMany);
        totalBuyNumber += howMany;
    }

    public int getTotalBuyNumber() {
        return totalBuyNumber;
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

    public String movieInfo(){
        return id + "-" + name + ", " + price + "원" +NEW_LINE;
    }

}
