package DAO.DAOinterface;

import java.util.List;

public interface FlightDAO<Flight> {

    public List<Flight> getAllFlights();

    public Flight getFlightByFlightNumber(String flightNumber);

    public boolean deleteFlight(int index);

    public boolean deleteFlight(Flight flight);

    public void saveFlight(Flight flight);

    public int getAllSeats();

    public int getAvailableSeats();

    public int getBookedSeats();

    public void addFlight(Flight flight);

    public void displayAllFlights();
}
