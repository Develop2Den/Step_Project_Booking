import DAO.DAOinterface.FlightDAO;
import DAO.DAOinterfaceImpl.CollectionFlightDAO;
import controller.FlightController;
import entity.Flight;
import org.junit.jupiter.api.Test;
import service.serviseInterfaceImpl.FlightServiceImpl;
import static org.junit.Assert.assertEquals;

import java.util.Set;

public class FlightControllerTest {
    static FlightDAO flightDAO = new CollectionFlightDAO();
    static FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
    static FlightController flightController = new FlightController(flightServiceImpl);

    @Test
    void getAllFlightsTest() {
        flightServiceImpl.loadData();
        Set<Flight> flights = flightController.getAllFlights();
        assertEquals("The list of flights is not loaded", CollectionFlightDAO.randomFlightsAmount, flights.size());
        //flights.forEach(System.out::println);
    }

    @Test
    void displayAllFlightsTest() {
        flightServiceImpl.loadData();
        flightController.displayAllFlights();
    }

    @Test
    void getFlightByFlightNumberTest() {
        String flightNumber = "SAPG5316";
        flightServiceImpl.loadData();
        Flight flight = flightServiceImpl.getFlightByFlightNumber(flightNumber);
        System.out.println(flight);
        assertEquals(flight.getFlightNumber(), flightNumber);
    }
}
