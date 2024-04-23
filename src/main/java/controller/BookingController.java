package controller;
import dto.BookingFlightDTO;
import entity.Passenger;
import service.serviseInterface.BookingService;
/**
 * Controller class responsible for handling user interactions related to bookings.
 * It delegates calls to the BookingService to process business logic operations.
 * @author Alexander Isai on 16.04.2024.
 */
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void createNewBooking(BookingFlightDTO bookingFlightDTO){
        bookingService.createNewBooking(bookingFlightDTO);
    }
    public void displayAllBookingByPassenger(Passenger passenger){
        bookingService.displayItems(bookingService.getAllBookingByPassenger(passenger));
    }
    public void displayAllBookings(){
        bookingService.displayItems(bookingService.getAllBookings());
    }
    public void displayAllPassengers(){
        bookingService.displayItems(bookingService.getAllPassengers());
    }
    public void cancelBooking(int id){bookingService.cancelBooking(id);}
    public Passenger getActivePassenger(String name, String surname, String password){
        return bookingService.getActivePassenger(name, surname, password);
    }
}
