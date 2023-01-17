
import modele.*;
import view.*;
import modelecarcassonne.*;
import viewcarcassonne.*;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame{
    public MenuView(){
        super();
        setTitle("Menu");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,2*screenSize.width/2, screenSize.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

        this.getContentPane().setLayout(new GridLayout(3,3));
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        JPanel p6=new JPanel();
        JPanel p7=new JPanel();
        JPanel p8=new JPanel();
        JPanel p9=new JPanel();

        JLabel label=new JLabel("Bienvenue");
        p2.add(label);
        JButton domino=new JButton("Domino");
        JButton carcassonne=new JButton("Carcassonne");
        domino.addActionListener((e)->{
            this.dispose();
            new ChoixNbJoueurs();
        });
        carcassonne.addActionListener((e)-> {
            this.dispose();
            new ChoixNbJoueursCarcassonneView();
        });
        JButton quitter=new JButton("quitter");
        quitter.addActionListener((e) ->{
            this.dispose();
        });
        p5.setLayout(new BoxLayout(p5,BoxLayout.PAGE_AXIS));
        p5.add(quitter);
        p5.add(domino);
        p5.add(carcassonne);
        this.getContentPane().add(p1);
        this.getContentPane().add(p2);
        this.getContentPane().add(p3);
        this.getContentPane().add(p4);
        this.getContentPane().add(p5);
        this.getContentPane().add(p6);
        this.getContentPane().add(p7);
        this.getContentPane().add(p8);
        this.getContentPane().add(p9);

    }
    
}
