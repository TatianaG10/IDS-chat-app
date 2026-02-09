import java.rmi.*;

public interface ChatDiscussion_itf extends Remote {
    public ChatMessage getLastMessage() throws RemoteException;
    public void updateLastMessage(ChatMessage message) throws RemoteException;
}
