import java.util.ArrayList;

public class ChatClientDisplay implements Runnable {
    private ClientInfo clientInfo;
    private int maxNumMessage;

    public ChatClientDisplay(ClientInfo client, int numMessagesToPrint)
    {
        clientInfo = client;
        maxNumMessage = numMessagesToPrint;
    }

    @Override
    public void run() {
        for (;;)
        {
            try 
            {
                clientInfo.getSemMessageUpdated().acquire();
                System.out.print("\033\143");
                if (clientInfo.getListMessages().size() == 0)
                {
                    System.out.println("No messages!\n");
                }
                else
                {
                    ArrayList<ChatMessage> listMessages = clientInfo.getListMessages();
                    for (ChatMessage message: listMessages.subList(Math.max(listMessages.size() - maxNumMessage, 0), listMessages.size()))
                    {
                        System.out.println("Message From: " + message.getExpediter());
                        System.out.println(message.getContent() + "\n");
                    }
                }
            } 
            catch (InterruptedException e)
            {
                System.out.println("Ending display...");
                break;
            }
            catch (Exception e) {
                System.out.println("Error in ChatClientDisplay.run(): " + e);
                e.printStackTrace();
            }
        }
    }
}
