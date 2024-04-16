package DTO;

import java.util.Objects;

/**
 * This is a DTO file for transferring information
 * from the user (name, surname, number of passengers)
 * to the matching flight search service.
 * @author Alexander Isai on 14.04.2024.
 */
public class BookingFlightDTO {

    private String name;
    private String surname;
    private int passQuantity;

    public BookingFlightDTO(String name, String surname, int passQuantity) {
        this.name = name;
        this.surname = surname;
        this.passQuantity = passQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingFlightDTO that = (BookingFlightDTO) o;
        return passQuantity == that.passQuantity && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, passQuantity);
    }

    @Override
    public String toString() {
        return "BookingFlightDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passQuantity=" + passQuantity +
                '}';
    }
}
