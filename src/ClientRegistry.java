import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientRegistry implements ClientRegistry_itf {

    @Override
    public void register(ClientInfo_itf client) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public boolean isregistered(ClientInfo_itf client) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isregistered'");
    }

    @Override
    public ArrayList<ClientInfo_itf> getClientList() throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientList'");
    }
    
}
