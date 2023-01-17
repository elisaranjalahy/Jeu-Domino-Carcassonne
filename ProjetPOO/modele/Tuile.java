package modele;

import java.util.Random;

public class Tuile{
    private int[][] tab=new int[4][3];

    public Tuile(){
        for(int i=0;i<tab.length;i++){
            for (int j=0;j<tab[i].length;j++){
                tab[i][j]=0;
            }
        }
    }
    public int[][] getTab(){
        return tab;
    }
    public void setTab(int i,int j, int k){
        tab[i][j]=k;
    }
    public void setTab(int i,int[] k){
        tab[i]=k;
    }
    public boolean estVide(int n){// return true si la face n de la tuile est vide 
        int x=0;
        for (int i=0;i<tab[n].length;i++){
            x+=tab[n][i];
        }
        if (x==0) return true;
        return false;
    }
    public boolean estRemplie(){// return true si toutes les faces sont remplies
        for (int i=0; i<this.tab.length;i++){
            if (estVide(i)) return false;
        }
        return true;
    }
    public void construireFaceTuile(int x,int y,int z){
        int i=0;
        while(i<4&&!estVide(i)){
            i++;
        }
        if(!estRemplie()){
            tab[i][0]=x;
            tab[i][1]=y;
            tab[i][2]=z;
        }
    }
    public int comparer(Tuile t1, Tuile t2){//renvoie l'indice du tableau de t1 ou la face est la meme que t2 et -1 s'il n'y a pas de face similaire
        int x=-1;
        for (int i=0;i<t1.tab.length;i++){
            for (int j=0;j<t2.tab.length;j++){
                if(comparer_aux(t1.tab[i],t2.tab[j])){
                    x=i;
                }
            }
        }
        return x;
    }
    public boolean comparer_aux(int[] t1,int[] t2){
        for(int i=0;i<t1.length;i++){
            if (t1[i]!=t2[i]) return false;
        }
        return true;
    }
    public boolean comparerface(int[] face1,int[] face2){
        if(face1.length!=face2.length) return false;
        for(int i=0;i<face1.length; i++){
            if(face1[i]!=face2[i]) return false;
        }
        return true;
    }
    public void afficher(){
        if(!estRemplie()){
            System.out.print("*");
        }
        else{
            System.out.println("*"+tab[2][0]+tab[2][1]+tab[2][2]+"*");
            System.out.println(tab[3][0]+"   "+tab[1][0]);
            System.out.println(tab[3][1]+"   "+tab[1][1]);
            System.out.println(tab[3][2]+"   "+tab[1][2]);
            System.out.println("*"+tab[0][0]+tab[0][1]+tab[0][2]+"*");
        }

    }
    public String ligne1(){
        return "*"+tab[2][0]+tab[2][1]+tab[2][2]+"*";
    }
    public String ligne2(){
        return tab[3][0]+"   "+tab[1][0];
    }
    public String ligne3(){
        return tab[3][1]+"   "+tab[1][1];
    }
    public String ligne4(){
        return tab[3][2]+"   "+tab[1][2];
    }
    public String ligne5(){
        return "*"+tab[0][0]+tab[0][1]+tab[0][2]+"*";
    }
    
    

}