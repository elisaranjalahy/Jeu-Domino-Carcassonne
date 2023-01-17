package view;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.*;
import view.*;
import javax.swing.*;
import java.awt.*;

public class ListeTuileView extends JFrame {

    public int indice;
    public Controleur controleur;
    public Plateau plateau;
    public boolean aJoue = false;
    public Sac sac;
    public ListeTuileView listeTuileView;
    

    public ListeTuileView(int indice, Plateau plateau) {
        super();
        if (!plateau.sac.estRempliSac()) {

            JFrame fin = new JFrame();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            fin.setBounds(0, 0, 2 * screenSize.width / 2, screenSize.height);
            fin.setVisible(true);
            JLabel msg = new JLabel("Le gagnant est " + plateau.estGagnant());
            fin.add(msg);

            JButton menu = new JButton("Menu");
            menu.addActionListener((e) -> {
                // new MenuView();
                fin.dispose();
            });

            fin.setTitle("Fin du Jeu");
            fin.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.dispose();
        }
        controleur = new Controleur(0, plateau.joueurs[indice], indice);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(2 * screenSize.width / 4, 0, 2 * screenSize.width / 4, screenSize.height); 
                                                                                             
                                                                                             
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
                    Tuile pioche = plateau.sac.piocher();
                    plateau.sac.uneTuileEnMoins(pioche);
                    plateau.joueurs[indice].rangerTuile(pioche);
                }
                
                new ListeTuileView(indice, plateau);
                
            });
            panel2.add(play);

            // Bouton qui permet de quitter le jeu
            JPanel panel3 = new JPanel();
            this.getContentPane().add(panel3);
            JButton play2 = new JButton("quitter le jeu"); // a regle pour retourner au menu
            play2.addActionListener((e) -> {
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
                    new ListeTuileView(0, plateau);
                    this.dispose();
                } else {
                    new ListeTuileView(indice + 1, plateau);
                    this.dispose();
                }
            });

            // affichage score actuel du joueur
            JPanel panel5 = new JPanel();
            this.getContentPane().add(panel5);
            JLabel score = new JLabel("score : " + plateau.joueurs[indice].getScore());
            panel5.add(score);

            for (int i = 0; i < plateau.joueurs[indice].getMesTuiles().length; i++) {
                JPanel panel = new JPanel();
                this.getContentPane().add(panel);
                if (plateau.joueurs[indice].getMesTuiles()[i].estRemplie()) {
                    panel.add(new TuileView(plateau.joueurs[indice].getMesTuiles()[i]));

                    JButton button = new JButton(String.valueOf(i));
                    button.addActionListener((e) -> {

                        controleur.setIndice(Integer.valueOf(button.getText()));
                        new PlateauView2(plateau, controleur);

                    });
                    JButton tourner = new JButton("tourner");
                    tourner.addActionListener((e) -> {
                        plateau.joueurs[indice]
                                .tourner(plateau.joueurs[indice].getMesTuiles()[Integer.valueOf(button.getText())], 1);
                        new ListeTuileView(indice, plateau);
                        this.dispose();
                    });
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
                Tuile pioche = plateau.sac.piocher();
                plateau.sac.uneTuileEnMoins(pioche);
                plateau.joueurs[indice].rangerTuile(pioche);
                int[] tab =plateau.placerTuileIa(plateau.joueurs[indice]);
                if (tab.length == 3) {
                    plateau.plateau[tab[1]][tab[2]]=plateau.joueurs[indice].getMesTuiles()[tab[0]];
                    plateau.joueurs[indice].utiliserTuile(plateau.joueurs[indice].getMesTuiles()[tab[0]]);
                    controleur.setIndice((tab[0]));
                    new PlateauView2(plateau, controleur);
                    if (indice == plateau.joueurs.length - 1) {
                        new ListeTuileView(0, plateau);
                        this.dispose();
                    } else {
                        new ListeTuileView(indice + 1, plateau);
                        this.dispose();
                    }
                } else {
                    if (tab.length==-1) {
                        if (indice == plateau.joueurs.length - 1) {
                            new ListeTuileView(0, plateau);
                            this.dispose();
                        } else {
                            new ListeTuileView(indice + 1, plateau);
                            this.dispose();
                        }
                    } else {
                        if (indice == plateau.joueurs.length - 1) {
                            new ListeTuileView(0, plateau);
                            this.dispose();
                        } else {
                            new ListeTuileView(indice + 1, plateau);
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
