import java.rmi.*;
import java.util.ArrayList;

public interface ChatDiscussion_itf extends Remote {
    public ArrayList<ChatMessage> getListMessages() throws RemoteException;
    public void addNewMessage(ChatMessage message) throws RemoteException;
}
