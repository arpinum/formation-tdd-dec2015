using System.Collections.Generic;
using System.Linq;

namespace KataJeuDeLaVie
{
    public class Grille
    {
        public IList<Position> Suivantes(IList<Position> cellulesVivantes)
        {
            return CellulesToujoursEnVie(cellulesVivantes)
                .Union(CellulesNaissantes(cellulesVivantes))
                .ToList();
        }

        private static IList<Position> CellulesToujoursEnVie(IList<Position> cellulesVivantes)
        {
            return cellulesVivantes
                .Where(p => new List<int> {2, 3}.Contains(NombreVoisinesVivantes(p, cellulesVivantes)))
                .ToList();
        }

        private static IList<Position> CellulesNaissantes(IList<Position> cellulesVivantes)
        {
            return CellulesMortes(cellulesVivantes)
                .Where(p => NombreVoisinesVivantes(p, cellulesVivantes) == 3)
                .ToList();
        }

        private static int NombreVoisinesVivantes(Position position, IList<Position> cellulesVivantes)
        {
            return PositionsVoisinesThéoriques(position)
                .Intersect(cellulesVivantes)
                .Count();
        }

        private static IList<Position> CellulesMortes(IList<Position> cellulesVivantes)
        {
            return CellulesVivantesEtVoisines(cellulesVivantes)
                .Except(cellulesVivantes)
                .ToList();
        }

        private static IList<Position> CellulesVivantesEtVoisines(IList<Position> cellulesVivantes)
        {
            return cellulesVivantes
                .SelectMany(PositionsVoisinesThéoriques)
                .Distinct()
                .ToList();
        }

        private static IList<Position> PositionsVoisinesThéoriques(Position position)
        {
            var positions = new List<Position>();
            for (var i = position.X - 1; i <= position.X + 1; i++)
            {
                for (var j = position.Y - 1; j <= position.Y + 1; j++)
                {
                    positions.Add(new Position(i, j));
                }
            }
            positions.Remove(position);
            return positions;
        }
    }
}