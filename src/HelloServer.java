import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer {

    public static void main(String[] args) {
        try {
            // Create a Hello remote object
            HelloImpl h = new HelloImpl();
            Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);

            // Get (or start) the RMI registry on default port 1099
            Registry registry = LocateRegistry.getRegistry();

            // Register the remote object
            registry.bind("HelloService", h_stub);

            System.out.println("Server ready");

        } catch (Exception e) {
            System.err.println("Error on server: " + e);
            e.printStackTrace();
        }
    }
}
