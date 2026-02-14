import java.rmi.RemoteException;
import java.util.ArrayList;

public class ChatDiscussion implements ChatDiscussion_itf {
    public ArrayList<ChatMessage> listMessages;

    public ChatDiscussion()
    {
        listMessages = new ArrayList<ChatMessage>();
    }
    
    public ArrayList<ChatMessage> getListMessages() throws RemoteException {
        return listMessages;
    }

    public void addNewMessage(ChatMessage message) throws RemoteException {
        // TODO: Protect this critical section
        listMessages.add(message);
    }
}
