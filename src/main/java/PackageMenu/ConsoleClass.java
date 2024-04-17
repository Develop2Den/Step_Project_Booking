package PackageMenu;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleClass {
    Scanner scanner = new Scanner(System.in);

     private String name;
     private String surname;
     private String destination;
     private String date;
     private String time;
     private int flightId;
     private int reservationId;
     private int countPassengers;
     private List<String> newMenu = new Menu().menu.collect(Collectors.toList());


    public List<String> getNewMenu() {
        return newMenu;
    }

    public void setNewMenu(List<String> menu) {
        this.newMenu = menu;
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        System.out.println("Введіть час рейсу (в HH:mm): ");
        String time = scanner.nextLine();
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Введіть ваше ім'я: ");
        String name = scanner.nextLine();
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname() {
        System.out.println("Введіть ваше прізвище: ");
        String surname = scanner.nextLine();
        this.surname = surname;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination() {
        System.out.println("Введіть пункт призначення: ");
        String destination = scanner.nextLine();
        this.destination = destination;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId() {
        System.out.println("Введіть ID рейсу: ");
        int flightId = scanner.nextInt();
        this.flightId = flightId;
        System.out.println("Данні введено, дякуємо!");
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId() {
        System.out.println("Введіть ID бронювання: ");
        int reservationId = scanner.nextInt();
        this.reservationId = reservationId;
        System.out.println("Данні введено, дякуємо!");
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers() {
        System.out.println("Введіть кількість пасажирів: ");
        int countPassengers = scanner.nextInt();
        this.countPassengers = countPassengers;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        System.out.println("Введіть дату рейсу (в форматі dd/MM/yyyy): ");
        String date = scanner.nextLine();
        this.date = date;
    }

    public void flightDetails() {
        setDestination();
        scanner.nextLine();
        setDate();
        setTime();
        setCountPassengers();
        System.out.println("Данні введено, дякуємо!");
    }

    public void fullName() {
        setName();
        scanner.nextLine();
        setSurname();
        System.out.println("Данні введено, дякуємо!");
    }
    public void onlineScoreboard() {
        System.out.println("Список рейсів: ");
        for (FlightDisplay.Flight flight : FlightDisplay.Flight.values()) {
            System.out.println("Рейс " + flight.getDepartureCity() + " - " + flight.getDestination() + " (" + flight.getDepartureTime() + ")");
        }
        System.out.println("==========================================================================================");
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConsoleClass{")
                .append("name='").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", destination='").append(destination).append('\'')
                .append(", date='").append(date).append('\'')
                .append(", time='").append(time).append('\'')
                .append(", flightId=").append(flightId)
                .append(", reservationId=").append(reservationId)
                .append(", countPassengers=").append(countPassengers)
                .append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleClass that = (ConsoleClass) o;
        return flightId == that.flightId &&
                reservationId == that.reservationId &&
                countPassengers == that.countPassengers &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, destination, date, time, flightId, reservationId, countPassengers);
        return result;
    }
}
