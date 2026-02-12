import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

public class ClientInfo implements ClientInfo_itf {
    private String name;
    private ChatMessage lastMessage;
    private Semaphore messageUpdated;

    public ClientInfo(String machineName)
    {
        name = machineName;
        lastMessage = null;
        messageUpdated = new Semaphore(0);
    }

    public String getName() throws RemoteException {
        return name;
    }

    public ChatMessage getLastMessage()
    {
        return lastMessage;
    }

    public Semaphore getSemMessageUpdated()
    {
        return messageUpdated;
    }

    public void updateLastMessage(ChatMessage message) throws RemoteException {
        lastMessage = message;
    }

    public void notifyMessageArrived() throws RemoteException {
        messageUpdated.release();
    }    
}
