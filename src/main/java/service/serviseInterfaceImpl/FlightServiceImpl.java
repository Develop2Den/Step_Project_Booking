package service.serviseInterfaceImpl;

import DAO.DAOinterface.FlightDAO;
import dto.SearchFlightDTO2;
import entity.Flight;
import service.serviseInterface.FlightService;
import utils.fileLoader.FileLoaderBin;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public int getAllSeats(Flight flight) {
        return flightsDAO.getAllSeats(flight);
    };

    @Override
    public int getAvailableSeats(Flight flight) {
        return flightsDAO.getAvailableSeats(flight);
    };

    @Override
    public int getBookedSeats(Flight flight) {
        return flightsDAO.getBookedSeats(flight);
    };

    @Override
    public void addFlight() {
        flightsDAO.addFlight();
    };

    @Override
    public void displayAllFlights() {
        flightsDAO.displayAllFlights();
    };

    @Override
    public void displayAllFlights(List<Flight> flights) {
        flightsDAO.displayAllFlights(flights);
    }

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

    @Override
    public void saveData() {
        // TO DO
    }

    @Override
    public List<Flight> searchFlight(SearchFlightDTO2 searchFlightDTO) {
        return flightsDAO.getAllFlights().stream().filter(flight -> {
            String city = flight.getDestination().name();
            System.out.println(city);
            boolean b = (flight.getDate().getMonth()) == (searchFlightDTO.getDate().getMonth())
                    && (flight.getDate().getDate()) == (searchFlightDTO.getDate().getDate())
                    && city.equalsIgnoreCase(searchFlightDTO.getDestination())
                    && flight.getAvailableSeats() >= searchFlightDTO.getPassQuantity();
            System.out.println(b);
            return b;
        }).collect(Collectors.toList());
    }
}
