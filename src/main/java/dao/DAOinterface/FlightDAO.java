
package DAO.DAOinterface;

import entity.Flight;
import java.util.Set;

public interface FlightDAO {

    Set<entity.Flight> getAllFlights();

    Flight getFlightByFlightNumber(String flightNumber);

    boolean deleteFlight(int index);

    boolean deleteFlight(Flight flight);

    void saveFlight(Flight flight);

    int getAllSeats();

    int getAvailableSeats();

    int getBookedSeats();

    void addFlight(Flight flight);

    void displayAllFlights();

    Set<Flight> generateRandomFlights();

    void loadData(Set<Flight> flights);

}
