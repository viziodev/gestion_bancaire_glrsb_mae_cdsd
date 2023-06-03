import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import models.*;
import services.CompteService;

public class App {
    private static Scanner sc=new Scanner(System.in);
    private static CompteService compteService=new CompteService();
    public static void main(String[] args) throws Exception {
        int choix;
        do {
            choix =menu(); 
            switch (choix) {
                case 1:
                  Client client=new Client();
                  sc.nextLine();
                  System.out.println("Entrer le Nom");
                   client.setNom(sc.nextLine());
                  System.out.println("Entrer le Prenom");
                  client.setPrenom(sc.nextLine());
                  compteService.addClient(client);
                    break;
                case 2:
                   ArrayList<Client> clients=compteService.getClients();
                   for (Client cl : clients) {
                       System.out.println(cl);
                   }
                    break;
                case 3:
                 int idClient;
                 System.out.println("Entrer l'id  du Client");
                 idClient=sc.nextInt();
                client= compteService.searchClientById(idClient);
                if(client==null){
                    System.out.println("Ce client n'existe Pas");
                }else{
                //1-Saisie des Attributs de la Classe Mere
                String numero;
                double solde;
                sc.nextLine();
                System.out.println("Entrer le Numero du Compte");
                numero=sc.nextLine();
                System.out.println("Entrer le Solde du Compte");
                solde=sc.nextDouble();
                int typeInt;
                do {
                    System.out.println("Choisir le Type de Compte");
                    System.out.println("1-Cheque");
                    System.out.println("2-Epargne");
                    typeInt=sc.nextInt();
                } while (typeInt!=1 && typeInt!=2);
               
                if(typeInt==1){
                    int frais;
                     System.out.println("Entrer les  du Compte");
                     frais=sc.nextInt();
                     Cheque compteCheque=new Cheque(numero,solde,frais);
                     compteService.addCompte(compteCheque);

                   //Creer la Relation 
                      //Client ==>Compte
                      client.addCompte(compteCheque); 
                      //Compte ==> Client
                      compteCheque.setClient(client);

                }else{
                    sc.nextLine();
                    String dateDb,dateF;
                    System.out.println("Entrer la Date Debut de Blocage (jj-mm-aaaa)");
                    dateDb=sc.nextLine();
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    
                    System.out.println("Entrer la Date Fin de Blocage (jj-mm-aaaa)");
                    dateF=sc.nextLine();
                    //Convertion String ==> LocalDate 
                     try {
                        Epargne comEpargne=new Epargne(numero,solde,
                        LocalDate.parse(dateDb,formatter),  
                        LocalDate.parse(dateF,formatter));
                        compteService.addCompte(comEpargne);
                        //Creer la Relation 
                        //Client ==>Compte
                         client.addCompte(comEpargne); 
                        //Compte ==> Client
                         comEpargne.setClient(client);
                     } catch ( DateTimeParseException e) {
                         System.out.println("Format de la Date Invalide");
                     }

                     
                   }

                   
                 }

                    break;
               case 4:
                    break;
            
                default:
                    break;
            }
        } while (choix!=8);
         
    }


    public static int menu(){
        int choix;
        System.out.println("1-Ajouter Client");
        System.out.println("2-Lister Client");
        System.out.println("3- Creer Compte");
        System.out.println("4-Lister les Compte d'un Client");
        System.out.println("5-Faire une Transaction");
        System.out.println("6-Lister les Transaction un Compte");
        System.out.println("7-Lister les Transaction un Compte");
        System.out.println("8-Quitter");
        System.out.println("Faites votre choix");
        choix=sc.nextInt();
        return choix;
    }
}
