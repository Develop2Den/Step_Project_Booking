package service.serviseInterfaceImpl;

import DAO.DAOinterfaceImpl.CollectionFlightDAO;
import DAO.DAOinterface.FlightDAO;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightServiceImplTest {

    @Test
    public void getFlightsForSpecificDay() {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightDAO.generateRandomFlights();
        flightServiceImpl.sendData("flights.bin");
        flightServiceImpl.loadData();
        assertTrue("The data loaded with error", flightServiceImpl.getAllFlightsForSpecificDay().size() != 0);
//        flightServiceImpl.getAllFlightsForSpecificDay().forEach(flight -> {
//            System.out.println(flightServiceImpl.getSpecificFlightDetails(flight));
//        });
//        File generatedFile = new File("flights.bin");
//        generatedFile.delete();
    }

    @Test
    public void bookFlightTest() throws IOException {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightServiceImpl.loadData();
        flightServiceImpl.displayAllFlights();
        String flightNumber = "AGRM40734";
        flightServiceImpl.bookSeats(flightServiceImpl.getFlightByFlightNumber(flightNumber), 3);
        assertTrue("Seats are not booked", flightServiceImpl.getFlightByFlightNumber(flightNumber).getBookedSeats() > 0);
        System.out.println(flightServiceImpl.getSpecificFlightDetails(flightServiceImpl.getFlightByFlightNumber(flightNumber)));
    }
}
