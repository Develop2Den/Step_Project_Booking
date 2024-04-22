package PackageMenu;

import ErrorException.FlightException;
import ErrorException.InvalidMenuItemException;
import controller.BookingController;
import controller.FlightController;
import dto.BookingFlightDTO;
import dto.SearchFlightDTO2;
import entity.Flight;
import entity.Passenger;
import entity.enums.City;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static utils.DateConverter.stringToDate;

public class ConsoleClass {
    private final FlightController flightController;
    private final BookingController bookingController;

    public ConsoleClass(FlightController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    Scanner scanner = new Scanner(System.in);
    private List<String> newMenu = new Menu().menu.collect(Collectors.toList());
    public List<String> getNewMenu() {
        return newMenu;
    }

    public String setName() {
        System.out.println("Введіть ваше ім'я: ");
        return scanner.nextLine();
    }
    public String setSurname() {
        System.out.println("Введіть ваше прізвище: ");
        return scanner.nextLine();
    }
    public String setDestination() {
        while (true) {
            System.out.println("Введіть пункт призначення: ");
            String input = scanner.nextLine();
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
            System.out.println(flightController.getFlightByFlightNumber(flightId));
        } catch (FlightException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public void setReservationId() {
        System.out.println("Введіть ID бронювання: ");
        String reservationId = scanner.nextLine();
        bookingController.cancelBooking(Integer.parseInt(reservationId));
    }
    public int setCountPassengers() {
        System.out.println("Введіть кількість пасажирів: ");
        String passengerCount = scanner.nextLine();
        return Integer.parseInt(passengerCount);
    }
    public Date setDate() {
        System.out.println("Введіть дату рейсу (в форматі dd/MM/yyyy hh:mm): ");
        return stringToDate(scanner.nextLine());
    }
    public void flightDetails() throws InvalidMenuItemException {
        String dest = setDestination();
        Date date = setDate();
        int countPassengers = setCountPassengers();
        SearchFlightDTO2 infoFlight = new SearchFlightDTO2(dest, date, countPassengers);
        System.out.println(infoFlight);
        List<Flight> flightList = flightController.searchFlight(infoFlight);
        if (flightList.isEmpty()) {
            System.out.println("Немає відповідних рейсів!");
            return;
        }
        IntStream.range(0, flightList.size())
                .mapToObj(index -> (index + 1) + ". " + flightList.get(index))
                .forEach(System.out::println);
        System.out.print("Виберіть рейс (або натисніть 0 для виходу): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            return;
        } else if (choice < 0 || choice > flightList.size()) {
            throw new InvalidMenuItemException("Будь-ласка введіть коректне значення!");
        }
        Flight selectedFlight = flightList.get(choice - 1);
        IntStream.range(0, countPassengers)
                .forEach(i -> {
                    String name = setName();
                    String surname = setSurname();
                    bookingController.createNewBooking(new BookingFlightDTO(name,surname, selectedFlight));
                });
    }
    public void fullName() {
        bookingController.displayAllBookingByPassenger(new Passenger(setName(),setSurname()));
    }
    public void onlineScoreboard() {
        System.out.println("Список рейсів: ");
        flightController.displayAllFlights();
        System.out.println("==========================================================================================");
    }

//    public boolean authenticate() {
//        Map<String, String> users = null;
//        System.out.print("Введіть логин: ");
//        String username = scanner.nextLine().trim();
//        System.out.print("Введіть пароль: ");
//        String password = scanner.nextLine().trim();
//
//        return users.containsKey(username) && users.get(username).equals(password);
//    }
}
