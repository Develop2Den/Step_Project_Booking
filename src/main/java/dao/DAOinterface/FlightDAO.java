
package DAO.DAOinterface;

import entity.Flight;

import java.util.List;
import java.util.Set;

public interface FlightDAO {

    Set<entity.Flight> getAllFlights();

    Flight getFlightByFlightNumber(String flightNumber);

    boolean deleteFlight(int index);

    boolean deleteFlight(Flight flight);

    void saveFlight(Flight flight);

    int getAllSeats(Flight flight);

    int getAvailableSeats(Flight flight);

    int getBookedSeats(Flight flight);

    void addFlight();

    void displayAllFlights();

    void displayAllFlights(List<Flight> flights);

    Set<Flight> generateRandomFlights();

    void loadData(Set<Flight> flights);

}
