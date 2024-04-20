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
        String flightNumber = "DAMD5464";
        flightServiceImpl.loadData();
        Flight flight = flightController.getFlightByFlightNumber(flightNumber);
        System.out.println(flight);
        assertEquals(flight.getFlightNumber(), flightNumber);
    }

    @Test
    void getAllFlightDetails() {
        String flightNumber = "DSPG5494";
        flightServiceImpl.loadData();
        Flight flight = flightController.getFlightByFlightNumber(flightNumber);
        System.out.println(flightController.getSpecificFlightDetails(flight));
    }
}
