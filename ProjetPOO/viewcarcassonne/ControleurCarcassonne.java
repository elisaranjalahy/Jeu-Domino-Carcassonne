package viewcarcassonne;

import modelecarcassonne.*;
import viewcarcassonne.*;

public class ControleurCarcassonne{

    public int indice;
    public JoueurCarcassonne joueur;
    public int indiceJoueur;
    public boolean pion;

    public ControleurCarcassonne(int indice,JoueurCarcassonne joueur,int indiceJoueur,boolean pion){
        this.indice=indice;
        this.joueur=joueur;
        this.indiceJoueur=indiceJoueur;
        this.pion=pion;
    }
    public void setIndice(int i){
        indice=i;
    }

    

}