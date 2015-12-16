import es.EntreeStandard;
import es.EntreeStandardJava;
import es.SortieStandard;
import es.SortieStandardJava;
import outils.Temps;
import outils.TempsJava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Programme {
    public static void main(String[] args) {
        Programme programme = new Programme(
                new EntreeStandardJava(),
                new SortieStandardJava(),
                new TempsJava());
        programme.exécuteToi();
    }

    public Programme(EntreeStandard entréeStandard,
                     SortieStandard sortieStandard,
                     Temps temps) {
        this.entréeStandard = entréeStandard;
        this.sortieStandard = sortieStandard;
        this.temps = temps;
    }

    public void exécuteToi() {
        sortieStandard.affiche("Date de naissance (ex 15/01/1983) ?");
        String naissanceSaisie = this.entréeStandard.lis();
        LocalDate dateNaissance = dateNaissance(naissanceSaisie);
        long age = calculeAge(dateNaissance);
        sortieStandard.affiche(String.format("Vous avez %s ans", age));
    }

    private static LocalDate dateNaissance(String naissanceSaisie) {
        return LocalDate.parse(naissanceSaisie, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private long calculeAge(LocalDate dateNaissance) {
        return dateNaissance.until(temps.maintenant(), ChronoUnit.YEARS);
    }

    private EntreeStandard entréeStandard;
    private SortieStandard sortieStandard;
    private Temps temps;
}
