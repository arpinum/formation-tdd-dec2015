public class Lancer {

    public Lancer(int[] quilles) {
        this.quilles = quilles;
    }

    public int calculeLePointage() {
        return uneSeuleQuilleTombée() ? valeurQuilleTombée() : nombreDeQuillesTombées();
    }

    private int nombreDeQuillesTombées() {
        return quilles.length;
    }

    private int valeurQuilleTombée() {
        return quilles[0];
    }

    private boolean uneSeuleQuilleTombée() {
        return nombreDeQuillesTombées() == 1;
    }

    private int[] quilles;
}
