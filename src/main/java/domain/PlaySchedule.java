package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final int ZERO = 0;
    private final LocalDateTime startDateTime;
    private int capacity;
    private int buyingCount = 0;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBuyingCount() {
        return buyingCount;
    }

    public void decreaseReservedCapacity(int howMany){
        capacity = capacity - howMany;
        buyingCount += howMany;
    }

    public boolean canReserve(int howMany){
        return capacity >= howMany;
    }

    public boolean canReserve(){
        return capacity >= ZERO;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String scheduleInfo(){
        return "시작시간 : " +format(startDateTime);
    }
}
