package PackageMenu;

import ErrorException.FlightException;
import ErrorException.InvalidMenuItemException;
import controller.BookingController;
import controller.FlightController;
import dto.BookingFlightDTO;
import dto.SearchFlightDTO2;
import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.enums.City;
import java.io.IOException;
import java.text.ParseException;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static utils.DateConverter.stringToDate;

public class ConsoleClass {
    private final FlightController flightController;
    private final BookingController bookingController;
    Scanner scanner = new Scanner(System.in);
    private List<String> newMenu = new Menu().menu.collect(Collectors.toList());
    private Passenger passenger;

    public ConsoleClass(FlightController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public List<String> getNewMenu() {
        return newMenu;
    }

    public String setName() {
        System.out.println("Введіть ваше ім'я: ");
        return scanner.nextLine().trim();
    }
    public String setSurname() {
        System.out.println("Введіть ваше прізвище: ");
        return scanner.nextLine().trim();
    }
    public String setDestination() {
        while (true) {
            System.out.println("Введіть пункт призначення: ");
            String input = scanner.nextLine().trim();
            boolean isValidCity = Arrays.stream(City.values())
                    .map(City::name)
                    .anyMatch(cityName -> cityName.equalsIgnoreCase(input));
            if (isValidCity) {
                return input;
            } else {
                System.out.println("Введене місто не відповідає списку доступних міст. Спробуйте ще раз.");
            }
        }
    }
    public void setFlightNumber() {
        try {
            System.out.println("Введіть номер рейсу: ");
            String flightId = scanner.nextLine();
            System.out.println(flightController.getSpecificFlightDetails(flightController.getFlightByFlightNumber(flightId)));
        } catch (FlightException e) {
            System.out.println("\u001B[31m" + "Помилка: " + "\u001B[0m" + e.getMessage());
        }
    }
    public void setReservationId() {
        int count = 0;
        boolean isValid = false;

        do {
            System.out.println("Введіть ID бронювання: ");
            String reservationId = scanner.nextLine();
            try {
                count = Integer.parseInt(reservationId);
                if (count < 0) {
                    System.out.println("\u001B[31m" + "Помилка: введіть додатне ціле число." + "\u001B[0m");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + "Помилка: введіть ціле число." + "\u001B[0m");
            }
        } while (!isValid);
            Flight flight = bookingController.getFlightByBookingId(count);
            List <Integer> list =  bookingController.getBookingsIdsByPassenger(bookingController.getBookingById(count).getPassenger());
            System.out.println(list.toString());
            if (flight != null) {
                try {
                    flightController.bookSeats(flight, -1);
                    bookingController.cancelBooking(count);
                } catch (IOException e) {
                    System.out.println("\u001B[31m" + "Сталася помилка при спробі скасувати бронювання." + "\u001B[0m");
                }
            } else {
            System.out.println("\u001B[31m" + "Помилка: бронювання з ID " + count + " не знайдено." + "\u001B[0m");
        }
    }
    public int setCountPassengers() {
        int count = 0;
        boolean isValid = false;
        do {
            System.out.println("Введіть кількість пасажирів: ");
            String passengerCount = scanner.nextLine();
            try {
                count = Integer.parseInt(passengerCount);
                if (count < 0) {
                    System.out.println("\u001B[31m" + "Помилка: введіть додатне ціле число." + "\u001B[0m");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + "Помилка: введіть ціле число." + "\u001B[0m");
            }
        } while (!isValid);
        return count;
    }
    public Date setDate() {
        Date date = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Введіть дату рейсу (в форматі dd/MM/yyyy HH:mm): ");
            String inputDateStr = scanner.nextLine();
            try {
                date = stringToDate(inputDateStr);
                isValid = true;
            } catch (ParseException e) {
                System.out.println("Невірний формат дати! Повторіть введення.");
            }
        }
        return date;
    }
    public void flightDetails() throws InvalidMenuItemException {
        String dest = setDestination();
        Date date = setDate();
        int countPassengers = setCountPassengers();
        SearchFlightDTO2 infoFlight = new SearchFlightDTO2(dest, date, countPassengers);
        List<Flight> flightList = flightController.searchFlight(infoFlight);
        if (flightList.isEmpty()) {
            System.out.println("Немає відповідних рейсів!");
            return;
        }
        IntStream.range(0, flightList.size())
                .mapToObj(index -> (index + 1) + ". " + flightController.getSpecificFlightDetails(flightList.get(index)))
                .forEach(System.out::println);
        int choice;
        do {
            System.out.print("Виберіть рейс (або натисніть 0 для виходу): ");
            while (!scanner.hasNextInt()) {
                System.out.println( "\u001B[31m" + "Будь ласка, введіть число: " + "\u001B[0m");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                return;
            } else if (choice < 0 || choice > flightList.size()) {
                System.out.println( "\u001B[31m" + "Будь-ласка введіть коректне значення!" + "\u001B[0m");
            }
        } while (choice < 0 || choice > flightList.size());
        Flight selectedFlight = flightList.get(choice - 1);
        IntStream.range(0, countPassengers)
                .forEach(i -> {
                    String name = setName();
                    String surname = setSurname();
                    bookingController.createNewBooking(new BookingFlightDTO(name,surname, selectedFlight));
                });
        try {
            flightController.bookSeats(selectedFlight,countPassengers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Бронювання здійснено!");
    }
    public void fullName() {
        bookingController.displayAllBookingByPassenger(new Passenger(getPassenger().getName(), getPassenger().getSurname()));
    }
    public void onlineScoreboard() {
        System.out.println("Список рейсів: ");
        flightController.displayAllFlights();
        System.out.println("==========================================================================================");
    }
    public boolean authenticate() {
        String userName = setName();
        String userSurname = setSurname();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine().trim();

        setPassenger(bookingController.getActivePassenger(userName, userSurname, password));
        return getPassenger() != null;
    }
}
