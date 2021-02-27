import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
;public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = args.length < 1 ? null : args[0];
        String res ="";
        float amount;
        float solde;
        String myId ="";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Banque stub = (Banque) registry.lookup("Banque"); 
            
            do {
                System.out.println("Avez vous deja un compte ?");
                System.out.print("(O : oui/ N: non) : ");
                res = sc.next();
                if(res.charAt(0) == 'O')
                {
                    System.out.print("Donner votre id : ");
                    
                        res = sc.next();
                        if(!stub.compteExiste(res))
                            System.out.println("Ce compte n'existe pas");
                        else {
                            myId = res;
                            System.out.println("OK");
                        }
                }else if(res.charAt(0) == 'N'){
                    myId = stub.creationCompte();
                }
                else {
                    System.out.println("Je ne comprend pas...");
                }
            } while (myId.length() <1);

            System.out.println("Votre ID est : "+myId);

            

            do {
                System.out.println("Voulez vous : ");
                System.out.println("1. Consulter votre solde.");
                System.out.println("2. Enlever solde.");
                System.out.println("3. Ajouter solde.");
                System.out.println("4. Transferer solde.");
                System.out.println("Q pour Quitter");
                res = sc.next();
                switch (res.charAt(0)) {
                    case '1':
                        System.out.println("Votre solde est " + stub.getValeurCompte(myId));
                        break;
                    case '2':
                        System.out.println("Combien voulez vous retirer?");
                        amount = sc.nextFloat();
                        solde = stub.enleverSurCompte(myId, amount);
                        System.out.println("Votre nouveaux solde est : "+solde);
                    break;
                    case '3':
                        System.out.println("Combien voulez vous ajouter?");
                        amount = sc.nextFloat();
                        solde = stub.ajouterSurCompte(myId, amount);
                        System.out.println("Votre nouveaux solde est : "+solde);
                    break;
                    case '4':
                        System.out.println("Donnez l'id de l'autre compte");
                        res = sc.next();
                        System.out.println("Combien voulez vous transferer?");
                        amount = sc.nextFloat();
                        stub.transfertEntreCompte(myId,res, amount);
                    break;
                    case 'Q':
                        System.out.println("Au revoir");
                        break;
                    default:
                        System.out.println("Je ne comprend pas ...");
                        break;
                }

            } while (res.charAt(0)!='Q');
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
