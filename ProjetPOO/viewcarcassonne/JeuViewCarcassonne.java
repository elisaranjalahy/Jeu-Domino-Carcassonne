package viewcarcassonne;
import modelecarcassonne.*;
import viewcarcassonne.*;

import javax.swing.*;
import java.awt.*;

public class JeuViewCarcassonne {
    public PlateauView2Carcassonne plateauView;
    public ListeTuileViewCarcassonne listeTuileView;
    public JeuViewCarcassonne(JoueurCarcassonne[] listeJoueurs){
        SacCarcassonne sac= new SacCarcassonne(16);
        sac.remplirSac();
        PlateauCarcassonne plateau = new PlateauCarcassonne(listeJoueurs, sac);
        plateau.changerDimension(8,8);
        TuileCarcassonne tuileInitiale=plateau.sac.piocher();
        sac.uneTuileEnMoins(tuileInitiale);
        plateau.plateau[plateau.plateau.length/2][plateau.plateau[0].length/2]=tuileInitiale;
        ControleurCarcassonne c=new ControleurCarcassonne(0, listeJoueurs[0],0,false);
        plateauView=new PlateauView2Carcassonne(plateau,c);
        listeTuileView=new ListeTuileViewCarcassonne(0,plateau);
        

    }
}