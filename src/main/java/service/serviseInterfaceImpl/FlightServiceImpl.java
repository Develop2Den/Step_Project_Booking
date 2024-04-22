package service.serviseInterfaceImpl;

import DAO.DAOinterface.FlightDAO;
import dto.SearchFlightDTO2;
import entity.Flight;
import service.serviseInterface.FlightService;
import utils.fileLoader.FileLoaderBin;
import utils.general.Shared;

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
    public boolean deleteFlight(String flightNumber) {
        return flightsDAO.deleteFlight(flightNumber);
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
    public void addFlight(Flight flight) {
        flightsDAO.addFlight(flight);
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
        // save in data base
    }

    @Override
    public List<Flight> searchFlight(SearchFlightDTO2 searchFlightDTO) {
        int expectedYear = searchFlightDTO.getDate().getYear() + 1900;
        int expectedMonth = searchFlightDTO.getDate().getMonth() + 1;
        List<Flight> result = flightsDAO.getAllFlights()
                .stream()
                .filter(flight -> {
                    String city = flight.getDestination().name();
                    boolean b = (flight.getDate().getMonth() == expectedMonth)
                            && (flight.getDate().getYear() == expectedYear)
                            && city.equalsIgnoreCase(searchFlightDTO.getDestination())
                            ;
                    return b; })
                .filter(flight -> {
                    boolean b = ((flight.getDate().getDate() == searchFlightDTO.getDate().getDate()
                                    && flight.getDate().getHours() >= searchFlightDTO.getDate().getHours())
                                || (flight.getDate().getDate() == searchFlightDTO.getDate().getDate() + 1)
                                    && flight.getDate().getHours() < searchFlightDTO.getDate().getHours())
                            ;
                    return b; })
                .filter(flight -> flight.getAvailableSeats() >= searchFlightDTO.getPassQuantity())
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public String getSpecificFlightDetails(Flight flight) {
        return flightsDAO.getSpecificFlightDetails(flight);
    }
}
