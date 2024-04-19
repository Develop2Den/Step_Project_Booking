package PackageMenu;

import ErrorException.InvalidMenuItemException;

import java.util.Scanner;

public class AppMenu {

    public static void main(String[] args) {
        ConsoleClass consoleClass = new ConsoleClass();
        Scanner scan = new Scanner(System.in);
//        boolean isLogin = false;
        boolean isTrue = true;

        while (isTrue) {
            consoleClass.getNewMenu().forEach(System.out::println);
            System.out.println("Зробіть ваш вибір: ");
            String paragraph = scan.next().trim().toLowerCase();

            try{
                switch (paragraph) {
                    case "1":
                        consoleClass.onlineScoreboard();
                        break;
                    case "2":
                        consoleClass.setFlightNumber();
                        break;
                    case "3":
                        consoleClass.flightDetails();
                        break;
                    case "4":
                        consoleClass.setReservationId();
                        break;
                    case "5":
                        consoleClass.fullName();
                        break;
//                    case "6":
//                        isLogin = false;
//                        System.out.println("Вихід з облікового запису.");
//                        break;
                    case "7":
                        isTrue = false;
                        System.out.println("До побачення, будемо ради вас бачити знову!");
                        break;
                    default:
                        throw new InvalidMenuItemException("Будь-ласка введіть коректне значення!");
                }
            } catch (InvalidMenuItemException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
