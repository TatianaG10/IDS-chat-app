import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServer {

    public static void main(String[] args) {
        try {
            // Create a remote objects
            Chat chat = new Chat();
            Chat_itf chat_stub = (Chat_itf) UnicastRemoteObject.exportObject(chat, 0);
            ChatDiscussion disc = new ChatDiscussion();
            ChatDiscussion_itf disc_stub = (ChatDiscussion_itf) UnicastRemoteObject.exportObject(disc, 0);
            ChatClientList list = new ChatClientList();
            ChatClientList_itf list_stub = (ChatClientList_itf) UnicastRemoteObject.exportObject(list, 0);

            // Get (or start) the RMI registry on default port 1099
            Registry registry = LocateRegistry.getRegistry();

            // Register the remote object
            registry.bind("ChatService", chat_stub);
            registry.bind("ChatDiscussionService", disc_stub);
            registry.bind("ChatClientListService", list_stub);
            
            System.out.println("Server ready!");

        } catch (Exception e) {
            System.err.println("Error on server: " + e);
            e.printStackTrace();
        }
    }
}
