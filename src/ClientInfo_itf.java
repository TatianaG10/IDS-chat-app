import java.rmi.*;

public interface ClientInfo_itf extends Remote {
    public String getName() throws RemoteException;
}
