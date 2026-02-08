import java.rmi.*;
import java.util.ArrayList;

public interface ClientRegistry_itf extends Remote {
    public void register(ClientInfo_itf client) throws RemoteException;
    public boolean isregistered(ClientInfo_itf client) throws RemoteException;
    public ArrayList<ClientInfo_itf> getClientList() throws RemoteException;
}
