import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient {
        public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Usage: java HelloClient <username> <rmiregistry host>");
                return;
            }
            String userName = args[0];
            String host = args[1];

			// Export information about the client
			ClientInfo info = new ClientInfo(userName);
			ClientInfo_itf info_stub = (ClientInfo_itf) UnicastRemoteObject.exportObject(info, 0);

            // Get remote object reference
            Registry registry = LocateRegistry.getRegistry(host);
            Chat_itf chat = (Chat_itf) registry.lookup("ChatService");

            chat.connectToChat(info_stub);

            // Start a thread to display stuff
            Thread tDisplay = new Thread(new ChatClientDisplay(info));
            tDisplay.start();

            try (
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
            ){
                // Main loop to send message to the global forum
                for (;;)
                {
                    String userInput;
                    if ((userInput = stdIn.readLine()) == null)
                        break;
                    ChatMessage message = new ChatMessage(userInput, info.getName());
                    chat.sendMessage(message);
                }

                chat.disconnectFromChat(info_stub);
            } 
            catch (Exception e) {
                System.err.println("Error on client: " + e);
                e.printStackTrace();
            }
            tDisplay.interrupt();
        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
