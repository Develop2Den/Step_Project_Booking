package PackageMenu;

import ErrorException.InvalidMenuItemException;
import controller.BookingController;
import controller.FlightController;
import dto.BookingFlightDTO;
import dto.SearchFlightDTO;
import entity.Flight;
import entity.Passenger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleClass {
    BookingController bookingController;
    FlightController flightController;
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
        System.out.println("Введіть пункт призначення: ");
        return scanner.nextLine();
    }
    public void setFlightNumber() {
        System.out.println("Введіть номер рейсу: ");
        String flightId = scanner.nextLine();
        flightController.getFlightByFlightNumber(flightId);
    }
    public void setReservationId() {
        System.out.println("Введіть ID бронювання: ");
        int reservationId = scanner.nextInt();
        bookingController.cancelBooking(reservationId);
    }
    public int setCountPassengers() {
        System.out.println("Введіть кількість пасажирів: ");
        return scanner.nextInt();
    }
    public String setDate() {
        System.out.println("Введіть дату рейсу (в форматі dd/MM/yyyy): ");
        return scanner.nextLine();
    }
    public void flightDetails() throws InvalidMenuItemException {
        String dest = setDestination();
        String date = setDate();
        int countPassengers = setCountPassengers();
        SearchFlightDTO infoFlight = new SearchFlightDTO(dest, date, countPassengers);
//        List<Flight> flightList = flightController.searchFlight(infoFlight);
//        if (flightList.isEmpty()) {
//            System.out.println("Немає відповідних рейсів!");
//            return;
//        }
//        IntStream.range(0, flightList.size())
//                .mapToObj(index -> (index + 1) + ". " + flightList.get(index))
//                .forEach(System.out::println);
//        System.out.print("Виберіть рейс (або натисніть 0 для виходу): ");
//        int choice = scanner.nextInt();
//        if (choice == 0) {
//            return;
//        } else if (choice < 0 || choice > flightList.size()) {
//            throw new InvalidMenuItemException("Будь-ласка введіть коректне значення!");
//            return;
//        }
//        Flight selectedFlight = flightList.get(choice - 1);
//
//        IntStream.range(0, countPassengers)
//                .forEach(i -> {
//                    String name = setName();
//                    String surname = setSurname();
//                    bookingController.createNewBooking(new BookingFlightDTO(name,surname, selectedFlight));
//                });
    }
    public void fullName() {
        bookingController.displayAllBookingByPassenger(new Passenger(setName(),setSurname()));
    }
    public void onlineScoreboard() {
        System.out.println("Список рейсів: ");
        flightController.displayAllFlights();
        System.out.println("==========================================================================================");
    }

    public boolean authenticate() {
        Map<String, String> users = null;
        System.out.print("Введіть логин: ");
        String username = scanner.nextLine().trim();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine().trim();

        return users.containsKey(username) && users.get(username).equals(password);
    }
}
