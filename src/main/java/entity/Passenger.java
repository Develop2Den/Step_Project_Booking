package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author Alexander Isai on 14.04.2024.
 */
public class Passenger {

    private static final AtomicInteger nextId = new AtomicInteger(1);
    private int id;
    private String name;
    private String surname;
    private List<Booking> bookings;

    public Passenger(String name, String surname) {
        this.id = nextId.getAndIncrement();
        this.name = name;
        this.surname = surname;
        this.bookings = new ArrayList<>();
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        if (booking == null){
            System.out.println("Якась дурня");
        }
        int index = bookings.indexOf(booking);
        if (index >= 0) {
            bookings.set(index, booking);
        } else {
            bookings.add(booking);
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}