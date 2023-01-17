package modele;

public class Plateau {

    public Tuile[][] plateau;
    private final int nbrMax = 8;
    public Joueur[] joueurs;
    public Sac sac;

    public Plateau(Joueur[] joueur, Sac s) {
        if (joueur.length <= nbrMax) {
            joueurs = joueur;
            sac = s;
            plateau = new Tuile[10][18]; // a revoir valer d'un plateau
            for (int i = 0; i < plateau.length; i++) {
                for (int k = 0; k < plateau[0].length; k++) {
                    plateau[i][k] = new Tuile();
                }
            }

        } else {
            System.out.println("Il y a trop de joueur");
        }

    }

    public void changerDimension(int x, int y) {
        Tuile[][] nouv = new Tuile[x][y];
        for (int i = 0; i < nouv.length; i++) {
            for (int k = 0; k < nouv[0].length; k++) {
                nouv[i][k] = new Tuile();
            }
        }
        plateau = nouv;

    }

    public boolean finJeu() {
        for (int i = 0; i < joueurs.length; i++) {
            if (joueurs[i].getMesTuiles().length == 0 && !sac.estRempliSac())
                return true;
        }
        return false;
    }

    public String estGagnant() {
        Joueur gagnant = new Joueur("");
        for (int i = 0; i < joueurs.length - 1; i++) {
            if (joueurs[i + 1].getScore() == joueurs[i].getScore()) {
                return gagnant.getNom(); // le cas d'egalite des score
            }
            if (joueurs[i + 1].getScore() > joueurs[i].getScore()) {
                gagnant = joueurs[i + 1];
            }
        }
        return gagnant.getNom();
    }

