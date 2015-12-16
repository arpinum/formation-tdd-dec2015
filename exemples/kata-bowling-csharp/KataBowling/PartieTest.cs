using NUnit.Framework;

namespace KataBowling
{
    [TestFixture]
    public class PartieTest
    {
        private Partie _partie;

        [SetUp]
        public void SetUp()
        {
            _partie = new Partie();
        }

        [Test]
        public void Le_score_dune_partie_gouttière_est_0()
        {
            NouveauxLancers(20, 0);

            var score = _partie.CalculeScore();

            Assert.That(score, Is.EqualTo(0));
        }

        [Test]
        public void Le_score_dune_partie_modeste_est_modeste()
        {
            NouveauxLancers(20, 1);

            var score = _partie.CalculeScore();

            Assert.That(score, Is.EqualTo(20));
        }

        [Test]
        public void Le_score_prend_en_compte_le_bonus_dun_spare()
        {
            NouveauxLancers(1, 9);
            NouveauxLancers(1, 1);
            NouveauxLancers(1, 1);
            NouveauxLancers(17, 0);

            var score = _partie.CalculeScore();

            Assert.That(score, Is.EqualTo(12));
        }

        [Test]
        public void Le_score_prend_en_compte_le_bonus_dun_strike()
        {
            NouveauxLancers(1, 10);
            NouveauxLancers(1, 1);
            NouveauxLancers(1, 2);
            NouveauxLancers(16, 0);

            var score = _partie.CalculeScore();

            Assert.That(score, Is.EqualTo(16));
        }

        private void NouveauxLancers(int lancers, int quilles)
        {
            for (var i = 0; i < lancers; i++)
            {
                _partie.NouveauLancer(quilles);
            }
        }
    }
}