package view;

import modele.*;
import view.*;

public class Controleur{

    public int indice;
    public Joueur joueur;
    public int indiceJoueur;

    public Controleur(int indice,Joueur joueur,int indiceJoueur){
        this.indice=indice;
        this.joueur=joueur;
        this.indiceJoueur=indiceJoueur;
    }
    public void setIndice(int i){
        indice=i;
    }

    

}