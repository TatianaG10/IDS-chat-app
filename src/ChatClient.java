import java.io.BufferedReader;
import java.io.InputStreamReader;
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

            chat.connectToChat(info_stub);
            
            try (
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
            ){
                // Main loop to send message son the global forum
                for (;;)
                {
                    ChatMessage lastMessage = chat.getLastMessage();
                    if (lastMessage == null)
                    {
                        System.out.println("New chat");    
                    }
                    else
                    {
                        System.out.println("From " + lastMessage.getExpediter());
                        System.out.println(lastMessage.getContent());
                    }

                    String userInput;
                    System.out.println("Send a message");
                    if ((userInput = stdIn.readLine()) == null)
                        break;
                    ChatMessage message = new ChatMessage(userInput, info.getName());
                    chat.sendMessage(message);
                }

                chat.disconnectFromChat(info_stub);
            } catch (Exception e) {
                System.err.println("Error on client: " + e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Error on client: " + e);
            e.printStackTrace();
        }
    }
}
