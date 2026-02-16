import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ChatClientList implements ChatClientList_itf {
    private ArrayList<ClientInfo_itf> clientList;
    private Semaphore clientListSem;

    public ChatClientList()
    {
        clientList = new ArrayList<ClientInfo_itf>();
        clientListSem = new Semaphore(1);
    }

    public void connect(ClientInfo_itf client) throws RemoteException {
        try 
        {
            clientListSem.acquire();
            if (clientList.contains(client))
            {
                System.out.println("Error: the client is already connected");
            }
            else
            {
                clientList.add(client);
            }
            clientListSem.release();
        } 
        catch (Exception e) 
        {
            System.out.println("Error in ChatClientList: " + e);
            e.printStackTrace();
        }

    }

    public void disconnect(ClientInfo_itf client) throws RemoteException {
        try 
        {
            clientListSem.acquire();
            if (!clientList.contains(client))
            {
                System.out.println("Error: the client is not connected");
            }
            else
            {
                if (clientList.remove(client))
                {
                    System.out.println("Client " + client.getName() + " disconnected successfully!");
                }
                else
                {
                    System.out.println("Not disconnected");
                }
            }
            clientListSem.release();
        } 
        catch (Exception e) 
        {
            System.out.println("Error in ChatClientList: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnected(String clientName) throws RemoteException {
        boolean res = false;

        try 
        {
            clientListSem.acquire();
            for (ClientInfo_itf client : clientList)
            {
                if (clientName.equals(client.getName()))
                {
                    res = true;
                    break;
                }
            }
            clientListSem.release();
        } 
        catch (Exception e) 
        {
            System.out.println("Error in ChatClientList: " + e);
            e.printStackTrace();
        }
        
        return res;
    }

    @Override
    public ArrayList<ClientInfo_itf> getClientList() throws RemoteException 
    {
        return clientList;
    }
}
