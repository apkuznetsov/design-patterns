package kuznetsov.proxy.java_rmi.gumball.server;

import kuznetsov.proxy.java_rmi.gumball.states.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;
}
