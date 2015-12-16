require_relative './test_helper'
require_relative './fizzbuzz'

describe Fizzbuzz do
  before do
    @elements = Fizzbuzz.new.elements
  end

  it 'should return 100 elements' do
    @elements.length.must_equal 100
  end

  it 'should return "1" for 1' do
    fizzbuzz(1).must_equal '1'
  end

  it 'should return "fizz" for 3' do
    fizzbuzz(3).must_equal 'fizz'
  end

  it 'should return "buzz" for 5' do
    fizzbuzz(5).must_equal 'buzz'
  end

  it 'should return "fizzbuzz" for 15' do
    fizzbuzz(15).must_equal 'fizzbuzz'
  end

  private

  def fizzbuzz(number)
    @elements[number - 1]
  end
end
