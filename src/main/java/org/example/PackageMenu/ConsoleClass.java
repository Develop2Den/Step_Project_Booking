package org.example.PackageMenu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleClass {
    Scanner scanner = new Scanner(System.in);

    String name;
    String surname;
    String destination;
    String date;
    int flightId;
    int reservationId;
    int countPassengers;
    List<String> newMenu = new Menu().menu.collect(Collectors.toList());


    public List<String> getNewMenu() {
        return newMenu;
    }

    public void setNewMenu(List<String> menu) {
        this.newMenu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Введіть ваше ім'я: ");
        String name = scanner.nextLine();
        this.name = name;
        System.out.println("Данні введено, дякуємо!");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname() {
        System.out.println("Введіть ваше прізвище: ");
        String surname = scanner.nextLine();
        this.surname = surname;
        System.out.println("Данні введено, дякуємо!");
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
        System.out.println("Введіть дату рейсу (в форматі dd/MM/yyyy HH/mm): ");
        String date = scanner.nextLine();
        this.date = date;
    }

    public void flightDetails() {
        setDestination();
        scanner.nextLine();
        setDate();
        setCountPassengers();
        System.out.println("Данні введено, дякуємо!");
    }

    public void fullName() {
        setName();
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
}
