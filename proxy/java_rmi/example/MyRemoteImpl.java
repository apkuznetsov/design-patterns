package kuznetsov.proxy.java_rmi.example;

import java.io.Serial;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    @Serial
    private static final long serialVersionUID = 1L;

    public MyRemoteImpl() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String sayHello() {
        return "Server says, ‘Hey’";
    }
}
