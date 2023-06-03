package models;

import java.util.ArrayList;

//Client devient une classe concrete ==> produit des objets
public class Client {
    //Attributs Statiques 
    //Appeler a travers une Classe 
    private static int nbre;//Attribut numerique initialise a 0 
    //Attributs Instances
    //Appeler a travers un Objet 
    private int id;
    private String nom,prenom;

    //Attributs Navigation 
     //OneToMany
     ArrayList<Compte> comptes=new ArrayList<>();
    
    public ArrayList<Compte> getComptes() {
        return comptes;
    }
     public void addCompte(Compte compte){
        comptes.add(compte);
    }

    public Client(String nom, String prenom) {
        id=++nbre;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client() {
        id=++nbre;
    }
    public static int getNbre() {
       
        return nbre;
    }
    public static void setNbre(int nbre) {
        Client.nbre = nbre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Client other = (Client) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
    
}
