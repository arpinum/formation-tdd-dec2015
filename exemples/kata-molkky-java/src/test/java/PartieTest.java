import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartieTest {

    @Before
    public void before() {
        partie = new Partie();
    }

    @Test
    public void si_un_joueur_fait_tomber_une_quille_il_marque_la_valeur_de_la_quille() {
        partie.metsAJourLePointageAvecLeLancer(3);

        assertThat(partie.pointage()).isEqualTo(3);
    }

    @Test
    public void si_un_joueur_fait_tomber_plusieurs_quilles_il_marque_le_nombre_de_quilles() {
        partie.metsAJourLePointageAvecLeLancer(1, 2);

        assertThat(partie.pointage()).isEqualTo(2);
    }

    @Test
    public void le_pointage_est_le_cumul_de_plusieurs_lancers() {
        partie.metsAJourLePointageAvecLeLancer(1);
        partie.metsAJourLePointageAvecLeLancer(1);

        assertThat(partie.pointage()).isEqualTo(2);
    }

    @Test
    public void si_un_joueur_atteint_50_points_il_a_gagné_la_partie() {
        partie.metsAJourLePointageAvecLeLancer(50);

        assertThat(partie.gagnée()).isTrue();
    }

    @Test
    public void si_un_joueur_a_moins_de_50_points_il_n_a_pas_gagné() {
        partie.metsAJourLePointageAvecLeLancer(1);

        assertThat(partie.gagnée()).isFalse();
    }

    @Test
    public void si_un_joueur_dépasse_50_points_il_redescend_a_25() {
        partie.metsAJourLePointageAvecLeLancer(51);

        assertThat(partie.pointage()).isEqualTo(25);
    }

    private Partie partie;
}
