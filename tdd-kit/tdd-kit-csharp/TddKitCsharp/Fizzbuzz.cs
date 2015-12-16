using System;
using System.Collections.Generic;

namespace TddKitCsharp
{
    public class Fizzbuzz
    {
        public IList<string> Elements()
        {
            IList<string> elements = new List<string>();
            for (var i = 1; i <= 100; i++)
            {
                elements.Add(ValueOf(i));
            }
            return elements;
        }

        private static string ValueOf(int number)
        {
            if (number%15 == 0)
            {
                return "fizzbuzz";
            }
            if (number%3 == 0)
            {
                return "fizz";
            }
            if (number%5 == 0)
            {
                return "buzz";
            }
            return Convert.ToString(number);
        }
    }
}