import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloImpl2 implements Hello2 {

    public HelloImpl2() {
        super();
    }

	public String sayHello(Accounting_itf accounting) throws RemoteException {
        String res = null;
        Registry registry = LocateRegistry.getRegistry();

        try {
            Registry_itf reg = (Registry_itf) registry.lookup("RegistryService");
            if (reg.isRegistered(accounting))
            {
                accounting.numberOfCalls(accounting.getNumCalls() + 1);
                res = "Hello !";
            }
            else
            {
                res = "Client not registered";
            }

        } catch (Exception e) {
            System.out.println("Error on server: " + e);
            e.printStackTrace();
        } 

        return res;
	}
}
