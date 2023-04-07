package JavaMorpion;
class Case {
    // Déclaration des attributs
    private int joueur;

    // Constructeur par défaut
    public Case() {
        joueur = 0;
    }

    // Constructeur par copie.
    public Case(Case j) {
        joueur = j.joueur;
    }

    // Constructeur
    public Case(int j) {
        if (j != 0 && j != 1 && j != 2) {
            System.out.println("Erreur ! Vous allez quitter la partie.");
            System.exit(0);
        } else {
            joueur = j;
        }
    }

    // Getter
    public int GetX() {
        return joueur;
    }

    // Setter
    public void SetX(int j) {
        if (j != 0 && j != 1 && j != 2) {
            System.out.println("Erreur ! Vous allez quitter la partie.");
            System.exit(0);
        } else {
            joueur = j;
        }
    }

    // Equals
    public boolean equals(int j) {
        if (j != joueur) {
            return false;
        } else {
            return true;
        }
    }

    // ToString
    public String toString() {
        String retour = "";
        if (joueur == 0) {
            retour = "|   |";
        } else if (joueur == 1) {
            retour = "| X |";
        } else if (joueur == 2) {
            retour = "| O |";
        }
        return retour;
    }
}
