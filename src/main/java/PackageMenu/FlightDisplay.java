package PackageMenu;

public class FlightDisplay {

    enum Flight {
        PARIS("Париж", "13:00"),
        LONDON("Лондон", "14:30"),
        ROME("Рим", "16:00"),
        BERLIN("Берлін", "17:45"),
        NEWYORK("New-York","18:00"),
        TORONTO("Toronto","19:00"),
        MONACO("Monaco","20:00"),
        DUBAI("Dubai","21:00"),
        WASHINGTON("Washington","22:00"),
        MALDIVES("Maldives","23:00");

        private final String destination;
        private final String departureTime;
        private final String departureCity = "Київ";

        Flight(String destination, String departureTime) {
            this.destination = destination;
            this.departureTime = departureTime;
        }

        public String getDestination() {
            return destination;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public String getDepartureCity() {
            return departureCity;
        }
    }
}


