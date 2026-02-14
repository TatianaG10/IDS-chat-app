public class ChatClientDisplay implements Runnable {
    ClientInfo clientInfo;

    public ChatClientDisplay(ClientInfo client)
    {
        clientInfo = client;
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
                    System.out.println("\nNo messages!\n");
                }
                else
                {
                    for (ChatMessage message: clientInfo.getListMessages())
                    {
                        System.out.println("\nMessage From: " + message.getExpediter());
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
