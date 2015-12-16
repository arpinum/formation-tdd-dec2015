import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PartieTest {

    @Before
    public void before() {
        partie = new Partie();
    }

    @Test
    public void la_partie_commence_a_0_0() {
        String score = partie.score();

        assertThat(score).isEqualTo("0 - 0");
    }

    @Test
    public void le_joueur_1_peut_marquer_un_point() {
        leJoueur1Marque(1);

        String score = partie.score();

        assertThat(score).isEqualTo("15 - 0");
    }

    @Test
    public void le_joueur_1_peut_marquer_deux_points() {
        leJoueur1Marque(2);

        String score = partie.score();

        assertThat(score).isEqualTo("30 - 0");
    }

    @Test
    public void le_joueur_1_peut_marquer_3_points() {
        leJoueur1Marque(3);

        String score = partie.score();

        assertThat(score).isEqualTo("40 - 0");
    }

    @Test
    public void le_joueur_1_peut_gagner_la_partie() {
        leJoueur1Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 1 vainqueur");
    }

    @Test
    public void le_joueur_2_peut_marquer_un_point() {
        leJoueur2Marque(1);

        String score = partie.score();

        assertThat(score).isEqualTo("0 - 15");
    }

    @Test
    public void le_joueur_2_peut_gagner_la_partie() {
        leJoueur2Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 2 vainqueur");
    }

    @Test
    public void le_joueur_1_peut_avoir_l_avantage() {
        leJoueur2Marque(3);
        leJoueur1Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Avantage Joueur 1");
    }

    @Test
    public void le_joueur_1_peut_gagner_après_avoir_eu_l_avantage() {
        leJoueur2Marque(3);
        leJoueur1Marque(5);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 1 vainqueur");
    }

    @Test
    public void le_joueur_2_peut_avoir_l_avantage() {
        leJoueur1Marque(3);
        leJoueur2Marque(4);

        String score = partie.score();

        assertThat(score).isEqualTo("Avantage Joueur 2");
    }

    @Test
    public void le_joueur_2_peut_gagner_après_avoir_eu_l_avantage() {
        leJoueur1Marque(3);
        leJoueur2Marque(5);

        String score = partie.score();

        assertThat(score).isEqualTo("Joueur 2 vainqueur");
    }

    @Test
    public void il_peut_y_avoir_une_égalité() {
        leJoueur1Marque(3);
        leJoueur2Marque(3);

        String score = partie.score();

        assertThat(score).isEqualTo("Egalité");
    }

    @Test
    public void si_les_joueurs_sont_a_30_partout_le_score_n_est_pas_egalité() {
        leJoueur1Marque(2);
        leJoueur2Marque(2);

        String score = partie.score();

        assertThat(score).isEqualTo("30 - 30");
    }

    private void leJoueur1Marque(int nombreDeFois) {
        for (int i = 0; i < nombreDeFois; i++) {
            partie.leJoueur1Marque();
        }
    }

    private void leJoueur2Marque(int nombreDeFois) {
        for (int i = 0; i < nombreDeFois; i++) {
            partie.leJoueur2Marque();
        }
    }

    private Partie partie;
}
