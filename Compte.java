public class Compte {
    public static int lastID;
    private final String id;
    private float solde;
    public Compte(){
        this.solde = 0;
        this.id = ""+lastID++;
    }

    public String getId(){
        return id;
    }
    public float getSolde() {
        return solde;
    }
    public void setSolde(float solde) {
        this.solde = solde;
    }
    public void changeSolde(float amount){
        this.solde +=amount;
    }
    
}
