import java.rmi.*;
import java.util.ArrayList;

public interface ChatDiscussion_itf extends Remote {
    public ArrayList<ChatMessage> getDiscussion(int machineA, int machineB) throws RemoteException;
    public void updateDiscussion(ChatMessage message) throws RemoteException;
}
