package service.serviseInterfaceImpl;

import DAO.DAOinterface.FlightDAO;
import entity.Flight;
import service.serviseInterface.FlightService;
import utils.fileLoader.FileLoaderBin;

import java.io.IOException;
import java.util.Set;

public class FlightServiceImpl implements FlightService {
    private FlightDAO flightsDAO;
    private final String filePath = "flights.bin";

    public FlightServiceImpl(FlightDAO flightsDAO) {
        this.flightsDAO = flightsDAO;
    }

    @Override
    public Set<Flight> getAllFlights() {
        return flightsDAO.getAllFlights();
    };

    @Override
    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightsDAO.getFlightByFlightNumber(flightNumber);
    };

    @Override
    public boolean deleteFlight(int index) {
        return flightsDAO.deleteFlight(index);
    };

    @Override
    public boolean deleteFlight(Flight flight) {
        return flightsDAO.deleteFlight(flight);
    };

    @Override
    public void saveFlight(Flight flight) {
        flightsDAO.saveFlight(flight);
    };

    @Override
    public int getAllSeats() {
        return flightsDAO.getAllSeats();
    };

    @Override
    public int getAvailableSeats() {
        return flightsDAO.getAvailableSeats();
    };

    @Override
    public int getBookedSeats() {
        return flightsDAO.getBookedSeats();
    };

    @Override
    public void addFlight(Flight flight) {
        flightsDAO.addFlight(flight);
    };

    @Override
    public void displayAllFlights() {
        flightsDAO.displayAllFlights();
    };

    @Override
    public void loadData() {
        FileLoaderBin fileLoaderBin = new FileLoaderBin();
        Set<Flight> objects;
        try {
            objects = fileLoaderBin.readFile(filePath);
            flightsDAO.loadData(objects);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void sendData(String filePath) {
        FileLoaderBin fileLoaderBin = new FileLoaderBin();
        try {
            Set<Flight> flights = flightsDAO.generateRandomFlights();
            fileLoaderBin.writeFile(filePath, flights);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
