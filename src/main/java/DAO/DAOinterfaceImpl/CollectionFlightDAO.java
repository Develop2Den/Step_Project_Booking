package DAO.DAOinterfaceImpl;

import DAO.DAOinterface.FlightDAO;
import ErrorException.FlightException;
import entity.Flight;
import entity.Plane;
import entity.enums.AviaCompany;
import entity.enums.City;
import entity.enums.PlaneModel;
import org.jetbrains.annotations.NotNull;
import utils.general.Shared;

import java.sql.Time;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionFlightDAO implements FlightDAO {

    private Set<Flight> flights;
    private static int zero = 0;
    public static int randomFlightsAmount = 2000;

    public CollectionFlightDAO() {
        this.flights = new HashSet<>();
    }

    @Override
    public Set<Flight> getAllFlights() {
        return this.flights;
    }

    @Override
    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }


    @Override
    public Flight getFlightByFlightNumber(String flightNumber) {
        List<Flight> requiredFlight = this.flights.stream()
                .filter(flight ->
                        (flight.getFlightNumber()).equals(flightNumber))
                .toList();
        if (requiredFlight.size() == 0) throw new FlightException(flightNumber);
        return requiredFlight.get(0);
    }

    @Override
    public boolean deleteFlight(int index) {
        // TO DO
        return false;
    }

    @Override
    public boolean deleteFlight(Flight flight) {
        // TO DO
        return false;
    }

    @Override
    public void saveFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public int getAllSeats(Flight flight) {
        return flight.getSeats();
    }

    @Override
    public int getAvailableSeats(Flight flight) {
        return flight.getAvailableSeats();
    }

    @Override
    public int getBookedSeats(Flight flight) {
        return flight.getBookedSeats();
    }

    @Override
    public void addFlight() {
        // should be implementation of adding a flight from the console - change all default values to custom values
        // TO DO
        Flight flight = new Flight();
        flight.setAviaCompany(AviaCompany.BukovynaAirlines);
        flight.setDestination(City.AMSTERDAM);
        flight.setDate(new Date(2024, Calendar.MAY, 15));
        flight.setDuration(new Time(1, 45, 0));
        flight.setPlane(new Plane(PlaneModel.CRJ_200));
        flight.setFlightNumber();
        System.out.println("FLIGHT NUMBER");
        System.out.println(flight.getFlightNumber());
        saveFlight(flight);
    }

    @Override
    public void displayAllFlights() {
        for (Flight flight : this.flights) {
            System.out.println(flight);
        }
    }

    @Override
    public void displayAllFlights(@NotNull List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    @Override
    public Set<Flight> generateRandomFlights() {
        Set<Flight> randomFlights = new HashSet<>();
        int year = Shared.getCurrentYear();
        Month month = Shared.getCurrentMonth();
        Flight fl;
        while (!(randomFlights.size() == randomFlightsAmount)) {
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
        return this.flights;
    }

    @Override
    public void loadData(Set flights) {
        this.setFlights(flights);
    }
}
