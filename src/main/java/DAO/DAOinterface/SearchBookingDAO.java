package DAO.DAOinterface;

import DTO.BookingFlightDTO;
import DTO.SearchFlightDTO;
import entity.Booking;
import entity.Passenger;

import java.util.List;

/**
 * It is an interface for operations related to flight search and ticket booking.
 * @author Alexander Isai on 14.04.2024.
 */
public interface SearchBookingDAO {

    //List<Flight> getAllAvailableFlights(SearchFlightDTO searchFlightDTO);
    //TODO указать тип объекта Рейс
    //Flight getSelectedFlight(int index);
    //TODO указать тип объекта Рейс
    void bookingFlight(BookingFlightDTO bookingFlightDTO);
    void cancelBooking(int id);
    List<Booking> getAllBookingByPassenger(Passenger passenger);

}
