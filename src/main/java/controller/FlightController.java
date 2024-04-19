package controller;

import dto.SearchFlightDTO;
import dto.SearchFlightDTO2;
import entity.Flight;
import service.serviseInterfaceImpl.FlightServiceImpl;
import java.util.List;
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

    public int getAllSeats(Flight flight) {
        return flightServiceImpl.getAllSeats(flight);
    };

    public int getAvailableSeats(Flight flight) {
        return flightServiceImpl.getAvailableSeats(flight);
    };

    public int getBookedSeats(Flight flight) {
        return flightServiceImpl.getBookedSeats(flight);
    };

    public void addFlight() {
        flightServiceImpl.addFlight();
    };

    public void displayAllFlights() {
        flightServiceImpl.displayAllFlights();
    };

    public void displayAllFlights(List<Flight> flights) {
        flightServiceImpl.displayAllFlights(flights);
    }

    public List<Flight> searchFlight(SearchFlightDTO2 searchFlightDTO) { return flightServiceImpl.searchFlight(searchFlightDTO);}
}
