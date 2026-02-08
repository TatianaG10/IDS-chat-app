import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient {
        public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java HelloClient <rmiregistry host>");
                return;
            }
            String host = args[0];

			// Export information about the client
			ClientInfo info = new ClientInfo();
			ClientInfo_itf info_stub = (ClientInfo_itf) UnicastRemoteObject.exportObject(info, 0);

            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Chat_itf chat = (Chat_itf) registry.lookup("ChatService");
            ClientRegistry_itf reg = (ClientRegistry_itf) registry.lookup("ClientRegistryService");

            reg.register(info_stub);

            for (;;)
            {
                // TODO: main loop for the client
                // Get the client list from reistry to ask with who the client want to connect, 
                // and then a second infinite loop to send the messages and receive messages
            }

        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
