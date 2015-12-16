import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FacteursPremiersTest {

    @Test
    public void pas_de_facteur_premier_pour_1() {
        List<Integer> facteurs = new FacteursPremiers().pour(1);

        assertThat(facteurs).isEmpty();
    }

    @Test
    public void un_nombre_premier_est_son_seul_facteur_premier() {
        assertThat(new FacteursPremiers().pour(2)).containsOnly(2);
        assertThat(new FacteursPremiers().pour(3)).containsOnly(3);
    }

    @Test
    public void il_est_possible_d_obtenir_les_facteurs_premiers_d_un_nombre_non_premier() {
        assertThat(new FacteursPremiers().pour(4)).containsOnly(2, 2);
        assertThat(new FacteursPremiers().pour(9)).containsOnly(3, 3);
        assertThat(new FacteursPremiers().pour(100)).containsOnly(2, 2, 5, 5);
        assertThat(new FacteursPremiers().pour(1010021)).containsOnly(17, 19, 53, 59);
    }

    @Test
    @Ignore
    public void gère_un_nombre_très_grand() {
        assertThat(new FacteursPremiers().pour(Integer.MAX_VALUE)).isNotEmpty();
    }
}
