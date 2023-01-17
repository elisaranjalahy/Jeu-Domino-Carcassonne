package viewcarcassonne;

import modelecarcassonne.*;



import java.util.Scanner;



public class TerminalViewCarcassonne{

    
    public static void main(String [] args){

        JoueurCarcassonne [] listeDesJoueurs;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour et bienvenue sur Carcassonne");

    //Nombre de joueurs
        
        int nbrJoueur=0;
         do{

            System.out.println("voulez vous quitter le jeu ?  o/n ");
            String reponse = scanner.nextLine();
            if(reponse.equals("o")){
                scanner.close(); //a revoir
            }
            System.out.println("Combien il y a-t-il de joueurs ? (nombre de joueurs possible : 8)");
            nbrJoueur = scanner.nextInt();

        
        }while(nbrJoueur>8);

        
    //Liste des joueurs  

        listeDesJoueurs= new JoueurCarcassonne[nbrJoueur];
            int compteur = 1;
            do{
                System.out.println("Prenom du joueurs "+ compteur);
                Scanner sc = new Scanner(System.in);
                String prenom = sc.nextLine();
                //System.out.println("Prenom du joueurs "+ compteur);
                
                
                System.out.println("Ce joueur est-il un ordinateur ? o/n");
                Scanner scan = new Scanner(System.in);
                if(scan.nextLine().equals("o")){
                    listeDesJoueurs[compteur-1]=new JoueurCarcassonne(prenom, true);
                }else{
                    listeDesJoueurs[compteur-1]=new JoueurCarcassonne(prenom, false);

                }
               
                compteur++;
                
            }while(compteur<=listeDesJoueurs.length);

            
        
    //Initialisation du plateau

        SacCarcassonne sac= new SacCarcassonne(10);
        sac.remplirSac();
        PlateauCarcassonne plateau = new PlateauCarcassonne(listeDesJoueurs, sac);
        TuileCarcassonne tuileInitiale=plateau.sac.piocher();
        plateau.sac.uneTuileEnMoins(tuileInitiale);
        plateau.plateau[plateau.plateau.length/2][plateau.plateau[0].length/2]=tuileInitiale;
        plateau.afficher();
        
        

    //Déroulé d'une partie

        while(!plateau.finJeu()){
            for(int i=0; i<plateau.joueurs.length;i++){
                if(plateau.sac.estRempliSac()){
                    TuileCarcassonne pioche=plateau.sac.piocher();
                    plateau.sac.uneTuileEnMoins(pioche);
                    plateau.joueurs[i].rangerTuile(pioche);
                }
                plateau.joueurs[i].afficheTuileJoueur(); //à écrire : fait

                if(plateau.joueurs[i].ia){
                    int [] tab = plateau.placerTuileIa(plateau.joueurs[i]);
                    if(tab.length!=1){
                        plateau.plateau[tab[1]][tab[2]]=plateau.joueurs[i].getMesTuiles()[tab[0]];
                        plateau.joueurs[i].utiliserTuile(plateau.joueurs[i].getMesTuiles()[tab[0]]);
                        plateau.afficher();
                    }

                }else{

                    System.out.println(plateau.joueurs[i].getNom()+". Quelle tuile veux-tu jouer ?  (15 si aucune) ");
                    int numeroTuile = scanner.nextInt();


                    if(numeroTuile !=15){
                        System.out.println("Choisissez à present où placer votre tuile : ");
                        System.out.println("Choisissez une ligne");
                        int ligne = scanner.nextInt();
                        System.out.println("Choisissez une colonne");
                        int colonne = scanner.nextInt();
                        System.out.println("Combien de rotation avant de la placer(0 si pas nécessaire)");
                        int tour=scanner.nextInt();
                        plateau.joueurs[i].tourner(plateau.joueurs[i].getMesTuiles()[numeroTuile],tour);
                    

                        if(plateau.placerTuile(plateau.joueurs[i],numeroTuile,ligne, colonne)){
                            plateau.plateau[ligne][colonne]=plateau.joueurs[i].getMesTuiles()[numeroTuile];
                            plateau.joueurs[i].utiliserTuile(plateau.joueurs[i].getMesTuiles()[numeroTuile]);
                            plateau.afficher();
                        }else{
                            System.out.println("Cette tuile ne peut être posée");
                        }
                    }
                }


            }

            
        }
        System.out.println("Fin de partie ");
    }
    
}
