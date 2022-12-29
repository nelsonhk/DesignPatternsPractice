package ses;

public class EmailResult {

    public String message;
    public String timestamp;

    public EmailResult() {};

    public EmailResult(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
