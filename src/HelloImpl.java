import java.rmi.*;

public class HelloImpl implements Hello {

    public HelloImpl() {
        super();
    }

	public String sayHello() throws RemoteException {
		return "Hello !";
	}
}
