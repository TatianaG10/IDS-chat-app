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
			Accounting acc = new Accounting();
			Accounting_itf acc_stub = (Accounting_itf) UnicastRemoteObject.exportObject(acc, 0);

            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Hello h = (Hello) registry.lookup("HelloService");
            Hello2 h2 = (Hello2) registry.lookup("Hello2Service");
            Registry_itf r = (Registry_itf) registry.lookup("RegistryService");

			// Remote method invocation
            r.register(acc_stub);
			String res = h2.sayHello(acc_stub);
			System.out.println(res);

            // Test limit hello
            for (int i = 0; i < 10; i++)
            {
                res = h2.sayHello(acc_stub);
                System.out.println(res);
            }
            
            // Test the original service
            res = h.sayHello();
            System.out.println(res);
        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
