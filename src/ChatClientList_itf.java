import java.rmi.*;
import java.util.ArrayList;

public interface ChatClientList_itf extends Remote {
    public void connect(ClientInfo_itf client) throws RemoteException;
    public boolean isConnected(ClientInfo_itf client) throws RemoteException;
    public ArrayList<ClientInfo_itf> getClientList() throws RemoteException;
}
