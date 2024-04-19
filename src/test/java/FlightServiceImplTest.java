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
        assertEquals(flightServiceImpl.getAllFlights().size(), CollectionFlightDAO.randomFlightsAmount);

        FlightController fc = new FlightController(flightServiceImpl);
        assertEquals(fc.getAllFlights().size(), CollectionFlightDAO.randomFlightsAmount);
    }

    @Test
    public void getFilteredFlights() {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightServiceImpl.loadData();
        flightServiceImpl.displayAllFlights();
        SearchFlightDTO2 sfdto = new SearchFlightDTO2("Amsterdam", new Date(2024, Calendar.APRIL, 16), 3);
        List<Flight> filteredFlights = flightServiceImpl.searchFlight(sfdto);
        System.out.println("Results:");
        flightServiceImpl.displayAllFlights(filteredFlights);
//        Results:
//        Flight [ aviaCompany = IA, flightNumber = 'IAAM7700', date = Wed Apr 16 07:46:00 EDT 3924, duration = 04:56:00, destination = AM, plane = Plane [  seats = 304, bookedSeats = 0, availableSeats = 304 ]  ]
//        Flight [ aviaCompany = LV, flightNumber = 'LVAM6726', date = Wed Apr 16 20:18:00 EDT 3924, duration = 01:48:00, destination = AM, plane = Plane [  seats = 79, bookedSeats = 0, availableSeats = 79 ]  ]
//        Flight [ aviaCompany = SA, flightNumber = 'SAAM5682', date = Wed Apr 16 19:03:00 EDT 3924, duration = 01:13:00, destination = AM, plane = Plane [  seats = 273, bookedSeats = 0, availableSeats = 273 ]  ]
//        Flight [ aviaCompany = AG, flightNumber = 'AGAM8560', date = Wed Apr 16 10:28:00 EDT 3924, duration = 04:03:00, destination = AM, plane = Plane [  seats = 65, bookedSeats = 0, availableSeats = 65 ]  ]
//        Flight [ aviaCompany = EL, flightNumber = 'ELAM6120', date = Wed Apr 16 21:58:00 EDT 3924, duration = 04:08:00, destination = AM, plane = Plane [  seats = 285, bookedSeats = 0, availableSeats = 285 ]  ]
//        Flight [ aviaCompany = LA, flightNumber = 'LAAM8228', date = Wed Apr 16 05:21:00 EDT 3924, duration = 02:07:00, destination = AM, plane = Plane [  seats = 65, bookedSeats = 0, availableSeats = 65 ]  ]
//        Flight [ aviaCompany = DS, flightNumber = 'DSAM5904', date = Wed Apr 16 10:11:00 EDT 3924, duration = 02:11:00, destination = AM, plane = Plane [  seats = 234, bookedSeats = 0, availableSeats = 234 ]  ]
    }

    @Test
    public void addFlightTest() {
        FlightDAO flightDAO = new CollectionFlightDAO();
        FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
        flightServiceImpl.loadData();
        flightServiceImpl.displayAllFlights();
        Flight flight = flightServiceImpl.getFlightByFlightNumber("KAVN7630");
        System.out.println("Result " + flight);
        //Result Flight [ aviaCompany = KA, flightNumber = 'KAVN7630', date = Wed Apr 02 19:36:00 EDT 3924, duration = 03:07:00, destination = VN, plane = Plane [  seats = 273, bookedSeats = 0, availableSeats = 273 ]  ]
    }
}
