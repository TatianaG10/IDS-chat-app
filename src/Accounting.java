import java.rmi.RemoteException;

public class Accounting implements Accounting_itf {
    private int num_calls;

    public Accounting() throws RemoteException {
        super();
        num_calls = 0;
    }

    // not sure if this function is useful
    public void AccountingCall(){
        num_calls++;
    }

    public void numberOfCalls(int n) throws RemoteException 
    {
        num_calls = n;
        System.out.println("Server notification: you reached " + n + " calls.");
    }
}