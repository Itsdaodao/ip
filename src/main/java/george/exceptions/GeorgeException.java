package george.exceptions;

public class GeorgeException extends Exception {
    public GeorgeException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ARE YOU BANANAS?! " + getMessage();
    }
}
