public class Partie {
    public void metsAJourLePointageAvecLeLancer(int... quilles) {
        pointage += new Lancer(quilles).calculeLePointage();
        siLePointageDepasse50IlRedescendA25();
    }

    private void siLePointageDepasse50IlRedescendA25() {
        if (pointage > 50) {
            pointage = 25;
        }
    }

    public int pointage() {
        return pointage;
    }

    public boolean gagnée() {
        return pointage == 50;
    }

    private int pointage;
}
