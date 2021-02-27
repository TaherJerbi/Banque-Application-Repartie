import java.util.*;

public class BanqueDistant implements Banque{
    private HashMap<String,Compte> comptes;
    private ArrayList<String> operations;
    public BanqueDistant(){
        comptes = new HashMap<String,Compte>();
        operations = new ArrayList<String>();
    }

    public boolean etatCompte(String id){
        if(compteExiste(id)){
            boolean etat = comptes.get(id).getSolde() > 0;
            operations.add("Verification de l'état du compte "+id +" : "+ (etat ? "OK" : "ROUGE"));
            return etat;
        }
        else{
                System.err.println("Operation impossible, compte inexistant : " + id);
                return false;
            }
    }
    public float ajouterSurCompte(String id, float amount){
        if(compteExiste(id))
        {
            comptes.get(id).changeSolde(+amount);
            operations.add("Ajout de "+amount+"dans le compte "+id);
            return comptes.get(id).getSolde();
        }else{
            System.err.println("Operation impossible, compte inexistant : " + id);
            return 0;
        }
    }
    public float enleverSurCompte(String id, float amount){
        if(compteExiste(id)){
            comptes.get(id).changeSolde(-amount);
            operations.add("Retrait de "+amount+" du compte "+id);
            return comptes.get(id).getSolde();
        }
        else{
            System.err.println("Operation impossible, compte inexistant : " + id);
            return 0;
        }
        
    } 
    public float getValeurCompte(String id){
        operations.add("Consultation du solde de "+id);
        return comptes.get(id).getSolde();
    }
    public boolean transfertEntreCompte(String id1,String id2, float amount){
        if(!compteExiste(id1) || !compteExiste(id2))
        {
            System.err.println("Operation impossible, compte inexistant : " + (compteExiste(id1) ? id2 : id1));
            return false;
        }
        Compte c1 = comptes.get(id1);
        Compte c2 = comptes.get(id2);
        if(id1!=id2){
            c1.changeSolde(-amount);
            c2.changeSolde(+amount);
            operations.add("Transfert de "+amount+" "+id1+"->"+id2);
            return true;
        }else{
            System.out.println("Operation impossible");
            return false;
        }
            
    }
    public boolean compteExiste(String id){
        return comptes.containsKey(id);
    }
    public String creationCompte(){
        Compte c = new Compte();
        comptes.put(c.getId(),c);
        operations.add("Creation du compte "+c.getId());
        return c.getId();
    }
    public ArrayList<String> getOperations(){
        return this.operations;
    }
}
