package entity;

import ErrorException.PlaneException;
import entity.enums.PlaneModel;

public class Plane {

    public static final int defaultSeatsAmount = 20;
    public static final String errorAmountShouldBeGreaterThan0 = "Кількість місць має бути > 0";
    public static final String errorNotEnoughFreeSeats = "Недостатньо вільних місць";
    private PlaneModel planeModel;
    private int seats;
    private int bookedSeats;

    public Plane(PlaneModel planeModel) {
        this.seats = planeModel.getSeats();
        if (this.seats < 0) throw new PlaneException(errorAmountShouldBeGreaterThan0, seats);
        this.bookedSeats = 0;
    }

    public Plane() {
        this.seats = defaultSeatsAmount;
        this.bookedSeats = 0;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public int getSeats() {
        return seats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public int getAvailableSeats() {
        return seats - bookedSeats;
    }

    public int getDefaultSeatsAmount() {
        return defaultSeatsAmount;
    }

    public void setBookedSeats(int requestedSeats) {
        int freeSeats = getAvailableSeats();
        if (requestedSeats <= 0) throw new PlaneException(errorAmountShouldBeGreaterThan0, requestedSeats);
        if (requestedSeats <= freeSeats) {
            this.bookedSeats = requestedSeats;
        } else throw new PlaneException(errorNotEnoughFreeSeats, freeSeats);
    }

    @Override
    public String toString() {
        return "Plane [ " +
                "planeModel = " + planeModel +
                ", seats = " + seats +
                ", bookedSeats = " + bookedSeats +
                ", availableSeats = " + getAvailableSeats() +
                " ] ";
    }
}
