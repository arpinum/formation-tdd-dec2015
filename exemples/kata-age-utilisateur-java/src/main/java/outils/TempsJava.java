package outils;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class TempsJava implements Temps {
    @Override
    public Temporal maintenant() {
        return LocalDate.now();
    }
}
