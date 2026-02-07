import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

public class RegistryImpl implements Registry_itf {
    private ArrayList<Accounting_itf> clients; // lists of number of client calls 

    public RegistryImpl() throws RemoteException {
        super();
        clients = new ArrayList<>();
    }

    public boolean isRegistered(Accounting_itf accounting) throws RemoteException
    {
        return clients.contains(accounting);
    }

    public void register(Accounting_itf client){
        if (!clients.contains(client)) {
            clients.add(client);
            System.out.println("Client registered: " + client);
        }
    }
}
