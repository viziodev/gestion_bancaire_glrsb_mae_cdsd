package services;


import java.util.ArrayList;

import models.*;

public class CompteService {
    //Use Case 
    private ArrayList<Client> clients=new ArrayList<>();


    private ArrayList<Compte> comptes=new ArrayList<>();

    //Lister les Clients
    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client searchClientById(int id){
        for (Client cl : clients) {
            if(id==cl.getId()){
                return cl;
            }
        }

        return null;
    }

    //Ajouter un client
    public void addClient(Client client) {
        clients.add(client);
    }

    //Ajouter un compte
    public void addCompte(Compte compte) {
        comptes.add(compte);
    }




}
