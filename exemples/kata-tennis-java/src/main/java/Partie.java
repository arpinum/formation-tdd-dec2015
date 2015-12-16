public class Partie {

	public String score() {
		if (égalité()) {
			return "Egalité";
		}
		if (unJoueurAAuMoins4Points()) {
			return scoreAvecAvantageOuVainqueur();
		}
		return scoreEnChiffre();
	}

	private String scoreAvecAvantageOuVainqueur() {
		if (pointsJoueur1 >= pointsJoueur2 + 2) {
			return "Joueur 1 vainqueur";
		}
		if (pointsJoueur1 == pointsJoueur2 + 1) {
			return "Avantage Joueur 1";
		}
		if (pointsJoueur2 >= pointsJoueur1 + 2) {
			return "Joueur 2 vainqueur";
		}
		return "Avantage Joueur 2";
	}

	private boolean égalité() {
		return égalitéPossible() && pointsJoueur1 == pointsJoueur2;
	}

	private boolean égalitéPossible() {
		return pointsJoueur1 >= 3 || pointsJoueur2 >= 3;
	}

	private boolean unJoueurAAuMoins4Points() {
		return pointsJoueur1 >= 4 || pointsJoueur2 >= 4;
	}

	private String scoreEnChiffre() {
		return String.format("%s - %s", pointsEnScore(pointsJoueur1), pointsEnScore(pointsJoueur2));
	}

	private String pointsEnScore(int points) {
		return correspondancesPointsScore[points];
	}

	public void leJoueur1Marque() {
		pointsJoueur1++;
	}

	public void leJoueur2Marque() {
		pointsJoueur2++;
	}

	private static String[] correspondancesPointsScore = new String[]{"0", "15", "30", "40"};

	private int pointsJoueur1;
	private int pointsJoueur2;
}
