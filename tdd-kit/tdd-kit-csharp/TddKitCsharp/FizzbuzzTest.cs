using System.Collections.Generic;
using NUnit.Framework;

namespace TddKitCsharp
{
    [TestFixture]
    public class FizzbuzzTest
    {
        private IList<string> _elements;

        [SetUp]
        public void SetUp()
        {
            _elements = new Fizzbuzz().Elements();
        }

        [Test]
        public void should_return_100_elements()
        {
            Assert.That(_elements.Count, Is.EqualTo(100));
        }

        [Test]
        public void should_return_1_for_1()
        {
            Assert.That(FizzBuzzOf(1), Is.EqualTo("1"));
        }

        [Test]
        public void should_return_fizz_for_3()
        {
            Assert.That(FizzBuzzOf(3), Is.EqualTo("fizz"));
        }

        [Test]
        public void should_return_buzz_for_5()
        {
            Assert.That(FizzBuzzOf(5), Is.EqualTo("buzz"));
        }

        [Test]
        public void should_return_fizzbuzz_for_15()
        {
            Assert.That(FizzBuzzOf(15), Is.EqualTo("fizzbuzz"));
        }

        private string FizzBuzzOf(int number)
        {
            return _elements[number - 1];
        }
    }
}