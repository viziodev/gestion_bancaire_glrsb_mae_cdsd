package models;

import models.enums.TypeCompte;

public class Cheque extends Compte {

     private int frais; 

     public Cheque(String numero, double solde, int frais) {
        super(numero, solde);
        this.frais = frais;
        type=TypeCompte.Cheque;

     
    }

    public Cheque(){
          super();
          super.type=TypeCompte.Cheque;
     }

    @Override
    public String consultation() {
        // TODO Auto-generated method stub
        return super.consultation()+ " Frais: "+frais;
    }

    @Override
    public boolean depot(double montant) {
        // TODO Auto-generated method stub
        return super.depot(montant-frais);
    }

     


}
