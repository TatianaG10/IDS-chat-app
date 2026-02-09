import java.rmi.RemoteException;

public class ClientInfo implements ClientInfo_itf {
    private String name;

    public String getName() throws RemoteException {
        return name;
    }    
}
