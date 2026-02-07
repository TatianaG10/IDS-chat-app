import java.rmi.RemoteException;

public class Accounting implements Accounting_itf {
    private int num_calls;

    public Accounting() throws RemoteException {
        super();
        num_calls = 0;
    }

    public int getNumCalls() throws RemoteException
    {
        return num_calls;
    }

    public void numberOfCalls(int n) throws RemoteException 
    {
        num_calls = n;
        if ((num_calls % 10) == 0)
        {
            System.out.println("Server notification: you reached " + n + " calls.");
        }
    }
}