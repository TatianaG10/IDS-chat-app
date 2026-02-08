import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Chat implements Chat_itf {

    public Chat()
    {
        System.out.println("The Chat is ready!");
    };

    public void sendMessage(ClientInfo sender, ChatMessage message) throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry();

        try {
            ClientRegistry_itf reg = (ClientRegistry_itf) registry.lookup("ClientRegistryService");
            if (!reg.isregistered(sender))
            {
                System.out.println("Error: Can't send message, the client is not registered");
            }
            else
            {
                ChatDiscussion_itf disc = (ChatDiscussion_itf) registry.lookup("ChatDiscussionService");
                disc.updateDiscussion(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
