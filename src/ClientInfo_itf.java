import java.rmi.*;

public interface ClientInfo_itf extends Remote {
    public String getName() throws RemoteException;
    public void updateLastMessage(ChatMessage message) throws RemoteException;
    public void notifyMessageArrived() throws RemoteException;
}
