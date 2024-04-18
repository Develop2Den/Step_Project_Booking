package ErrorException;

public class FlightException extends RuntimeException {
    public FlightException(String message) {
        super(String.format("There is no flight with the flight number = %s", message));
    }
}
