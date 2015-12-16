import com.google.common.collect.Lists;

import java.util.List;

public class Fizzbuzz {
    public List<String> elements() {
        List<String> elements = Lists.newArrayList();
        for (int i = 1; i <= 100; i++) {
            elements.add(valueOf(i));
        }
        return elements;
    }

    private String valueOf(int number) {
        if (number % 15 == 0) {
            return "fizzbuzz";
        }
        if (number % 3 == 0) {
            return "fizz";
        }
        if (number % 5 == 0) {
            return "buzz";
        }
        return String.valueOf(number);
    }
}
