import java.rmi.*;

public class Chat implements Chat_itf {

    public Chat()
    {
        System.out.println("The Chat is ready!");
    };

    public void sendMessage(ChatMessage message) throws RemoteException
    {
        
    }
}
