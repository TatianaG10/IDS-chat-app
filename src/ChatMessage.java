public class ChatMessage {
    private String message;
    private int from;
    private int to;

    public ChatMessage(String content, int machineFrom, int machineTo)
    {
        message = content;
        from = machineFrom;
        to = machineTo;
    }

    public int getExpediter()
    {
        return from;
    }

    public int getReceiver()
    {
        return to;
    }

    public String getContent()
    {
        return message;
    }
}
