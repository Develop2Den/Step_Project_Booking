package service.serviseInterfaceImpl;

import DAO.DAOinterfaceImpl.CollectionFlightDAO;
import DAO.DAOinterface.FlightDAO;
import controller.FlightController;
import dto.SearchFlightDTO2;
import entity.Flight;
import org.junit.Test;
import service.serviseInterfaceImpl.FlightServiceImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightServiceImplTest {

    @Test
    public void deleteFlightsBinFileTest() {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightDAO.generateRandomFlights();
        flightServiceImpl.sendData("flights.bin");
        flightServiceImpl.loadData();
        assertTrue("The data loaded with error", flightServiceImpl.getAllFlights().size() == CollectionFlightDAO.randomFlightsAmount);
//        File generatedFile = new File("flights.bin");
//        generatedFile.delete();
    }

    @Test
    public void getAllFlights() {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightServiceImpl.loadData();
        flightServiceImpl.displayAllFlights();
        assertEquals("The flights list size is not equal to expected value", flightServiceImpl.getAllFlights().size(), CollectionFlightDAO.randomFlightsAmount);
    }
}
