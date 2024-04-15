package entity;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author Alexander Isai on 14.04.2024.
 */
public class Booking {

    private AtomicInteger id;
    private Passenger passenger;
    //private Flight flight;
    //TODO уточнить тип данных, раскомментировать код ниже

    public Booking() {
    }


//    public Booking(AtomicInteger id, Passenger passenger, Flight flight) {
//        this.id = id;
//        this.passenger = passenger;
//        this.flight = flight;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Booking booking = (Booking) o;
//        return Objects.equals(id, booking.id) && Objects.equals(passenger, booking.passenger) && Objects.equals(flight, booking.flight);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, passenger, flight);
//    }

//    @Override
//    public String toString() {
//        return "Booking{" +
//                "id=" + id +
//                ", passenger=" + passenger +
//                ", flight=" + flight +
//                '}';
//    }
}
