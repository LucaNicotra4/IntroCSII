public class EmptyBagException extends Exception {
    public EmptyBagException() {

    }

    public EmptyBagException(String message) {
        super(message);
    }

    public EmptyBagException(Throwable t) {
        super(t);
    }

    public EmptyBagException(String message, Throwable t) {
        super(message, t);
    }
}
