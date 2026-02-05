import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registry implements Registry_itf {
    private List<Accounting_itf> clients; // lists of number of client calls 

    public Registry() throws RemoteException {
        super();
        clients = new ArrayList<>();
    }

    public void register(Accounting_itf client){
        if (!clients.contains(client)) {
            clients.add(client);
            System.out.println("Client registered: " + client);
        }
    }
}
