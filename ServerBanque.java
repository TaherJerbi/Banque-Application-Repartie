import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerBanque {
    public ServerBanque(){}
    public static void main(String[] args) {

        try {
            BanqueDistant banqueDist = new BanqueDistant();
            Banque stub = (Banque) UnicastRemoteObject.exportObject(banqueDist,0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Banque",stub);
            System.out.println("Server ready ...");
        }catch(Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
        
    }
}
