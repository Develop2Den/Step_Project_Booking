import DAO.DAOinterface.BookingDAO;
import DAO.DAOinterface.FlightDAO;
import DAO.DAOinterfaceImpl.CollectionBookingDAO;
import DAO.DAOinterfaceImpl.CollectionFlightDAO;
import ErrorException.InvalidMenuItemException;
import PackageMenu.ConsoleClass;
import controller.BookingController;
import controller.FlightController;
import entity.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.serviseInterfaceImpl.BookingServiceImpl;
import service.serviseInterfaceImpl.FlightServiceImpl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ConsoleClassTest {
    FlightDAO flightDAO = new CollectionFlightDAO();
    FlightServiceImpl flightServiceImpl = new FlightServiceImpl(flightDAO);
    FlightController flightController = new FlightController(flightServiceImpl);

    BookingDAO bookingDAO = new CollectionBookingDAO();
    BookingServiceImpl bookingService = new BookingServiceImpl(bookingDAO);
    BookingController bookingController = new BookingController(bookingService);

    private final InputStream originalSystemIn = System.in;
    private ConsoleClass console;

    @Before
    public void setUp() {
        String input = "AMSTERDAM\n24/04/2024 10:00\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        FlightController flightController = mock(FlightController.class);
        BookingController bookingController = mock(BookingController.class);

        console = new ConsoleClass(flightController, bookingController);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }


//    @Test
//    public void testSetName() {
//        InputStream originalIn = System.in;
//        try {
//            String input = "Vasya";
//            InputStream in = new ByteArrayInputStream(input.getBytes());
//            System.setIn(in);
//            ConsoleClass myClass = new ConsoleClass(flightController, bookingController);
//            String result = myClass.setName();
//            assertEquals("Vasya", result);
//        } finally {
//            System.setIn(originalIn);
//        }
//    }
//
//    @Test
//    public void testSetSurName() {
//        InputStream originalIn = System.in;
//        try {
//            String input = "Vasya";
//            InputStream in = new ByteArrayInputStream(input.getBytes());
//            System.setIn(in);
//            ConsoleClass myClass = new ConsoleClass(flightController, bookingController);
//            String result = myClass.setSurname();
//            assertEquals("Vasya", result);
//        } finally {
//            System.setIn(originalIn);
//        }
//    }

    @Test
    public void testFlightDetails() throws InvalidMenuItemException {
        // Подготавливаем ожидаемые данные
        Flight dummyFlight = new Flight();
        List<Flight> flightList = Arrays.asList(dummyFlight);
        when(console.getFlightController().searchFlight(any())).thenReturn(flightList);

        // Вызываем тестируемый метод
        console.flightDetails();

        // Проверяем, что методы setName() и setSurname() вызывались нужное количество раз
        verify(console, times(3)).setName();
        verify(console, times(3)).setSurname();

        // Проверяем, что метод createNewBooking() вызывался нужное количество раз с правильными параметрами
        verify(console.getBookingController(), times(3)).createNewBooking(any());
    }
}
