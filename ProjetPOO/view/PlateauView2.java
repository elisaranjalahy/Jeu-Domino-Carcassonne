package view;
import modele.*;
import view.*;
import java.lang.Object;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.event.*; 
import javax.swing.*;


public class PlateauView2 extends JFrame implements MouseListener{
    
    public Plateau plateau;
    public Controleur controleur;
    

    public PlateauView2(Plateau plateau,Controleur controleur){ 
        super();
        this.controleur=controleur;
        this.plateau=plateau;
        setTitle("Domino");
        setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,2*screenSize.width/4, screenSize.height);
        setResizable(false);
        setVisible(true);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.getContentPane().setLayout(new GridLayout(plateau.plateau.length,plateau.plateau[0].length));

        for(int i=0; i<plateau.plateau.length; i++){
            for (int j=0;j<plateau.plateau[i].length;j++){
                if (!plateau.plateau[i][j].estRemplie()) {
                    JPanel p = new JPanel();
                    p.setBackground(new Color ( 255,175,175));
                    p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    p.setVisible(true);
                    this.getContentPane().add(p);
                    JButton ligne=new JButton(String.valueOf(i));
                    JButton colonne=new JButton(String.valueOf(j));
                    p.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            tuile(controleur.joueur,controleur.indice,Integer.valueOf(ligne.getText()),Integer.valueOf(colonne.getText()));
                        }
                    });
                } else {
                    TuileView p=new TuileView(plateau.plateau[i][j]);
                    this.getContentPane().add(p);

                }
            }
            
            
            
                            
            
        }
                    
        

        setVisible(true);
    }
    public void update(){
        new PlateauView2(plateau,controleur);
        new ListeTuileView(controleur.indiceJoueur,plateau);
    }
    public void tuile(Joueur j,int z,int x,int y){
        if(plateau.placerTuile(j,z,x,y)){
            plateau.plateau[x][y]=j.getMesTuiles()[z];
            j.utiliserTuile(j.getMesTuiles()[z]);
            update();
        }
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}


        
}


