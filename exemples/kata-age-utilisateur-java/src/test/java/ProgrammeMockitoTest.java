import es.EntreeStandard;
import es.SortieStandard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import outils.Temps;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProgrammeMockitoTest {

    @Before
    public void before() throws Exception {
        when(temps.maintenant()).thenReturn(LocalDate.of(2012, 1, 2));
    }

    @Test
    public void le_programme_demande_la_date_de_naissance_et_affiche_l_age() {
        when(entrée.lis()).thenReturn("01/01/2010");

        programme.exécuteToi();

        verify(sortie).affiche("Vous avez 2 ans");
    }

    @Mock
    private SortieStandard sortie;

    @Mock
    private EntreeStandard entrée;

    @Mock
    private Temps temps;

    @InjectMocks
    private Programme programme;
}
