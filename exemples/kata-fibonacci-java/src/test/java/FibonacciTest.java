import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    @Before
    public void before() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void fibo_de_0_donne_0() {
        assertThat(fibonacci.pour(0)).isEqualTo(0);
    }

    @Test
    public void fibo_de_1_donne_1() {
        assertThat(fibonacci.pour(1)).isEqualTo(1);
    }

    @Test
    public void peut_calculer_les_résultats_généraux() {
        assertThat(fibonacci.pour(2)).isEqualTo(1);
        assertThat(fibonacci.pour(3)).isEqualTo(2);
        assertThat(fibonacci.pour(4)).isEqualTo(3);
        assertThat(fibonacci.pour(8)).isEqualTo(21);
    }

    @Test
    public void il_est_possible_de_connaitre_le_résultat_pour_un_grand_nombre() {
        assertThat(fibonacci.pour(1337)).isGreaterThan(0);
    }

    private Fibonacci fibonacci;
}
