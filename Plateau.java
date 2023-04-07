import MopionPOO.Case;

public class Plateau {
    private Case[][] cases;
    
    public Plateau(int nbCases) {
        cases = new Case[nbCases][nbCases];
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                cases[i][j] = new Case();
            }
        }
    }
    
    public Case getCase(int ligne, int colonne) {
        return cases[ligne - 1][colonne - 1];
    }
    
    public int gagne() {
        // Vérification des lignes
        for (int i = 0; i < cases.length; i++) {
            boolean ligneGagne = true;
            for (int j = 0; j < cases.length - 1; j++) {
                if (cases[i][j].GetX() != cases[i][j + 1].GetX() || cases[i][j].GetX() == 0) {
                    ligneGagne = false;
                    break;
                }
            }
            if (ligneGagne) {
                return cases[i][0].GetX();
            }
        }

        // Vérification des colonnes
        for (int i = 0; i < cases.length; i++) {
            boolean colonneGagne = true;
            for (int j = 0; j < cases.length - 1; j++) {
                if (cases[j][i].GetX() != cases[j + 1][i].GetX() || cases[j][i].GetX() == 0) {
                    colonneGagne = false;
                    break;
                }
            }
            if (colonneGagne) {
                return cases[0][i].GetX();
            }
        }

        // Vérification des diagonales
        boolean diagonaleGagne1 = true;
        boolean diagonaleGagne2 = true;
        for (int i = 0; i < cases.length - 1; i++) {
            if (cases[i][i].GetX() != cases[i + 1][i + 1].GetX() || cases[i][i].GetX() == 0) {
                diagonaleGagne1 = false;
            }
            if (cases[i][cases.length - 1 - i].GetX() != cases[i + 1][cases.length - 2 - i].GetX() || cases[i][cases.length - 1 - i].GetX() == 0) {
                diagonaleGagne2 = false;
            }
        }
        if (diagonaleGagne1 || diagonaleGagne2) {
            return cases[cases.length / 2][cases.length / 2].GetX();
        }

        // Vérification si le plateau est plein
        boolean plateauPlein = true;
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases.length; j++) {
                if (cases[i][j].GetX() == 0) {
                    plateauPlein = false;
                    break;
                }
            }
        }
        if (plateauPlein) {
            return -1;
        }

        return 0;
    }
    
    @Override

 // ToString
 public String toString() {
    String tab = "";
    String purpleColor = "\u001B[35m"; 
    String resetColor = "\u001B[0m"; 

    for (int i = 0; i < cases.length; i++) {
        for (int j = 0; j < cases.length; j++) {
            tab += purpleColor + cases[i][j] + resetColor;   
        }
        tab += "\n";
    }
    return tab;
}

}
    