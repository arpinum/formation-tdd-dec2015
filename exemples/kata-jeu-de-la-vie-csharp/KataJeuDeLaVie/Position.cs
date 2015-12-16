using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KataJeuDeLaVie
{
    public class Position : Tuple<int, int>
    {
        public Position(int x, int y) : base(x, y)
        {
        }

        public int X => Item1;
        public int Y => Item2;
    }
}
