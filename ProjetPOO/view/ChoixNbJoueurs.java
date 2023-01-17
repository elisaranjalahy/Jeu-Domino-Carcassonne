package view;
import modele.*;
import view.*;

import javax.swing.*;
import java.awt.*;

public class ChoixNbJoueurs extends JFrame{
    public ChoixNbJoueurs(){
        super();
        setTitle("Choix");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,2*screenSize.width/2, screenSize.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        JPanel p1=new JPanel();

        JLabel label=new JLabel("Combien il y a-t-il de joueurs ?");
        p1.add(label);

        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");

        b1.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(1);
        });
        b2.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(2);});
        b3.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(3);});
        b4.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(4);});
        b5.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(5);});
        b6.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(6);});
        b7.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(7);});
        b8.addActionListener((e)-> {
            this.dispose();
            new ChoixNameJoueurs(8); });

        p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);

        this.getContentPane().add(p1);

    }
}