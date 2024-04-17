package PackageMenu;

import controller.BookingController;
import dto.BookingFlightDTO;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleClass {
    BookingController bookingController;
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
    public int setFlightId() {
        System.out.println("Введіть ID рейсу: ");
        int flightId = scanner.nextInt();
        System.out.println("Данні введено, дякуємо!");
        return flightId;
    }
    public void setReservationId() {
        System.out.println("Введіть ID бронювання: ");
        int reservationId = scanner.nextInt();
        System.out.println("Данні введено, дякуємо!");
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
    public void flightDetails() {
        setDestination();
        scanner.nextLine();
        setDate();
        setCountPassengers();
        System.out.println("Данні введено, дякуємо!");
//        bookingController.createNewBooking(new BookingFlightDTO(setName(),setSurname(),));
    }
    public void fullName() {
        setName();
        scanner.nextLine();
        setSurname();
        System.out.println("Данні введено, дякуємо!");
    }
    public void onlineScoreboard() {
        System.out.println("Список рейсів: ");

        System.out.println("==========================================================================================");
    }
}
