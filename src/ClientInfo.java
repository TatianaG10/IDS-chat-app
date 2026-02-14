import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ClientInfo implements ClientInfo_itf {
    private String name;
    private ArrayList<ChatMessage> listMessages;
    private Semaphore messageUpdated;

    public ClientInfo(String machineName)
    {
        name = machineName;
        listMessages = new ArrayList<ChatMessage>();
        messageUpdated = new Semaphore(1);
    }

    public String getName() throws RemoteException {
        return name;
    }

    public ArrayList<ChatMessage> getListMessages()
    {
        return listMessages;
    }

    public Semaphore getSemMessageUpdated()
    {
        return messageUpdated;
    }

    public void updateListMessages(ArrayList<ChatMessage> newListMessages) throws RemoteException {
        listMessages = newListMessages;
    }

    public void notifyMessageArrived() throws RemoteException {
        messageUpdated.release();
    }
}
