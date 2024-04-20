
package DAO.DAOinterfaceImpl;

import DAO.DAOinterface.BookingDAO;

import entity.Booking;
import utils.fileLoader.FileBookingLoaderBin;

import java.util.*;

/**
 * description
 *
 * @author Alexander Isai on 15.04.2024.
 */
public class CollectionBookingDAO implements BookingDAO {

    private FileBookingLoaderBin bookingLoaderBin;
    private List<Booking> bookings;

    public CollectionBookingDAO() {
        this.bookingLoaderBin = new FileBookingLoaderBin();

        this.bookings = getAllBooking();
    }
    @Override
    public Booking getBookingById(int id) {
        Optional<Booking> booking = bookings.stream()
                .filter(bk -> bk != null && bk.getId() == id)
                .findFirst();
        return booking.orElse(null);
    }

    @Override
    public void saveBooking(Booking booking) {
        if (booking == null){
            System.out.println("Якась дурня");
        }
        int index = bookings.indexOf(booking);
        if (index >= 0) {
            bookings.set(index, booking);
        } else {
            bookings.add(booking);
        }
        bookingLoaderBin.loadData(bookings);
    }

    @Override
    public void cancelBooking(Booking booking) {
        if (booking == null){
            System.out.println("Видалення неможливе");
        } else {
            bookings.remove(booking);
            bookingLoaderBin.loadData(bookings);
        }
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingLoaderBin.getDataFromFile();
    }

}
