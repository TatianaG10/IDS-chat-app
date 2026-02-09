import java.rmi.*;

public interface Chat_itf extends Remote {
    public void sendMessage(ChatMessage message) throws RemoteException;
    public void connectToChat(ClientInfo_itf client) throws RemoteException;
    public ChatMessage getLastMessage() throws RemoteException;
}
