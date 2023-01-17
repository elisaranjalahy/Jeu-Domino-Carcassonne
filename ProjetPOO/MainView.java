

import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.*;

public class MainView {

    public int nbDeJoueurs,nbIA;

    public MainView(int nbDeJoueurs, int nbIA){
        this.nbDeJoueurs=nbDeJoueurs;
        this.nbIA=nbIA;
    }

    public static void main ( String [] args ) {
        new MenuView();
    
    }
}
