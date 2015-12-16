using System.Collections.Generic;

namespace KataBowling
{
    public class Partie
    {
        private readonly IList<int> _lancers = new List<int>();

        public void NouveauLancer(int quilles)
        {
            _lancers.Add(quilles);
        }

        public int CalculeScore()
        {
            var score = 0;
            var indiceLancer = 0;
            for (var i = 0; i < 10; i++)
            {
                if (EstStrike(indiceLancer))
                {
                    score += 10 + BonusStrike(indiceLancer);
                    indiceLancer++;
                }
                else if (EstSpare(indiceLancer))
                {
                    score += 10 + BonusSpare(indiceLancer);
                    indiceLancer += 2;
                }
                else
                {
                    score += _lancers[indiceLancer] + _lancers[indiceLancer + 1];
                    indiceLancer += 2;
                }
            }
            return score;
        }

        private bool EstStrike(int indiceLancer)
        {
            return _lancers[indiceLancer] == 10;
        }

        private int BonusStrike(int indiceLancer)
        {
            return _lancers[indiceLancer + 1] + _lancers[indiceLancer + 2];
        }

        private bool EstSpare(int indiceLancer)
        {
            return _lancers[indiceLancer] + _lancers[indiceLancer + 1] == 10;
        }

        private int BonusSpare(int indiceLancer)
        {
            return _lancers[indiceLancer + 2];
        }
    }
}