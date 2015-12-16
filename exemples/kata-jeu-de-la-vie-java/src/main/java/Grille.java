import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grille {

    public Set<Position> suivantes(Set<Position> cellulesVivantes) {
        return Sets.union(
                cellulesToujoursEnVie(cellulesVivantes),
                cellulesNaissantes(cellulesVivantes)
        );
    }

    private Set<Position> cellulesToujoursEnVie(Set<Position> cellulesVivantes) {
        return cellulesVivantes
                .stream()
                .filter(p -> Sets.newHashSet(2, 3).contains(nombreVoisinesVivantes(p, cellulesVivantes)))
                .collect(Collectors.toSet());
    }

    private Set<Position> cellulesNaissantes(Set<Position> cellulesVivantes) {
        return cellulesMortes(cellulesVivantes)
                .stream()
                .filter(p -> nombreVoisinesVivantes(p, cellulesVivantes) == 3)
                .collect(Collectors.toSet());
    }


    private int nombreVoisinesVivantes(Position position, Set<Position> cellulesVivantes) {
        return Sets.intersection(positionsVoisinesThéoriques(position), cellulesVivantes).size();
    }

    private Set<Position> cellulesMortes(Set<Position> cellulesVivantes) {
        return Sets.difference(cellulesVivantesEtVoisines(cellulesVivantes), cellulesVivantes);
    }

    private Set<Position> cellulesVivantesEtVoisines(Set<Position> cellulesVivantes) {
        return cellulesVivantes.stream()
                .map(p -> positionsVoisinesThéoriques(p))
                .flatMap(l -> l.stream())
                .collect(Collectors.toSet());
    }

    private Set<Position> positionsVoisinesThéoriques(Position position) {
        Set<Position> positions = Sets.newHashSet();
        for (int i = position.x() - 1; i <= position.x() + 1; i++) {
            for (int j = position.y() - 1; j <= position.y() + 1; j++) {
                positions.add(new Position(i, j));
            }
        }
        positions.remove(position);
        return positions;
    }
}
