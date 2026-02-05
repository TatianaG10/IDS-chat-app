import java.rmi.RemoteException;

public class Info implements Info_itf {
    private String name;

    public Info(String n)
    {
        name = n;
    }

    public String getName() throws RemoteException 
    {
        return name;
    }
}