    public void afficher() {

        System.out.println();
        for (int j = 0; j < plateau[0].length; j++) {
            System.out.print("  " + j + "  ");
        }
        System.out.println();
        for (int i = 0; i < plateau.length; i++) {
            String s1 = "";
            String s2 = "";
            String s3 = "";
            String s4 = "";
            String s5 = "";
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j].estRemplie()) {
                    s1 = s1 + plateau[i][j].ligne1();
                    s2 = s2 + plateau[i][j].ligne2();
                    s3 = s3 + plateau[i][j].ligne3();
                    s4 = s4 + plateau[i][j].ligne4();
                    s5 = s5 + plateau[i][j].ligne5();
                } else {
                    s1 = s1 + ".....";
                    s2 = s2 + ".....";
                    s3 = s3 + ".....";
                    s4 = s4 + ".....";
                    s5 = s5 + ".....";
                }
            }
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3 + "   " + i);
            System.out.println(s4);
            System.out.println(s5);
        }
        System.out.println();
    }

    public boolean correspond(int indiceFace, int[] face, Tuile tuile) {
        if (indiceFace == 0) {
            if (!tuile.comparerface(face, tuile.getTab()[2]))
                return false;
        }
        if (indiceFace == 1) {
            if (!tuile.comparerface(face, tuile.getTab()[3]))
                return false;
        }
        if (indiceFace == 2) {
            if (!tuile.comparerface(face, tuile.getTab()[0]))
                return false;
        }
        if (indiceFace == 3) {
            if (!tuile.comparerface(face, tuile.getTab()[1]))
                return false;
        }
        return true;
    }

    public boolean placerTuile(Joueur j, int numTuile, int ligne, int colonne) {
        if (colonne != 0) {
            if (plateau[ligne][colonne - 1].estRemplie()) {
                if (!correspond(1, plateau[ligne][colonne - 1].getTab()[1], j.getMesTuiles()[numTuile]))
                    return false;

            }
        }
        if (ligne != plateau.length - 1) {
            if (plateau[ligne + 1][colonne].estRemplie()) {
                if (!correspond(2, plateau[ligne + 1][colonne].getTab()[2], j.getMesTuiles()[numTuile]))
                    return false;

            }
        }
        if (colonne != plateau[0].length - 1) {
            if (plateau[ligne][colonne + 1].estRemplie()) {
                if (!correspond(3, plateau[ligne][colonne + 1].getTab()[3], j.getMesTuiles()[numTuile]))
                    return false;
            }
        }
        if (ligne != 0) {
            if (plateau[ligne - 1][colonne].estRemplie()) {
                if (!correspond(0, plateau[ligne - 1][colonne].getTab()[0], j.getMesTuiles()[numTuile]))
                    return false;
            }
        }

        if (ligne == 0 && colonne != 0 && colonne != plateau[0].length - 1) {
            if (!plateau[ligne][colonne + 1].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()
                    && !plateau[ligne + 1][colonne].estRemplie()) {
                return false;
            }
        } else if (ligne == 0 && colonne == 0) {
            if (!plateau[ligne][colonne + 1].estRemplie() && !plateau[ligne + 1][colonne].estRemplie()) {
                return false;
            }
        } else if (ligne == 0 && colonne == plateau[0].length - 1) {
            if (!plateau[ligne + 1][colonne].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()) {
                return false;
            }
        } else if (colonne == 0 && ligne != 0 && ligne != plateau.length - 1) {
            if (!plateau[ligne - 1][colonne].estRemplie() && !plateau[ligne][colonne + 1].estRemplie()
                    && !plateau[ligne + 1][colonne].estRemplie()) {
                return false;
            }
        } else if (colonne == 0 && ligne == plateau.length - 1) {
            if (!plateau[ligne][colonne + 1].estRemplie() && !plateau[ligne - 1][colonne].estRemplie()) {
                return false;
            }
        } else if (colonne == plateau[0].length - 1 && ligne == plateau.length - 1) {
            if (!plateau[ligne - 1][colonne].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()) {
                return false;
            }
        } else if (colonne != plateau[0].length - 1 && ligne == plateau.length - 1 && colonne != 0) {
            if (!plateau[ligne - 1][colonne].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()
                    && !plateau[ligne][colonne + 1].estRemplie()) {
                return false;
            }
        } else if (colonne == plateau[0].length - 1 && ligne != 0 && ligne != plateau.length - 1) {
            if (!plateau[ligne - 1][colonne].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()
                    && !plateau[ligne + 1][colonne].estRemplie()) {
                return false;
            }
        } else if (ligne != 0 && ligne != plateau.length - 1 && colonne != 0 && colonne != plateau[0].length - 1) {
            if (!plateau[ligne - 1][colonne].estRemplie() && !plateau[ligne][colonne + 1].estRemplie()
                    && !plateau[ligne + 1][colonne].estRemplie() && !plateau[ligne][colonne - 1].estRemplie()) {
                return false;
            }
        }

        if (colonne != 0)
            j.setScore(plateau[ligne][colonne - 1].getTab()[1][0] + plateau[ligne][colonne - 1].getTab()[1][1]
                    + plateau[ligne][colonne - 1].getTab()[1][2]);
        if (ligne != plateau.length - 1)
            j.setScore(plateau[ligne + 1][colonne].getTab()[2][0] + plateau[ligne + 1][colonne].getTab()[2][1]
                    + plateau[ligne + 1][colonne].getTab()[2][2]);
        if (colonne != plateau[0].length - 1)
            j.setScore(plateau[ligne][colonne + 1].getTab()[1][0] + plateau[ligne][colonne + 1].getTab()[2][1]
                    + plateau[ligne][colonne + 1].getTab()[3][1]);
        if (ligne != 0)
            j.setScore(plateau[ligne - 1][colonne].getTab()[0][0] + plateau[ligne - 1][colonne].getTab()[0][1]
                    + plateau[ligne - 1][colonne].getTab()[0][2]);
        plateau[ligne][colonne] = j.getMesTuiles()[numTuile];
        return true;

    }

    public int[] placerTuileIa(Joueur j) {
        int[] tuileJoue = new int[3];
        for (int i = 0; i < j.getMesTuiles().length; i++) {
            for (int ligne = 0; ligne < plateau.length; ligne++) {
                for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                    int tour = 0;
                    while (tour < 4) {
                        j.tourner(j.getMesTuiles()[i], tour);
                        if (placerTuile(j, i, ligne, colonne)) {
                            tuileJoue[0] = i;
                            tuileJoue[1] = ligne;
                            tuileJoue[2] = colonne;
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
