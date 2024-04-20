package service.serviseInterfaceImpl;
import DAO.DAOinterface.BookingDAO;

import dto.BookingFlightDTO;
import entity.Booking;
import entity.Passenger;
import service.serviseInterface.BookingService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author Alexander Isai on 16.04.2024.
 */
public class BookingServiceImpl implements BookingService {
    private BookingDAO bookingDAO;

    public BookingServiceImpl(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    int createBookingId(){
        return getAllBookings().stream()
                .filter(Objects::nonNull)
                .mapToInt(Booking::getId)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public void createNewBooking(BookingFlightDTO bookingFlightDTO) {
        Passenger passenger = new Passenger(bookingFlightDTO.getName(), bookingFlightDTO.getSurname());
        int index = getAllPassengers().indexOf(passenger);
        if(index >= 0){
            passenger = getAllPassengers().get(index);
        }
        Booking booking = new Booking(passenger, bookingFlightDTO.getFlight(), createBookingId());
        System.out.println("Booking for passenger " + passenger);
        passenger.addBooking(booking);
        bookingDAO.saveBooking(booking);
    }

    @Override
    public List<Booking> getAllBookingByPassenger(Passenger passenger) {
        List<Booking> aaa = getAllBookings();
        System.out.println(aaa);

        List<Booking> bbb = bookingDAO.getAllBooking().stream()
                .filter(booking -> booking != null && booking.getPassenger().equals(passenger))
                .toList();

        System.out.println(bbb);
        return bbb;
    }

    @Override
    public <T> void displayItems(List<T> items) {
        AtomicInteger i = new AtomicInteger(1);
        items.forEach(item -> System.out.println(i.getAndIncrement() + ". " + item));
    }

    @Override
    public void cancelBooking(int id) {
        bookingDAO.cancelBooking(bookingDAO.getBookingById(id));
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return bookingDAO.getAllBooking().stream()
                .filter(Objects::nonNull)
                .map(Booking::getPassenger)
                .toList();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBooking();
    }
}
