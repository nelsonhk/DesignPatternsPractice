package ses;

public class EmailRequest {

    public String to;
    public String from;
    public String subject;
    public String textBody;
    public String htmlBody;

    public EmailRequest() {};

    public EmailRequest(String to, String from, String subject, String textBody, String htmlBody) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.textBody = textBody;
        this.htmlBody = htmlBody;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getTextBody() {
        return textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }
}
