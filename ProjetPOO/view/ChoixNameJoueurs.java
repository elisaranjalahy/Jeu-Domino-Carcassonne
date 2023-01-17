package view;
import modele.*;
import view.*;

import javax.swing.*;
import java.awt.*;

public class ChoixNameJoueurs extends JFrame {
    public ChoixNameJoueurs(int n){
        super();
        setTitle("Choix");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,2*screenSize.width/2, screenSize.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        JPanel p3=new JPanel();
        Joueur[] listeJoueurs=new Joueur[n];
        for (int i=0;i<n;i++){
            JTextField text=new JTextField("Prenom Joueur"+(i+1));
            text.setSize(10,10);
            p3.add(text);
            JButton num=new JButton(String.valueOf(i));
            JButton humain=new JButton("humain");
            p3.add(humain);
            JButton ordinateur=new JButton("ordinateur");
            p3.add(ordinateur);
            humain.addActionListener((e) -> {
                humain.setVisible(false);
                ordinateur.setVisible(false);
                listeJoueurs[Integer.valueOf(num.getText())]=new Joueur(text.getText());
            });
            
            ordinateur.addActionListener((e) -> {
                ordinateur.setVisible(false);
                humain.setVisible(false);
                listeJoueurs[Integer.valueOf(num.getText())]=new Joueur(text.getText(),true);
            });
            

        }
        JButton suivant=new JButton("suivant");
        p3.add(suivant);
        suivant.addActionListener((e) -> {
            this.dispose();
            new JeuView(listeJoueurs);});
        
        this.getContentPane().add(p3);
    }
}
