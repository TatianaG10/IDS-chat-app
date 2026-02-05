import java.rmi.*;

public class HelloImpl implements Hello {

    public HelloImpl() {
        super();
    }

	public String sayHello(Info_itf client) throws RemoteException {
		return "Hello " + client.getName() + "!";
	}
}
