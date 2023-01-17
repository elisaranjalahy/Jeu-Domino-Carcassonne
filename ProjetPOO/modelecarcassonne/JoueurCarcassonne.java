package modelecarcassonne;

import modelecarcassonne.*;

public class JoueurCarcassonne{
    private TuileCarcassonne[] mesTuiles;
    private String nom;
    public boolean aJoue=false;
    public boolean ia;


    public JoueurCarcassonne(String nom, boolean ia){
        mesTuiles=new TuileCarcassonne[10];
        for(int i=0;i<mesTuiles.length;i++){
            mesTuiles[i]=new TuileCarcassonne();
        }
        this.nom=nom;
        this.ia=ia;
    }
    public JoueurCarcassonne(String nom){
        mesTuiles=new TuileCarcassonne[10];
        for(int i=0;i<mesTuiles.length;i++){
            mesTuiles[i]=new TuileCarcassonne();
        }
        this.nom=nom;
    }

    public TuileCarcassonne[] getMesTuiles(){return mesTuiles;}
    public void setIa(boolean b){
        ia=b;
    }
    public String getNom(){return nom;}
    public void setNom(String t){
        nom=t;
    }
    public void setMesTuiles(TuileCarcassonne[] t){ mesTuiles=t;}

    public void utiliserTuile(TuileCarcassonne t){
        for (int i=0;i<mesTuiles.length;i++){
            if(mesTuiles[i].equals(t)){
                mesTuiles[i]=new TuileCarcassonne();
            }
        }
    }

    public void rangerTuile(TuileCarcassonne t){
        int x=0;
        int i=0;
        while(x==0&&i<mesTuiles.length){
            if(!mesTuiles[i].estRemplie()) {
                mesTuiles[i]=t; 
                x=1;
            }
            i++;

        }
        
    }

   

    public void afficheTuileJoueur(){

        System.out.println();
        System.out.println("TOUR :" + nom+".");
        System.out.println("Liste des tuiles :");
        System.out.println();
        for(int i=0; i<mesTuiles.length;i++){
            if(mesTuiles[i]!=null){
                mesTuiles[i].afficher();
                System.out.println("  "+"("+i+")");
                System.out.println();
            }else{
            System.out.print("  "+i);
            System.out.print("  ");
            }

        }

        System.out.println();
    }

    public void tourner(TuileCarcassonne tuile,int tour){
        int i=0;
        for(TuileCarcassonne t:mesTuiles){
            if(t.equals(tuile)){
                while(i<tour){
                    String t0=t.getTab()[0];
                    String t1=t.getTab()[1];
                    String t2=t.getTab()[2];
                    String t3=t.getTab()[3];
                    t.setTab(0,t1);
                    t.setTab(1,t2);
                    t.setTab(2,t3);
                    t.setTab(3,t0);
                    i++;
                }

            }
        }
    }
}
