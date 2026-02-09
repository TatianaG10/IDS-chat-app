import java.rmi.RemoteException;

public class ChatDiscussion implements ChatDiscussion_itf {
    public ChatMessage lastMessage;

    public ChatMessage getLastMessage() throws RemoteException {
        return lastMessage;
    }

    public void updateLastMessage(ChatMessage message) throws RemoteException {
        lastMessage = message;
    } 
}
