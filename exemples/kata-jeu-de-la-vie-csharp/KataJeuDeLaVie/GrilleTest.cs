using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;

namespace KataJeuDeLaVie
{
    [TestFixture]
    public class GrilleTest
    {
        private Grille _grille;

        [SetUp]
        public void SetUp()
        {
            _grille = new Grille();
        }

        [Test]
        public void Une_grille_vide_ne_contient_que_des_cellules_mortes()
        {
            var suivantes = _grille.Suivantes(new List<Position>());

            Assert.That(suivantes, Is.Empty);
        }

        [Test]
        public void Une_grille_peut_rester_en_vie()
        {
            var cellules = new List<Position>
            {
                new Position(0, 0),
                new Position(0, 1),
                new Position(1, 0),
                new Position(1, 1)
            };

            var suivantes = _grille.Suivantes(cellules);

            Assert.That(suivantes, Has.Count.EqualTo(4));
            Assert.That(suivantes, Has.Member(new Position(0, 0)));
            Assert.That(suivantes, Has.Member(new Position(0, 1)));
            Assert.That(suivantes, Has.Member(new Position(1, 0)));
            Assert.That(suivantes, Has.Member(new Position(1, 1)));
        }

        [Test]
        public void Une_grille_peut_mourir()
        {
            var cellules = new List<Position> {new Position(0, 0)};

            var suivantes = _grille.Suivantes(cellules);

            Assert.That(suivantes, Is.Empty);
        }

        [Test]
        public void Une_grille_peut_evoluer()
        {
            var cellules = new List<Position>
            {
                new Position(0, 0),
                new Position(1, 0),
                new Position(2, 0)
            };

            var suivantes = _grille.Suivantes(cellules);

            Assert.That(suivantes, Has.Count.EqualTo(3));
            Assert.That(suivantes, Has.Member(new Position(1, 1)));
            Assert.That(suivantes, Has.Member(new Position(1, 0)));
            Assert.That(suivantes, Has.Member(new Position(1, -1)));
        }
    }
}