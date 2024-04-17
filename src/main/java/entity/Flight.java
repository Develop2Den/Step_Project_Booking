package entity;

import entity.enums.AviaCompany;
import entity.enums.City;

import java.sql.Time;
import java.util.Date;

public class Flight {

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
        this.flightNumber = getFlightNumber();
        count++;
    }

    public String getFlightNumber() {
        this.flightNumber = String.valueOf(aviaCompany) + destination + count;
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

    @Override
    public String toString() {
        return "Flight [ " +
                "aviaCompany = " + aviaCompany +
                ", flightNumber = '" + flightNumber + '\'' +
                ", date = " + date +
                ", duration = " + duration +
                ", destination = " + destination +
                ", plane = " + plane +
                " ]";
    }
}
