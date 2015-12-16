#include <stdio.h>

#include "fizzbuzz.h"

string fizzbuzz(const int number) {
	if (number % 15 == 0) {
		return "FizzBuzz";
	} else if (number % 3 == 0) {
		return "Fizz";
	} else if (number % 5 == 0) {
		return "Buzz";
	}
	return to_string(number);
}
