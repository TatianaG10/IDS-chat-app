import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Chat implements Chat_itf {

    public Chat()
    {
        System.out.println("The Chat is ready!");
    };

    public void sendMessage(ChatMessage message) throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry();

        try {
            ChatClientList_itf clientList = (ChatClientList_itf) registry.lookup("ClientRegistryService");
            if (!clientList.isConnected(message.getExpediter()))
            {
                System.out.println("Error: Can't send message, the client is not connected");
            }
            else
            {
                ChatDiscussion_itf disc = (ChatDiscussion_itf) registry.lookup("ChatDiscussionService");
                disc.updateLastMessage(message);
            }
        } catch (Exception e) {
            System.out.println("Error: problem occured when trying to send a message: " + e);
            e.printStackTrace();
        }
    }

    public void connectToChat(ClientInfo_itf client) throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry();

        try {
            ChatClientList_itf clientList = (ChatClientList_itf) registry.lookup("ClientRegistryService");
            if (clientList.isConnected(client.getName()))
            {
                System.out.println("Error: Can't connect an already connected client");
            }
            else
            {
                clientList.connect(client);
            }
        } catch (Exception e) {
            System.out.println("Error: problem occured on the Chat: " + e);
            e.printStackTrace();
        }
    }

    public void disconnectFromChat(ClientInfo_itf client) throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry();

        try {
            ChatClientList_itf clientList = (ChatClientList_itf) registry.lookup("ClientRegistryService");
            if (!clientList.isConnected(client.getName()))
            {
                System.out.println("Error: Can't disconnect a non connected client");
            }
            else
            {
                clientList.disconnect(client);
            }
        } catch (Exception e) {
            System.out.println("Error: problem occured on the Chat: " + e);
            e.printStackTrace();
        }
    }

    public ChatMessage getLastMessage() throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry();
        ChatMessage res = null;

        try {
            ChatDiscussion_itf disc = (ChatDiscussion_itf) registry.lookup("ChatDiscussionService");
            res = disc.getLastMessage();
        } catch (Exception e) {
            System.out.println("Error: problem occured on the Chat: " + e);
            e.printStackTrace();
        }

        return res;
    }
}
