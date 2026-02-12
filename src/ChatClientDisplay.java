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
                System.out.println("Message From: " + clientInfo.getLastMessage().getExpediter());
                System.out.println(clientInfo.getLastMessage().getContent());
            } 
            catch (Exception e) {
                System.out.println("Error in ChatClientDisplay.run(): " + e);
                e.printStackTrace();
            }
        }
    }
    
}
