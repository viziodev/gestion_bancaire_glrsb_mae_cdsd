package models;

import models.enums.TypeCompte;

//Compte devient une classe abraite ==> Classe non instanciable
//Compte devient une classe final ==> Interdit d'heriter la classe Compte
public  abstract class Compte {
 //Attributs Statiques 
    //Appeler a travers une Classe 
    private static int nbre;//Attribut numerique initialise a 0 
    //Attributs Instances
    //Appeler a travers un Objet 
    protected int id;   
    protected String numero;
    protected double solde;
    protected TypeCompte type;

    //Attributs de Navigabiltes
    //ManyToOne
     Client client;
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Compte(String numero, double solde) {
        id=++nbre;
        this.numero = numero;
        this.solde = solde;
    }

//Chercher une Classe en Java
        //id=1 ==> numero ==>   CPT00001
        //id=2 ==> numero ==>   CPT00002
        //id=10 ==> numero ==>  CPT00010
        //id=100 ==> numero ==> CPT00100
   private String  generateNumero(){
      return null;
   }

    public Compte() {
        id=++nbre;
    }
    public Compte(double solde) {
        id=++nbre;
        this.solde = solde;
    }
    public static int getNbre() {
        return nbre;
    }
    public static void setNbre(int nbre) {
        Compte.nbre = nbre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compte other = (Compte) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    //Retraits

    public boolean retrait(double montant){
      if(montant<solde){
        solde-=montant;
        return true;
      }
      return false;
    }

    public boolean depot(double montant){
          solde+=montant;
          return true;
      }
   
      public boolean virement(double montant,Compte CpteDepot){
          if(this.retrait(montant)){
            return CpteDepot.depot(montant);
          }
          return false;
    }


    public String consultation() {
        return  " Id= " + id + 
                " Numero=" + numero + 
                " Solde=" + solde + 
                " Type=" + type ;
    }

}
