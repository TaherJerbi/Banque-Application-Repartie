import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banque extends Remote{
    boolean etatCompte(String id) throws RemoteException;
    float ajouterSurCompte(String id, float amount) throws RemoteException;
    float enleverSurCompte(String id, float amount) throws RemoteException; 
    float getValeurCompte(String id) throws RemoteException;
    boolean transfertEntreCompte(String id1,String id2, float amount) throws RemoteException;
    String creationCompte() throws RemoteException;
    boolean compteExiste(String id) throws RemoteException;
}