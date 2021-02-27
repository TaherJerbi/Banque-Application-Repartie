import java.util.*;

public class BanqueDistant implements Banque{
    private HashMap<String,Compte> comptes;
    private ArrayList<String> operations;
    public BanqueDistant(){
        comptes = new HashMap<String,Compte>();
        operations = new ArrayList<String>();
    }
    public boolean etatCompte(String id){
        if(compteExiste(id))
            return comptes.get(id).getSolde() > 0;
        else{
            System.out.println("Le compte "+id+" n'existe pas");
            return false;
        }
    }
    public float ajouterSurCompte(String id, float amount){
        comptes.get(id).changeSolde(+amount);
        return comptes.get(id).getSolde();
    }
    public float enleverSurCompte(String id, float amount){
        comptes.get(id).changeSolde(-amount);
        return comptes.get(id).getSolde();
    } 
    public float getValeurCompte(String id){
        return comptes.get(id).getSolde();
    }
    public boolean transfertEntreCompte(String id1,String id2, float amount){
        if(!compteExiste(id1) || !compteExiste(id2))
        {
            System.out.println("Operation impossible, compte inexistant : " + (compteExiste(id1) ? id2 : id1));
            return false;
        }
        Compte c1 = comptes.get(id1);
        Compte c2 = comptes.get(id2);
        if(id1!=id2){
            c1.changeSolde(-amount);
            c2.changeSolde(+amount);
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
        operations.add(operations.size()+". Creation du compte "+c.getId());
        return c.getId();
    }
}
