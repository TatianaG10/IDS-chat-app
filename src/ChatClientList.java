import java.rmi.RemoteException;
import java.util.ArrayList;

public class ChatClientList implements ChatClientList_itf {
    private ArrayList<ClientInfo_itf> clientList;

    public ChatClientList()
    {
        clientList = new ArrayList<ClientInfo_itf>();
    }

    public void connect(ClientInfo_itf client) throws RemoteException {
        if (clientList.contains(client))
        {
            System.out.println("Error: the client is already connected");
        }
        else
        {
            // TODO: Need to synchronize this
            clientList.add(client);
        }
    }

    @Override
    public void disconnect(ClientInfo_itf client) throws RemoteException {
        if (!clientList.contains(client))
        {
            System.out.println("Error: the client is not connected");
        }
        else
        {
            // TODO: Need to synchronize this
            if (clientList.remove(client))
            {
                System.out.println("Client " + client.getName() + " disconnected successfully!");
            }
            else
            {
                System.out.println("Not disconnected");
            }
        }
    }

    @Override
    public boolean isConnected(String clientName) throws RemoteException {
        boolean res = false;
        for (ClientInfo_itf client : clientList)
        {
            if (clientName.equals(client.getName()))
            {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public ArrayList<ClientInfo_itf> getClientList() throws RemoteException {
        return clientList;
    }
}
