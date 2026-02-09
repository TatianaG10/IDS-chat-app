import java.io.Serializable;

public class ChatMessage implements Serializable{
    private String message;
    private String from;

    public ChatMessage(String content, String sender)
    {
        message = content;
        from = sender;
    }

    public String getExpediter()
    {
        return from;
    }

    public String getContent()
    {
        return message;
    }

    public String toString()
    {
        return "ChatMessage[message=" + message + ",from=" + from + "]";
    }
}
