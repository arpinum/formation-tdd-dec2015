import java.util.List;

import com.google.common.collect.Lists;

public class FacteursPremiers {

    public List<Integer> pour(int nombre) {
        List<Integer> facteurs = Lists.newArrayList();

        // i >= 0 pour éviter les soucis si nombre == Integer.MAX_VALUE
        for (int i = 2; i >= 0 && i <= nombre; i++) {
            while (nombre % i == 0) {
                facteurs.add(i);
                nombre /= i;
            }
        }

        return facteurs;
    }
}
