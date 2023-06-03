package models;

import java.time.LocalDate;

public class Epargne  extends Compte{
    
    private static  double taux =0.05;
   
    private LocalDate datedDB;
    private LocalDate datedB;
    
    public Epargne(String numero, double solde, LocalDate datedDB, LocalDate datedB) {
        super(numero, solde);
        this.datedDB = datedDB;
        this.datedB = datedB;
    }
    public Epargne() {
    }

    public static double getTaux() {
        return taux;
    }
    public static void setTaux(double taux) {
        Epargne.taux = taux;
    }
    public LocalDate getDatedDB() {
        return datedDB;
    }
    public void setDatedDB(LocalDate datedDB) {
        this.datedDB = datedDB;
    }
    public LocalDate getDatedB() {
        return datedB;
    }
    public void setDatedB(LocalDate datedB) {
        this.datedB = datedB;
    }
    @Override
    public String consultation() {
        // TODO Auto-generated method stub
        String ch= super.consultation()+
             " Taux :"+taux ;
             if(!transactionIsPossible()){
                ch+=  " Bloque du "+ datedDB + " Au "+ datedB;
             }  
          return ch;
    }

    @Override
    public boolean depot(double montant) {
        // TODO Auto-generated method stub
        if(transactionIsPossible()){
            return super.depot(montant);
        }
        return false;
    }
    @Override
    public boolean retrait(double montant) {
        // TODO Auto-generated method stub
        if(transactionIsPossible()){
            return super.retrait(montant);
        }
          return false;
    }
    @Override
    public boolean virement(double montant, Compte CpteDepot) {
        // TODO Auto-generated method stub
        if(transactionIsPossible()){
            return super.virement(montant, CpteDepot);
        }
        return false;
    }
      // now ==>31/05/2023
       //01/06/2023 au 30/06/2023
    private boolean transactionIsPossible(){
      LocalDate now =LocalDate.now();//Date du Jour
      if( now.isAfter(datedDB) && now.isBefore(datedB)){
          return false;
      }
        return true;//IsPossible
    }

    
}
