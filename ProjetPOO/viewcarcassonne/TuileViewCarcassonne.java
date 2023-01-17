package viewcarcassonne;
import modelecarcassonne.*;
import java.lang.Object;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.*;
public class TuileViewCarcassonne extends JPanel{
    public TuileViewCarcassonne(TuileCarcassonne t){
        super();
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

        if(t.getTab()[2].equals(" ville  ")){
            j12.setBackground(Color.YELLOW);
            j13.setBackground(Color.YELLOW);
            j14.setBackground(Color.YELLOW);
        }
        if(t.getTab()[2].equals("riviere ")){
            j12.setBackground(Color.BLUE);
            j13.setBackground(Color.BLUE);
            j14.setBackground(Color.BLUE);
        }
        if(t.getTab()[2].equals(" route  ")){
            j12.setBackground(Color.GRAY);
            j13.setBackground(Color.GRAY);
            j14.setBackground(Color.GRAY);
        }
        if(t.getTab()[2].equals(" abbaye ")){
            j12.setBackground(Color.WHITE);
            j13.setBackground(Color.WHITE);
            j14.setBackground(Color.WHITE);
        }
        if(t.getTab()[2].equals("campagne")){
            j12.setBackground(Color.GREEN);
            j13.setBackground(Color.GREEN);
            j14.setBackground(Color.GREEN);
        }



        if(t.getTab()[3].equals(" ville  ")){
            j21.setBackground(Color.YELLOW);
            j31.setBackground(Color.YELLOW);
            j41.setBackground(Color.YELLOW);
        }
        if(t.getTab()[3].equals("riviere ")){
            j21.setBackground(Color.BLUE);
            j31.setBackground(Color.BLUE);
            j41.setBackground(Color.BLUE);
        }
        if(t.getTab()[3].equals(" route  ")){
            j21.setBackground(Color.GRAY);
            j31.setBackground(Color.GRAY);
            j41.setBackground(Color.GRAY);
        }
        if(t.getTab()[3].equals(" abbaye ")){
            j21.setBackground(Color.WHITE);
            j31.setBackground(Color.WHITE);
            j41.setBackground(Color.WHITE);
        }
        if(t.getTab()[3].equals("campagne")){
            j21.setBackground(Color.GREEN);
            j31.setBackground(Color.GREEN);
            j41.setBackground(Color.GREEN);
        }


        if(t.getTab()[1].equals(" ville  ")){
            j25.setBackground(Color.YELLOW);
            j35.setBackground(Color.YELLOW);
            j45.setBackground(Color.YELLOW);
        }
        if(t.getTab()[1].equals("riviere ")){
            j25.setBackground(Color.BLUE);
            j35.setBackground(Color.BLUE);
            j45.setBackground(Color.BLUE);
        }
        if(t.getTab()[1].equals(" route  ")){
            j25.setBackground(Color.GRAY);
            j35.setBackground(Color.GRAY);
            j45.setBackground(Color.GRAY);
        }
        if(t.getTab()[1].equals(" abbaye ")){
            j25.setBackground(Color.WHITE);
            j35.setBackground(Color.WHITE);
            j45.setBackground(Color.WHITE);
        }
        if(t.getTab()[1].equals("campagne")){
            j25.setBackground(Color.GREEN);
            j35.setBackground(Color.GREEN);
            j45.setBackground(Color.GREEN);
        }

        if(t.getTab()[0].equals(" ville  ")){
            j52.setBackground(Color.YELLOW);
            j53.setBackground(Color.YELLOW);
            j54.setBackground(Color.YELLOW);
        }
        if(t.getTab()[0].equals("riviere ")){
            j52.setBackground(Color.BLUE);
            j53.setBackground(Color.BLUE);
            j54.setBackground(Color.BLUE);
        }
        if(t.getTab()[0].equals(" route  ")){
            j52.setBackground(Color.GRAY);
            j53.setBackground(Color.GRAY);
            j54.setBackground(Color.GRAY);
        }
        if(t.getTab()[0].equals(" abbaye ")){
            j52.setBackground(Color.WHITE);
            j53.setBackground(Color.WHITE);
            j54.setBackground(Color.WHITE);
        }
        if(t.getTab()[0].equals("campagne")){
            j52.setBackground(Color.GREEN);
            j53.setBackground(Color.GREEN);
            j54.setBackground(Color.GREEN);
        }


        
        
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
