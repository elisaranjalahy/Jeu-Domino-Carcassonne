package modelecarcassonne;

import java.util.Random;

public class TuileCarcassonne{
    private String[] tab=new String[4];
    public boolean pion;
    public int numJoueur;

    public TuileCarcassonne(){
        for(int i=0;i<tab.length;i++){
            tab[i]="  vide  ";
            
        }
        pion=false;
    }
    public TuileCarcassonne(int numJoueur){
        for(int i=0;i<tab.length;i++){
            tab[i]="  vide  ";
            
        }
        pion=false;
        this.numJoueur=numJoueur;
    }
    public String[] getTab(){
        return tab;
    }
    public void setTab(int i, String k){
        tab[i]=k;
    }
    public boolean estVide(int n){// return true si la face n de la tuile est vide 
        if (tab[n].equals("  vide  ")) return true;
        return false;
    }
    public boolean estRemplie(){// return true si toutes les faces sont remplies
        for (int i=0; i<this.tab.length;i++){
            if (estVide(i)) return false;
        }
        return true;
    }
    public void construireFaceTuile(int x,int y,int z,int t){
        int i=0;
        while(i<4&&!estVide(i)){
            i++;
        }
        if(!estRemplie()){
            if(x==0) tab[0]=" ville  ";
            if(x==1) tab[0]="riviere ";
            if(x==2) tab[0]=" route  ";
            if(x==3) tab[0]=" abbaye ";
            if(x==4) tab[0]="campagne";

            if(y==0) tab[1]=" ville  ";
            if(y==1) tab[1]="riviere ";
            if(y==2) tab[1]=" route  ";
            if(y==3) tab[1]=" abbaye ";
            if(y==4) tab[1]="campagne";

            if(z==0) tab[2]=" ville  ";
            if(z==1) tab[2]="riviere ";
            if(z==2) tab[2]=" route  ";
            if(z==3) tab[2]=" abbaye ";
            if(z==4) tab[2]="campagne";

            if(t==0) tab[3]=" ville  ";
            if(t==1) tab[3]="riviere ";
            if(t==2) tab[3]=" route  ";
            if(t==3) tab[3]=" abbaye ";
            if(t==4) tab[3]="campagne";
        }
    }

    public boolean comparerface(String face1,String face2){
        if(!face1.equals(face2)) return false;
        return true;
    }
    public void afficher(){
        if(!estRemplie()){
            System.out.print("*");
        }
        else{
            System.out.println("*"+tab[2].charAt(0)+tab[2].charAt(1)+tab[2].charAt(2)+tab[2].charAt(3)+tab[2].charAt(4)+tab[2].charAt(5)+tab[2].charAt(6)+tab[2].charAt(7)+"*");
            System.out.println(tab[3].charAt(0)+"        "+tab[1].charAt(0));
            System.out.println(tab[3].charAt(1)+"        "+tab[1].charAt(1));
            System.out.println(tab[3].charAt(2)+"        "+tab[1].charAt(2));
            System.out.println(tab[3].charAt(3)+"        "+tab[1].charAt(3));
            System.out.println(tab[3].charAt(4)+"        "+tab[1].charAt(4));
            System.out.println(tab[3].charAt(5)+"        "+tab[1].charAt(5));
            System.out.println(tab[3].charAt(6)+"        "+tab[1].charAt(6));
            System.out.println(tab[3].charAt(7)+"        "+tab[1].charAt(7));
            System.out.println("*"+tab[0].charAt(0)+tab[0].charAt(1)+tab[0].charAt(2)+tab[0].charAt(3)+tab[0].charAt(4)+tab[0].charAt(5)+tab[0].charAt(6)+tab[0].charAt(7)+"*");
        }

    }
    public String ligne1(){
        return "*"+tab[2].charAt(0)+tab[2].charAt(1)+tab[2].charAt(2)+tab[2].charAt(3)+tab[2].charAt(4)+tab[2].charAt(5)+tab[2].charAt(6)+tab[2].charAt(7)+"*";
    }
    public String ligne2(){
        return tab[3].charAt(0)+"          "+tab[1].charAt(0);
    }
    public String ligne3(){
        return tab[3].charAt(1)+"          "+tab[1].charAt(1);
    }
    public String ligne4(){
        return tab[3].charAt(2)+"          "+tab[1].charAt(2);
    }
    public String ligne5(){
        return tab[3].charAt(3)+"          "+tab[1].charAt(3);
    }
    public String ligne6(){
        return tab[3].charAt(4)+"          "+tab[1].charAt(4);

    }
    public String ligne7(){
        return tab[3].charAt(5)+"          "+tab[1].charAt(5);
        
    }
    public String ligne8(){
        return tab[3].charAt(6)+"          "+tab[1].charAt(6);
    }
    public String ligne9(){
        return tab[3].charAt(7)+"          "+tab[1].charAt(7);
    }
    public String ligne10(){
        return "*"+tab[0].charAt(0)+tab[0].charAt(1)+tab[0].charAt(2)+tab[0].charAt(3)+tab[0].charAt(4)+tab[0].charAt(5)+tab[0].charAt(6)+tab[0].charAt(7)+"*";
    }
    
    

}