import java.rmi.*;
import java.util.ArrayList;

public interface Chat_itf extends Remote {
    public void sendMessage(ChatMessage message) throws RemoteException;
    public void connectToChat(ClientInfo_itf client) throws RemoteException;
    public void disconnectFromChat(ClientInfo_itf client) throws RemoteException;
    public ArrayList<ChatMessage> getListMessages() throws RemoteException;
}
