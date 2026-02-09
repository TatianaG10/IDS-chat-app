import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
            ChatClientList_itf reg = (ChatClientList_itf) registry.lookup("ChatClientListService");

            reg.connect(info_stub);
            
            try (
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
            ){
                for (;;)
                {
                   // Client main loop: ask users if he/she
                   // want to message until he/she enters Ctrl+D
                }
            } catch (Exception e) {
                System.err.println("Error on client: " + e);
            }

        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
