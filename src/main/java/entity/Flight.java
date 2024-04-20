package entity;

import entity.enums.AviaCompany;
import entity.enums.City;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Flight implements Serializable {

    private static int count = 1000;
    private AviaCompany aviaCompany;
    private String flightNumber;
    private Date date;
    private Time duration;
    private City destination;
    private Plane plane;

    public Flight(AviaCompany aviaCompany, Date date, Time duration, City destination, Plane plane) {
        this.aviaCompany = aviaCompany;
        this.date = date;
        this.duration = duration;
        this.destination = destination;
        this.plane = plane;
        this.flightNumber = setFlightNumber();
        count++;
    }

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AviaCompany getAviaCompany() {
        return aviaCompany;
    }

    public Date getDate() {
        return date;
    }

    public Time getDuration() {
        return duration;
    }

    public City getDestination() {
        return destination;
    }

    public int getSeats() {
        return plane.getSeats();
    }

    public int getAvailableSeats() {
        return plane.getAvailableSeats();
    }

    public int getBookedSeats() {
        return plane.getBookedSeats();
    }

    public void setAviaCompany(AviaCompany aviaCompany) {
        this.aviaCompany = aviaCompany;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String setFlightNumber() {
        return this.flightNumber = String.valueOf(aviaCompany) + destination + count++;
    }

    @Override
    public String toString() {
        String nameFormat = destination.name().charAt(0) + destination.name().substring(1).toLowerCase();
        return String.format("%s %s %s/%s/%s %s:%s",
                flightNumber,
                nameFormat,
                date.getDate(),
                date.getMonth(),
                date.getYear(),
                date.getHours(),
                date.getMinutes());
    }

    public String getAllFlightDetails() {
        String nameFormat = destination.name().charAt(0) + destination.name().substring(1).toLowerCase();
        return String.format("%s %s %s/%s/%s %s:%s; duration %s:%s; managed by \"%s\"; available seats: %s, booked seats: %s",
                flightNumber,
                nameFormat,
                date.getDate(),
                date.getMonth(),
                date.getYear(),
                date.getHours(),
                date.getMinutes(),
                duration.getHours(),
                duration.getMinutes(),
                aviaCompany.name(),
                plane.getAvailableSeats(),
                plane.getBookedSeats()
        );
    }
}
