package modele;

import java.util.Random;

public class Sac{

    private Tuile[]sac;
    private int nbrTuilesTotales; //nbr de tuile au debut du jeu
    private int nbrTuilesCourant; //nbr de tuile à l'instant t du jeu


//tableau
    
    public Sac(int nbrTuilesTotales){

        this.nbrTuilesTotales=nbrTuilesTotales;
        this.nbrTuilesCourant= nbrTuilesTotales;
        sac= new Tuile[nbrTuilesTotales];
        for(int i =0; i<sac.length;i++){
            sac[i]=new Tuile();
        }
    }
    public void afficher(){
        for (int i=0; i<sac.length;i++){
            sac[i].afficher();
            
        }

    }
    

    public void remplirSac(){
        int i1=0;
        int j1=nbrTuilesTotales/2;
        while(i1<nbrTuilesTotales/2&&j1<nbrTuilesTotales){
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            int z = (int)(Math.random()*10);
            sac[i1].construireFaceTuile(x,y,z);
            sac[j1].construireFaceTuile(x,y,z);
            i1++;
            j1++;
        }
        int i2=0;
        int j2=nbrTuilesTotales-1;
        while(i2<nbrTuilesTotales/2&&j2>=nbrTuilesTotales/2){
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            int z = (int)(Math.random()*10);
            sac[i2].construireFaceTuile(x,y,z);
            sac[j2].construireFaceTuile(x,y,z);
            i2++;
            j2--;
        }
        int i3=0;
        int j3=nbrTuilesTotales/2;
        while(i3<nbrTuilesTotales/2 && j3<nbrTuilesTotales){
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            int z = (int)(Math.random()*10);
            sac[i3].construireFaceTuile(x,y,z);
            sac[j3].construireFaceTuile(x,y,z);
            i3++;
            if((nbrTuilesTotales/2)%2==0){
                if(j3==nbrTuilesTotales-2){
                    j3=nbrTuilesTotales/2+1;
                } else {
                    j3+=2;
                }
            }
            if((nbrTuilesTotales/2)%2!=0){
                if(j3==nbrTuilesTotales-1){
                    j3=nbrTuilesTotales/2+1;
                } else {
                    j3+=2;
                }
                
            }
        }
        int i4=0;
        int j4=nbrTuilesTotales-1;
        while(i4<nbrTuilesTotales/2 && j4>=nbrTuilesTotales/2){
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            int z = (int)(Math.random()*10);
            sac[i4].construireFaceTuile(x,y,z);
            sac[j4].construireFaceTuile(x,y,z);
            if((nbrTuilesTotales/2)%2==0){
                if(i4==nbrTuilesTotales/2-2){
                    i4=1;
                } else {
                    i4+=2;
                }
            }
            if((nbrTuilesTotales/2)%2!=0){
                if(i4==nbrTuilesTotales/2-1){
                    i4=1;
                } else {
                    i4+=2;
                }
                
            }
            j4--;
        }


        

    }
    
    public Tuile piocher(){
        if(!estVide()){
            Random random = new Random();
            int nb;
            nb = random.nextInt(nbrTuilesTotales); //choix d'un entier aleatoire entre 0 et le nombre de tuile totale dans le sac pour choisir une position dans le sac et donc la tuile a retirer
            Tuile t=sac[nb];
            return t;
        
        }     
        return new Tuile();
    }
    
    public void uneTuileEnMoins(Tuile t){
        Tuile [] nouvTab = new Tuile[sac.length-1];
        int i=0;
        for (Tuile tui:sac){
            if(!tui.equals(t)){
                nouvTab[i]=tui;
                i++;
            }
        }
        nbrTuilesTotales--;
        sac=nouvTab;
    }
        

    public boolean estRempliSac(){
        if(sac.length==0){return false;}
        for(Tuile t : sac){
            if(t==null) return false;
            if(!(t.estRemplie()))return false;
        }
        return true;
    }

    public boolean estVide(){
        if(sac==null) return true;
        return false;
    }

    public Tuile[] getTabTuile(){
        return sac;
    }
    public Tuile[] getSac(){return sac;}
    public void setSac(Tuile []sac){ this.sac=sac;}
    
}