package modele;

public class Joueur{
    private int score = 0;
    private Tuile [] mesTuiles;
    private String nom;
    public boolean aJoue=false;
    public boolean ia;

    public Joueur(String nom, boolean ia){
        mesTuiles=new Tuile[10];
        for(int i=0;i<mesTuiles.length;i++){
            mesTuiles[i]=new Tuile();
        }
        this.nom=nom;
        this.ia=ia;
    }

    public Joueur(String nom){
        mesTuiles=new Tuile[10];
        for(int i=0;i<mesTuiles.length;i++){
            mesTuiles[i]=new Tuile();
        }
        this.nom=nom;
    }

    public Tuile [] getMesTuiles(){return mesTuiles;}
    public void setIa(boolean b){
        ia=b;
    }
    public String getNom(){return nom;}
    public void setNom(String t){
        nom=t;
    }
    public int getScore(){return score;}
    public void setScore(int s){
        score+=s;
    }
    public void setMesTuiles(Tuile[] t){ mesTuiles=t;}

    public void utiliserTuile(Tuile t){
        for (int i=0;i<mesTuiles.length;i++){
            if(mesTuiles[i].equals(t)){
                mesTuiles[i]=new Tuile();
            }
        }
    }
        
    
    



    public void rangerTuile(Tuile t){
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

    public void tourner(Tuile tuile,int tour){
        int i=0;
        for(Tuile t:mesTuiles){
            if(t.equals(tuile)){
                while(i<tour){
                    int[] t0=t.getTab()[0];
                    int[] t1=t.getTab()[1];
                    int[] t2=t.getTab()[2];
                    int[] t3=t.getTab()[3];
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
