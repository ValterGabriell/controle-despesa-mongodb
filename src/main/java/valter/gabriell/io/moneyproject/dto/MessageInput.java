package valter.gabriell.io.moneyproject.dto;

public class MessageInput {
    private String from;
    private String to;
    private String body;
    private String subject;

    public MessageInput(String from, String to, String body, String subject) {
        this.from = from;
        this.to = to;
        this.body = body;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "MessageInput{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
