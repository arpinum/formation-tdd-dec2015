package mocks;

import outils.Temps;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class StubTemps implements Temps {
    public StubTemps(LocalDate maintenant) {
        this.maintenant = maintenant;
    }

    @Override
    public Temporal maintenant() {
        return maintenant;
    }

    private LocalDate maintenant;
}
