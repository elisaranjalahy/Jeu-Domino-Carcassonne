package modelecarcassonne;



public class PlateauCarcassonne{

    public TuileCarcassonne[][] plateau;
    private final int nbrMax=8;
    public JoueurCarcassonne[] joueurs;
    public SacCarcassonne sac;

    public PlateauCarcassonne(JoueurCarcassonne[] joueur,SacCarcassonne s){
        if (joueur.length<=nbrMax) {
            joueurs=joueur;
            sac=s;
            plateau=new TuileCarcassonne[6][25]; //a revoir valer d'un plateau
            for (int i=0 ;i<plateau.length ;i++){
                for (int k=0;k<plateau[0].length;k++){
                    plateau[i][k]=new TuileCarcassonne();
                }
            }
            
        } else {
            System.out.println("Il y a trop de joueur");
        }
        
        

    }
    public void changerDimension(int x,int y){
        TuileCarcassonne[][] nouv=new TuileCarcassonne[x][y];
        for (int i=0 ;i<nouv.length ;i++){
            for (int k=0;k<nouv[0].length;k++){
                nouv[i][k]=new TuileCarcassonne();
            }
        }
        plateau=nouv;

    }

    public boolean finJeu(){
        for(int i= 0; i<joueurs.length; i++){
            if(joueurs[i].getMesTuiles().length==0 && !sac.estRempliSac()) return true;
        }
        return false;
    }
    



