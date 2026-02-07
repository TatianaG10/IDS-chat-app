import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer {

    public static void main(String[] args) {
        try {
            // Create a Hello remote object
            HelloImpl h = new HelloImpl();
            Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
            HelloImpl2 h2 = new HelloImpl2();
            Hello2 h2_stub = (Hello2) UnicastRemoteObject.exportObject(h2, 0);
            RegistryImpl r = new RegistryImpl();
            Registry_itf r_stub = (Registry_itf) UnicastRemoteObject.exportObject(r, 0);

            // Get (or start) the RMI registry on default port 1099
            Registry registry = LocateRegistry.getRegistry();

            // Register the remote object
            registry.bind("HelloService", h_stub);
            registry.bind("Hello2Service", h2_stub);
            registry.bind("RegistryService", r_stub);
            
            System.out.println("Server ready");

        } catch (Exception e) {
            System.err.println("Error on server: " + e);
            e.printStackTrace();
        }
    }
}
