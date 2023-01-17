package modelecarcassonne;

import java.util.Random;


public class SacCarcassonne{

    private TuileCarcassonne[] sac;
    private int nbrTuilesTotales; //nbr de tuile au debut du jeu
    private int nbrTuilesCourant; //nbr de tuile à l'instant t du jeu


//tableau
    
    public SacCarcassonne(int nbrTuilesTotales){

        this.nbrTuilesTotales=nbrTuilesTotales;
        this.nbrTuilesCourant= nbrTuilesTotales;
        sac= new TuileCarcassonne[nbrTuilesTotales];
        for(int i =0; i<sac.length;i++){
            sac[i]=new TuileCarcassonne();
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
            int x = (int)(Math.random()*5);
            int y = (int)(Math.random()*5);
            int z = (int)(Math.random()*5);
            int t = (int)(Math.random()*5);
            sac[i1].construireFaceTuile(x,y,z,t);
            sac[j1].construireFaceTuile(x,y,z,t);
            i1++;
            j1++;
        }
        int i2=0;
        int j2=nbrTuilesTotales-1;
        while(i2<nbrTuilesTotales/2&&j2>=nbrTuilesTotales/2){
            int x = (int)(Math.random()*5);
            int y = (int)(Math.random()*5);
            int z = (int)(Math.random()*5);
            int t = (int)(Math.random()*5);
            sac[i2].construireFaceTuile(x,y,z,t);
            sac[j2].construireFaceTuile(x,y,z,t);
            i2++;
            j2--;
        }
        int i3=0;
        int j3=nbrTuilesTotales/2;
        while(i3<nbrTuilesTotales/2 && j3<nbrTuilesTotales){
            int x = (int)(Math.random()*5);
            int y = (int)(Math.random()*5);
            int z = (int)(Math.random()*5);
            int t = (int)(Math.random()*5);
            sac[i3].construireFaceTuile(x,y,z,t);
            sac[j3].construireFaceTuile(x,y,z,t);
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
            int x = (int)(Math.random()*5);
            int y = (int)(Math.random()*5);
            int z = (int)(Math.random()*5);
            int t = (int)(Math.random()*5);
            sac[i4].construireFaceTuile(x,y,z,t);
            sac[j4].construireFaceTuile(x,y,z,t);
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
    
    public TuileCarcassonne piocher(){
        if(!estVide()){
            Random random = new Random();
            int nb;
            nb = random.nextInt(nbrTuilesTotales); //choix d'un entier aleatoire entre 0 et le nombre de tuile totale dans le sac pour choisir une position dans le sac et donc la tuile a retirer
            TuileCarcassonne t=sac[nb];
            return t;
        
        }     
        return new TuileCarcassonne();
    }
    
    public void uneTuileEnMoins(TuileCarcassonne t){
        TuileCarcassonne [] nouvTab = new TuileCarcassonne[sac.length-1];
        int i=0;
        for (TuileCarcassonne tui:sac){
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
        for(TuileCarcassonne t : sac){
            if(t==null) return false;
            if(!(t.estRemplie()))return false;
        }
        return true;
    }

    public boolean estVide(){
        if(sac==null) return true;
        return false;
    }

    public TuileCarcassonne[] getTabTuile(){
        return sac;
    }
    public TuileCarcassonne[] getSac(){return sac;}
    public void setSac(TuileCarcassonne []sac){ this.sac=sac;}
    
}