import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ProgrammeLegacy {
    public static void main(String[] args) {
        System.out.println("Date de naissance (ex 15/01/1983) ?");
        String naissanceSaisie = new Scanner(System.in, "UTF-8").nextLine();
        LocalDate dateNaissance = LocalDate.parse(
                naissanceSaisie,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long age = dateNaissance.until(LocalDate.now(), ChronoUnit.YEARS);
        System.out.println(String.format("Vous avez %s ans", age));
    }
}
