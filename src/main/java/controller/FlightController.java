package controller;

import entity.Flight;
import service.serviseInterfaceImpl.FlightServiceImpl;

import java.util.Set;

public class FlightController {
    private final FlightServiceImpl flightServiceImpl;

    public FlightController(FlightServiceImpl flightServiceImpl) {
        this.flightServiceImpl = flightServiceImpl;
    }

    public Set<Flight> getAllFlights() {
        return flightServiceImpl.getAllFlights();
    };

    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightServiceImpl.getFlightByFlightNumber(flightNumber);
    };

    public boolean deleteFlight(int index) {
        return flightServiceImpl.deleteFlight(index);
    };

    public boolean deleteFlight(Flight flight) {
        return flightServiceImpl.deleteFlight(flight);
    };

    public void saveFlight(Flight flight) {
        flightServiceImpl.saveFlight(flight);
    };

    public int getAllSeats() {
        return flightServiceImpl.getAllSeats();
    };

    public int getAvailableSeats() {
        return flightServiceImpl.getAvailableSeats();
    };

    public int getBookedSeats() {
        return flightServiceImpl.getBookedSeats();
    };

    public void addFlight(Flight flight) {
        flightServiceImpl.addFlight(flight);
    };

    public void displayAllFlights() {
        flightServiceImpl.displayAllFlights();
    };
}
