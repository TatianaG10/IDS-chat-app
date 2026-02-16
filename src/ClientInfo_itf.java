import java.rmi.*;
import java.util.ArrayList;

public interface ClientInfo_itf extends Remote {
    public String getName() throws RemoteException;
    public void updateListMessages(ArrayList<ChatMessage> newListMessages) throws RemoteException;
    public void notifyMessageArrived() throws RemoteException;
}
