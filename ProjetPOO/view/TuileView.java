package view;
import modele.*;
import modele.Tuile;
import java.lang.Object;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.*;
public class TuileView extends JPanel{
    public TuileView(Tuile t){
        super();
        //setTitle("Tuile");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        //setBounds(new Rectangle((0,0, 600);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds(0,0,screenSize.height/10,screenSize.width/10);
        JPanel j11=new JPanel();
        JPanel j12=new JPanel();
        JPanel j13=new JPanel();
        JPanel j14=new JPanel();
        JPanel j15=new JPanel();

        JPanel j21=new JPanel();
        JPanel j22=new JPanel();
        JPanel j23=new JPanel();
        JPanel j24=new JPanel();
        JPanel j25=new JPanel();

        JPanel j31=new JPanel();
        JPanel j32=new JPanel();
        JPanel j33=new JPanel();
        JPanel j34=new JPanel();
        JPanel j35=new JPanel();

        JPanel j41=new JPanel();
        JPanel j42=new JPanel();
        JPanel j43=new JPanel();
        JPanel j44=new JPanel();
        JPanel j45=new JPanel();

        JPanel j51=new JPanel();
        JPanel j52=new JPanel();
        JPanel j53=new JPanel();
        JPanel j54=new JPanel();
        JPanel j55=new JPanel();

        j11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j21.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j25.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j31.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j35.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j41.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j45.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j51.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j52.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j53.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j54.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        j55.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        j11.setBackground(Color.BLACK);
        j15.setBackground(Color.BLACK);
        j51.setBackground(Color.BLACK);
        j55.setBackground(Color.BLACK);

        j22.setBackground(Color.GRAY);
        j23.setBackground(Color.GRAY);
        j24.setBackground(Color.GRAY);
        j32.setBackground(Color.GRAY);
        j33.setBackground(Color.GRAY);
        j34.setBackground(Color.GRAY);
        j42.setBackground(Color.GRAY);
        j43.setBackground(Color.GRAY);
        j44.setBackground(Color.GRAY);

        j12.add(new JLabel(String.valueOf(t.getTab()[2][0])));
        j13.add(new JLabel(String.valueOf(t.getTab()[2][1])));
        j14.add(new JLabel(String.valueOf(t.getTab()[2][2])));
        j21.add(new JLabel(String.valueOf(t.getTab()[3][0])));
        j25.add(new JLabel(String.valueOf(t.getTab()[1][0])));
        j31.add(new JLabel(String.valueOf(t.getTab()[3][1])));
        j35.add(new JLabel(String.valueOf(t.getTab()[1][1])));
        j41.add(new JLabel(String.valueOf(t.getTab()[3][2])));
        j45.add(new JLabel(String.valueOf(t.getTab()[1][2])));
        j52.add(new JLabel(String.valueOf(t.getTab()[0][0])));
        j53.add(new JLabel(String.valueOf(t.getTab()[0][1])));
        j54.add(new JLabel(String.valueOf(t.getTab()[0][2])));
        this.setLayout(new GridLayout(5,5));
        this.add(j11);
        this.add(j12);
        this.add(j13);
        this.add(j14);
        this.add(j15);
        this.add(j21);
        this.add(j22);
        this.add(j23);
        this.add(j24);
        this.add(j25);
        this.add(j31);
        this.add(j32);
        this.add(j33);
        this.add(j34);
        this.add(j35);
        this.add(j41);
        this.add(j42);
        this.add(j43);
        this.add(j44);
        this.add(j45);
        this.add(j51);
        this.add(j52);
        this.add(j53);
        this.add(j54);
        this.add(j55);
    }
}