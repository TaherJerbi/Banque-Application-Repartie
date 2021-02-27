import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
public class Admin {
    public static void main(String[] args) {
        String host = args.length < 1 ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Banque stub = (Banque) registry.lookup("Banque"); 
            ArrayList<String> response = stub.getOperations();
            for (int i=0; i<response.size() ; i++) {
                System.out.println(i+". "+response.get(i));
            }
        }catch(Exception e){
            System.err.println("Admin exception : "+e.toString());
            e.getStackTrace();
        }
    }
}
