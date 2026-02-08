import java.rmi.*;

public interface Chat_itf extends Remote {
    public void sendMessage(ClientInfo sender, ChatMessage message) throws RemoteException;
}
