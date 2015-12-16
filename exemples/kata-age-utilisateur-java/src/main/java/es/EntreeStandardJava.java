package es;

import java.util.Scanner;

public class EntreeStandardJava implements EntreeStandard {
    @Override
    public String lis() {
        return new Scanner(System.in, "UTF-8").nextLine();
    }
}
