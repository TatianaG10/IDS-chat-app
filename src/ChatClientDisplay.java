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
                if (clientInfo.getLastMessage() == null)
                {
                    System.out.println("\nNo messages!\n");
                }
                else
                {
                    System.out.println("\nMessage From: " + clientInfo.getLastMessage().getExpediter());
                    System.out.println(clientInfo.getLastMessage().getContent() + "\n");
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
