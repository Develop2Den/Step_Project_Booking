package DAO.DAOinterfaceImpl;

import DAO.DAOinterfaceImpl.CollectionFlightDAO;
import DAO.DAOinterface.FlightDAO;
import entity.Flight;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CollectionFlightDAOTest {

    @Test
    public void collectionFlightGenerateRandomFlightsTest() {
        FlightDAO collectionFlightDAO = new CollectionFlightDAO();
        Set<Flight> flights = collectionFlightDAO.generateRandomFlights();
        assertTrue("The list of flights is empty", flights.size() > 0);
        flights.forEach(System.out::println);
    }
}
