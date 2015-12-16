#include "gtest/gtest.h"

#include "fizzbuzz.h"

TEST(fizzbuzz, shouldReturn1For1) {
	string actual = fizzbuzz(1);

    ASSERT_EQ("1", actual);
}

TEST(fizzbuzz, shouldReturnFizzFor3) {
	string actual = fizzbuzz(3);

    ASSERT_EQ("Fizz", actual);
}

TEST(fizzbuzz, shouldReturnBuzzFor5) {
	string actual = fizzbuzz(5);

    ASSERT_EQ("Buzz", actual);
}

TEST(fizzbuzz, shouldReturnFizzbuzzFor15) {
	string actual = fizzbuzz(15);

    ASSERT_EQ("FizzBuzz", actual);
}

