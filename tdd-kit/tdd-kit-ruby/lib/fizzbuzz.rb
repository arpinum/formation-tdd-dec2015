class Fizzbuzz
  def elements
    (1..100).map(&method(:value_of))
  end

  def value_of(number)
    return 'fizzbuzz' if number % 15 == 0
    return 'fizz' if number % 3 == 0
    return 'buzz' if number % 5 == 0
    number.to_s
  end
end
