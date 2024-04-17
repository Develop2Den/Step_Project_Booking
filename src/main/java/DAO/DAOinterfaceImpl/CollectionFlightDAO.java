package DAO.DAOinterfaceImpl;

import DAO.DAOinterface.FlightDAO;
import entity.Flight;
import entity.Plane;
import entity.enums.AviaCompany;
import entity.enums.City;
import entity.enums.PlaneModel;
import utils.general.Shared;

import java.sql.Time;
import java.time.Month;
import java.util.*;

public class CollectionFlightDAO implements FlightDAO {

    private Set<Flight> flights;
    private static int zero = 0;

    public CollectionFlightDAO() {
        this.flights = new HashSet<>();
    }

    @Override
    public Set<Flight> getAllFlights() {
        return this.flights;
    }

    @Override
    public Flight getFlightByFlightNumber(String flightNumber) {
        return null;
    }

    @Override
    public boolean deleteFlight(int index) {
        return false;
    }

    @Override
    public boolean deleteFlight(Flight flight) {
        return false;
    }

    @Override
    public void saveFlight(Flight flight) {

    }

    @Override
    public int getAllSeats() {
        return 0;
    }

    @Override
    public int getAvailableSeats() {
        return 0;
    }

    @Override
    public int getBookedSeats() {
        return 0;
    }

    @Override
    public void addFlight(Flight flight) {
        // impl
        saveFlight(flight);
    }

    @Override
    public void displayAllFlights() {

    }

    @Override
    public Set<Flight> generateRandomFlights() {
        Set<Flight> randomFlights = new HashSet<>();
        int year = Shared.getCurrentYear();
        Month month = Shared.getCurrentMonth();
        Flight fl;
        while (!(randomFlights.size() == 100)) {
            int day = Shared.getRandomDay();
            int hrs = Shared.generateRandomNumber(24);
            int min = Shared.generateRandomNumber(59);
            int hrsDuration = Shared.generateRandomNumberMinMax(1, 5);
            int minDuration = Shared.generateRandomNumber(59);
            fl = new Flight(
                    AviaCompany.values()[Shared.generateRandomNumber(AviaCompany.values().length - 1)],
                    new Date(year, month.getValue() - 1, day, hrs, min, zero),
                    new Time(hrsDuration, minDuration, zero),
                    City.values()[Shared.generateRandomNumber(City.values().length - 1)],
                    new Plane(PlaneModel.values()[Shared.generateRandomNumber(PlaneModel.values().length - 1)])
            );
            randomFlights.add(fl);
        }
        this.flights = new HashSet<>();
        this.flights.addAll(randomFlights);
        //this.flights.forEach(flight -> System.out.println(flight));
        return this.flights;
    }

    @Override
    public void loadData(Set flights) {
        this.flights = new HashSet<>();
        this.flights.addAll(flights);
    }
}
