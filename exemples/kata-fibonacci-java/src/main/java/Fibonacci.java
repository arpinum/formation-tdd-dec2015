public class Fibonacci {

    public int pour(int nombre) {
        return fibonacci(nombre, 0, 1);
    }

    private static int fibonacci(int nombre, int résultat, int résultatSuivant) {
        if (nombre == 0) {
            return résultat;
        }
        return fibonacci(nombre - 1, résultatSuivant, résultat + résultatSuivant);
    }
}
