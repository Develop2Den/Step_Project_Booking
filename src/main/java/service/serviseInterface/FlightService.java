package service.serviseInterface;

import dto.SearchFlightDTO2;
import entity.Flight;

import java.util.List;
import java.util.Set;

public interface FlightService {

    Set<Flight> getAllFlights();
    Flight getFlightByFlightNumber(String flightNumber);
    boolean deleteFlight(String flightNumber);
    boolean deleteFlight(Flight flight);
    void saveFlight(Flight flight);
    int getAllSeats(Flight flight);
    int getAvailableSeats(Flight flight);
    int getBookedSeats(Flight flight);
    void addFlight(Flight flight);
    void displayAllFlights();
    void displayAllFlights(List<Flight> flights);
    void loadData();
    void sendData(String filePath);
    void saveData();
    List<Flight> searchFlight(SearchFlightDTO2 searchFlightDTO);
}
