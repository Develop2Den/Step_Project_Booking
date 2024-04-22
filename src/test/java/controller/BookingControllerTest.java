package controller;

import dto.BookingFlightDTO;
import entity.Flight;
import entity.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.serviseInterface.BookingService;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

    @Mock
    private BookingService bookingService;
    @Mock
    private Flight flight;

    @InjectMocks
    private BookingController bookingController;

    @Test
    public void testCreateNewBooking() {
        BookingFlightDTO bookingFlightDTO = new BookingFlightDTO("Ivan", "Ivanov", flight);
        bookingController.createNewBooking(bookingFlightDTO);
        verify(bookingService).createNewBooking(bookingFlightDTO);
    }

    @Test
    public void testDisplayAllBookingByPassenger() {
        Passenger passenger = new Passenger("Ivan", "Ivanov");
        when(bookingService.getAllBookingByPassenger(passenger)).thenReturn(new ArrayList<>());

        bookingController.displayAllBookingByPassenger(passenger);
        verify(bookingService).displayItems(any());
    }

    @Test
    public void testDisplayAllBookings() {
        when(bookingService.getAllBookings()).thenReturn(new ArrayList<>());
        bookingController.displayAllBookings();
        verify(bookingService).displayItems(any());
    }

    @Test
    public void testDisplayAllPassengers() {
        when(bookingService.getAllPassengers()).thenReturn(new ArrayList<>());
        bookingController.displayAllPassengers();
        verify(bookingService).displayItems(any());
    }

    @Test
    public void testCancelBooking() {
        int bookingId = 1;
        bookingController.cancelBooking(bookingId);
        verify(bookingService).cancelBooking(bookingId);
    }
}