    public void afficher(){

        System.out.println();
        for(int j=0; j<plateau[0].length; j++){
            System.out.print("  "+j+"  ");
        }
        System.out.println();
        for (int i=0; i<plateau.length; i++){ 
            String s1="";
            String s2="";
            String s3="";
            String s4="";
            String s5="";
            String s6="";
            String s7="";
            String s8="";
            String s9="";
            String s10="";
            for(int j=0; j<plateau[i].length; j++){
                if(plateau[i][j].estRemplie()){
                    s1=s1+plateau[i][j].ligne1();
                    s2=s2+plateau[i][j].ligne2();
                    s3=s3+plateau[i][j].ligne3();
                    s4=s4+plateau[i][j].ligne4();
                    s5=s5+plateau[i][j].ligne5();
                    s6=s6+plateau[i][j].ligne6();
                    s7=s7+plateau[i][j].ligne7();
                    s8=s8+plateau[i][j].ligne8();
                    s9=s9+plateau[i][j].ligne9();
                    s10=s10+plateau[i][j].ligne10();
                }else{
                    s1=s1+".....";
                    s2=s2+".....";
                    s3=s3+".....";
                    s4=s4+".....";
                    s5=s5+".....";
                    s6=s6+".....";
                    s7=s7+".....";
                    s8=s8+".....";
                    s9=s9+".....";
                    s10=s10+".....";
                }
            }
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            System.out.println(s5+"   "+i);
            System.out.println(s6);
            System.out.println(s7);
            System.out.println(s8);
            System.out.println(s9);
            System.out.println(s10);
        }
        System.out.println();
    }



    
    public boolean correspond(int indiceFace, String face,TuileCarcassonne tuile){
        if(indiceFace==0){
            if(!tuile.comparerface(face,tuile.getTab()[2])) return false;
        }
        if(indiceFace==1){
            if(!tuile.comparerface(face,tuile.getTab()[3])) return false;
        }
        if(indiceFace==2){
            if(!tuile.comparerface(face,tuile.getTab()[0])) return false;
        }
        if(indiceFace==3){
            if(!tuile.comparerface(face,tuile.getTab()[1])) return false;
        }
        return true;
    }
    public boolean placerTuile(JoueurCarcassonne j,int numTuile,int ligne,int colonne){
        if(colonne!=0){
            if(plateau[ligne][colonne-1].estRemplie()){
                if(!correspond(1,plateau[ligne][colonne-1].getTab()[1],j.getMesTuiles()[numTuile])) return false;
            

            }
        }
        if(ligne!=plateau.length-1){
            if(plateau[ligne+1][colonne].estRemplie()){
                if(!correspond(2,plateau[ligne+1][colonne].getTab()[2],j.getMesTuiles()[numTuile])) return false;
            
            }
        }
        if(colonne!=plateau[0].length-1){
            if(plateau[ligne][colonne+1].estRemplie()){
                if(!correspond(3,plateau[ligne][colonne+1].getTab()[3],j.getMesTuiles()[numTuile])) return false;
            }
        }
        if(ligne!=0){
            if(plateau[ligne-1][colonne].estRemplie()){
                if(!correspond(0,plateau[ligne-1][colonne].getTab()[0],j.getMesTuiles()[numTuile])) return false;
            }
        }

        if(ligne ==0 && colonne!=0 && colonne != plateau[0].length-1){
            if(!plateau[ligne][colonne+1].estRemplie() && !plateau[ligne][colonne-1].estRemplie() && !plateau[ligne+1][colonne].estRemplie()){
                return false;
            }
        }else if(ligne ==0 && colonne ==0){
            if(!plateau[ligne][colonne+1].estRemplie() && !plateau[ligne+1][colonne].estRemplie()){
                return false;
            }
        }else if(ligne == 0 && colonne == plateau[0].length-1 ){
            if(!plateau[ligne+1][colonne].estRemplie() && !plateau[ligne][colonne-1].estRemplie()){
                return false;
            }
        }else if(colonne == 0 && ligne !=0 && ligne != plateau.length-1){
            if(!plateau[ligne-1][colonne].estRemplie() && !plateau[ligne][colonne+1].estRemplie() && !plateau[ligne+1][colonne].estRemplie()){
                return false;
            }
        }else if(colonne ==0 && ligne == plateau.length-1){
            if(!plateau[ligne][colonne+1].estRemplie() && !plateau[ligne-1][colonne].estRemplie() ){
                return false;
            }
        }else if(colonne==plateau[0].length-1 && ligne == plateau.length-1){
            if(!plateau[ligne-1][colonne].estRemplie() && !plateau[ligne][colonne-1].estRemplie()){
                return false;
            }
        }else if(colonne!=plateau[0].length-1 && ligne == plateau.length-1 && colonne !=0){
            if(!plateau[ligne-1][colonne].estRemplie() && !plateau[ligne][colonne-1].estRemplie() &&  !plateau[ligne][colonne+1].estRemplie() ){
                return false;
            }
        }else if(colonne== plateau[0].length-1 && ligne != 0 && ligne!= plateau.length-1){
            if(!plateau[ligne-1][colonne].estRemplie() && !plateau[ligne][colonne-1].estRemplie()&& !plateau[ligne +1][colonne].estRemplie()){
                return false;
            }
        }else if(ligne!=0 && ligne !=plateau.length-1 && colonne!= 0 && colonne!=plateau[0].length-1){
            if(!plateau[ligne-1][colonne].estRemplie() && !plateau[ligne][colonne+1].estRemplie() && !plateau[ligne+1][colonne].estRemplie() && !plateau[ligne][colonne-1].estRemplie() ){
                return false;
            }
        }
        
        
        plateau[ligne][colonne]=j.getMesTuiles()[numTuile];
        return true;

    }
    public int[] placerTuileIa(JoueurCarcassonne j){
        int [] tuileJoue = new int [3];
        for(int i=0; i<j.getMesTuiles().length;i++){
            for(int ligne=0; ligne<plateau.length; ligne++){
                for(int colonne=0; colonne<plateau[ligne].length;colonne++){
                    int tour = 0;
                    while (tour<4){
                    j.tourner(j.getMesTuiles()[i],tour);
                        if(placerTuile(j, i, ligne, colonne)) { 
                            tuileJoue[0]=i;
                            tuileJoue[1]= ligne;
                            tuileJoue[2]= colonne;
                            return tuileJoue;
                        }
                        tour++;
                    }




                }
            }
        }

        return new int[1];
    }



}