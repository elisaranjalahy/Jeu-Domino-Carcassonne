package viewcarcassonne;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelecarcassonne.*;
import viewcarcassonne.*;
import javax.swing.*;
import java.awt.*;

public class ListeTuileViewCarcassonne extends JFrame {

    public int indice;
    public ControleurCarcassonne controleur;
    public PlateauCarcassonne plateau;
    public SacCarcassonne sac;
    public boolean aJoue;
    public ListeTuileViewCarcassonne listeTuileView;

    public ListeTuileViewCarcassonne(int indice, PlateauCarcassonne plateau) {
        super();
        if (!plateau.sac.estRempliSac()) {
            JFrame fin = new JFrame();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            fin.setBounds(0, 0, 2 * screenSize.width / 2, screenSize.height);
            fin.setVisible(true);
            JLabel msg = new JLabel("Fin de la partie");
            fin.setTitle("Fin du Jeu");
            fin.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispose();
        }
        controleur = new ControleurCarcassonne(0, plateau.joueurs[indice], indice, false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(2 * screenSize.width / 4, 0, 2 * screenSize.width / 4, screenSize.height); // a faire : voir comment
                                                                                             // afficher la fenetre a
                                                                                             // droite du plateau
        setResizable(false);

        if (!plateau.joueurs[indice].ia) {
            setTitle("Tuiles du joueur : " + plateau.joueurs[indice].getNom());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            this.indice = indice;
            this.plateau = plateau;

            JPanel panel2 = new JPanel();
            this.getContentPane().add(panel2);

            JButton play = new JButton("piocher");
            play.addActionListener((e) -> {

                play.setVisible(false);

                JPanel panel3 = new JPanel();
                getContentPane().add(panel3);
                if (plateau.sac.estRempliSac()) {
                    TuileCarcassonne pioche = plateau.sac.piocher();
                    pioche.numJoueur=indice;
                    plateau.sac.uneTuileEnMoins(pioche);
                    plateau.joueurs[indice].rangerTuile(pioche);
                }
                new ListeTuileViewCarcassonne(indice, plateau);
            });
            panel2.add(play);

            // Bouton qui permet de quitter le jeu
            JPanel panel3 = new JPanel();
            this.getContentPane().add(panel3);
            JButton play2 = new JButton("quitter le jeu"); // a regle pour retourner au menu
            play2.addActionListener((e) -> {
                //dispose();
                System.exit(0);

            });

            panel3.add(play2);

            // bouton qui permet de passer au joueur suivant
            JPanel panel4 = new JPanel();
            this.getContentPane().add(panel4);
            JButton play3 = new JButton("Joueur suivant");
            panel4.add(play3);
            play3.addActionListener((event) -> {

                aJoue = true;
                dispose();

                if (indice == plateau.joueurs.length - 1) {
                    new ListeTuileViewCarcassonne(0, plateau);
                    this.dispose();
                } else {
                    new ListeTuileViewCarcassonne(indice + 1, plateau);
                    this.dispose();
                }
            });

            
            JLabel CouleurRappel= new JLabel("<html>Ville : JAUNE<br>Riviere : BLEUE <br>Abbaye : BLANC<br>Route : GRIS<br>Campagne : VERT</html>");
            
            panel4.add(CouleurRappel);
            panel4.setVisible(true);
        


            for (int i = 0; i < plateau.joueurs[indice].getMesTuiles().length; i++) {
                JPanel panel = new JPanel();
                this.getContentPane().add(panel);
                if (plateau.joueurs[indice].getMesTuiles()[i].estRemplie()) {
                    panel.add(new TuileViewCarcassonne(plateau.joueurs[indice].getMesTuiles()[i]));

                    JButton button = new JButton(String.valueOf(i));
                    button.addActionListener((e) -> {

                        controleur.setIndice(Integer.valueOf(button.getText()));
                        new PlateauView2Carcassonne(plateau, controleur);

                    });
                    JButton pion = new JButton(String.valueOf(i) + "/pion");
                    pion.addActionListener((e) -> {

                        controleur.setIndice(Integer.valueOf(button.getText()));
                        controleur.pion = true;
                        new PlateauView2Carcassonne(plateau, controleur);

                    });
                    JButton tourner = new JButton("tourner");
                    tourner.addActionListener((e) -> {
                        plateau.joueurs[indice]
                                .tourner(plateau.joueurs[indice].getMesTuiles()[Integer.valueOf(button.getText())], 1);
                        new ListeTuileViewCarcassonne(indice, plateau);
                        this.dispose();
                    });
                    panel.add(pion);
                    panel.add(tourner);
                    panel.add(button);

                }
            }
        } else {

            setTitle("Tuiles du joueur : " + plateau.joueurs[indice].getNom());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            this.indice = indice;
            this.plateau = plateau;

            if (plateau.sac.estRempliSac()) {
                TuileCarcassonne pioche = plateau.sac.piocher();
                pioche.numJoueur=indice;
                plateau.sac.uneTuileEnMoins(pioche);
                plateau.joueurs[indice].rangerTuile(pioche);
                int[] tab =plateau.placerTuileIa(plateau.joueurs[indice]);
                if (tab.length == 3) {
                    plateau.plateau[tab[1]][tab[2]]=plateau.joueurs[indice].getMesTuiles()[tab[0]];
                    plateau.plateau[tab[1]][tab[2]].pion=controleur.pion;
                    plateau.joueurs[indice].utiliserTuile(plateau.joueurs[indice].getMesTuiles()[tab[0]]);
                    controleur.setIndice((tab[0]));
                    new PlateauView2Carcassonne(plateau, controleur);
                    if (indice == plateau.joueurs.length - 1) {
                        new ListeTuileViewCarcassonne(0, plateau);
                        this.dispose();
                    } else {
                        new ListeTuileViewCarcassonne(indice + 1, plateau);
                        this.dispose();
                    }
                } else {
                    if (tab.length==-1) {
                        if (indice == plateau.joueurs.length - 1) {
                            new ListeTuileViewCarcassonne(0, plateau);
                            this.dispose();
                        } else {
                            new ListeTuileViewCarcassonne(indice + 1, plateau);
                            this.dispose();
                        }
                    } else {
                        if (indice == plateau.joueurs.length - 1) {
                            new ListeTuileViewCarcassonne(0, plateau);
                            this.dispose();
                        } else {
                            new ListeTuileViewCarcassonne(indice + 1, plateau);
                            this.dispose();
                        }
                    }
                }

            }
        }

        setVisible(true);
        this.getContentPane().setLayout(new GridLayout(4, 4));
    }

}