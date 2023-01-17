package view;
import modele.*;
import view.*;

import javax.swing.*;
import java.awt.*;

public class JeuView {
    public PlateauView2 plateauView;
    public ListeTuileView listeTuileView;
    public JeuView(Joueur[] listeJoueurs){
        Sac sac= new Sac(10);
        sac.remplirSac();
        Plateau plateau = new Plateau(listeJoueurs, sac);
        plateau.changerDimension(8,8);
        Tuile tuileInitiale=plateau.sac.piocher();
        sac.uneTuileEnMoins(tuileInitiale);
        plateau.plateau[plateau.plateau.length/2][plateau.plateau[0].length/2]=tuileInitiale;
        Controleur c=new Controleur(0, listeJoueurs[0],0);
        plateauView=new PlateauView2(plateau,c);
        listeTuileView=new ListeTuileView(0,plateau);
       

    }
}