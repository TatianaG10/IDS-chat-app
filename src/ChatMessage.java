public class ChatMessage {
    private String message;
    private ClientInfo_itf from;

    public ChatMessage(String content, ClientInfo_itf sender)
    {
        message = content;
        from = sender;
    }

    public ClientInfo_itf getExpediter()
    {
        return from;
    }

    public String getContent()
    {
        return message;
    }
}
