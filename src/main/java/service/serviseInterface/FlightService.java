package service.serviseInterface;

import entity.Flight;
import java.util.Set;

public interface FlightService {

    Set<Flight> getAllFlights();
    Flight getFlightByFlightNumber(String flightNumber);
    boolean deleteFlight(int index);
    boolean deleteFlight(Flight flight);
    void saveFlight(Flight flight);
    int getAllSeats();
    int getAvailableSeats();
    int getBookedSeats();
    void addFlight(Flight flight);
    void displayAllFlights();
    void loadData();
    void sendData(String filePath);
}
