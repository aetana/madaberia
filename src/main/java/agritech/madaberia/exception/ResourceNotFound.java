package agritech.madaberia.exception;

public class ResourceNotFound extends Exception {
    String message;

    public ResourceNotFound(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}