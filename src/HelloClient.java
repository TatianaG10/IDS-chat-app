import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloClient {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java HelloClient <rmiregistry host>");
                return;
            }
            String host = args[0];

			// Export this info interface to the registry
			Info info = new Info("Andy");
			Info_itf h_stub = (Info_itf) UnicastRemoteObject.exportObject(info, 0);

            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Hello h = (Hello) registry.lookup("HelloService");

			// Remote method invocation
			String res = h.sayHello(h_stub);
			System.out.println(res);
        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
