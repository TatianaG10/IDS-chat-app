import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ChatDiscussion implements ChatDiscussion_itf {
    public ArrayList<ChatMessage> listMessages;
    private Semaphore listMessagesSem;

    public ChatDiscussion()
    {
        listMessages = new ArrayList<ChatMessage>();
        listMessagesSem = new Semaphore(1);
    }
    
    public ArrayList<ChatMessage> getListMessages() throws RemoteException {
        return listMessages;
    }

    public void addNewMessage(ChatMessage message) throws RemoteException {
        try 
        {
            listMessagesSem.acquire();
            listMessages.add(message);
            listMessagesSem.release();
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error in ChatDiscussion: " + e);
            e.printStackTrace();
        }
    }
}
