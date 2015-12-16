import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GrilleTest {

    @Before
    public void before() throws Exception {
        grille = new Grille();
    }

    @Test
    public void une_grille_vide_ne_contient_que_des_cellules_mortes() {
        Set<Position> cellules = Sets.newHashSet();

        Set<Position> suivantes = grille.suivantes(cellules);

        assertThat(suivantes).hasSize(0);
    }

    @Test
    public void une_grille_peut_rester_en_vie() {
        Set<Position> cellules = Sets.newHashSet();
        cellules.add(new Position(0, 0));
        cellules.add(new Position(0, 1));
        cellules.add(new Position(1, 0));
        cellules.add(new Position(1, 1));

        Set<Position> suivantes = grille.suivantes(cellules);

        assertThat(suivantes).hasSize(4);
        assertThat(suivantes.contains(new Position(0, 0))).isTrue();
        assertThat(suivantes.contains(new Position(0, 1))).isTrue();
        assertThat(suivantes.contains(new Position(1, 0))).isTrue();
        assertThat(suivantes.contains(new Position(1, 1))).isTrue();
    }

    @Test
    public void une_grille_peut_mourir() {
        Set<Position> cellules = Sets.newHashSet();
        cellules.add(new Position(0, 0));

        Set<Position> suivantes = grille.suivantes(cellules);

        assertThat(suivantes).hasSize(0);
    }

    @Test
    public void une_grille_peut_evoluer() {
        Set<Position> cellules = Sets.newHashSet();
        cellules.add(new Position(0, 0));
        cellules.add(new Position(1, 0));
        cellules.add(new Position(2, 0));

        Set<Position> suivantes = grille.suivantes(cellules);

        assertThat(suivantes).hasSize(3);
        assertThat(suivantes.contains(new Position(1, 1))).isTrue();
        assertThat(suivantes.contains(new Position(1, 0))).isTrue();
        assertThat(suivantes.contains(new Position(1, -1))).isTrue();
        assertThat(suivantes.contains(new Position(0, 0))).isFalse();
        assertThat(suivantes.contains(new Position(2, 0))).isFalse();
    }

    private Grille grille;
}
