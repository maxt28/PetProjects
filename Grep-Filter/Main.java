package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<String> filterWords = new ArrayList<>();
    String inputString;
    boolean containsWord;

    public static void main(String[] args) {
        Main m = new Main();
        m.readInputFilter(args);
        while (true) {
            m.inputString = m.readInput();
            if (m.inputString.toLowerCase().equals("exit")) {
                break;
            }
            m.containsWord = m.filter(m.inputString.toLowerCase());
            m.output(m.containsWord);
        }
    }

    private void readInputFilter(String[] filters) {
        for (String filter : filters) {
            filterWords.add(filter.toLowerCase());
        }
        System.out.println("Filter words are: " + filterWords);
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private boolean filter(String s) {
        int counter = 0;
        for (String filterWord : filterWords) {
            if (s.contains(filterWord))
                counter++;
        }
        if (counter == filterWords.size()) {
            return true;
        } else {
            return false;
        }
    }

    private void output(boolean containsWord) {
        if (containsWord) {
            System.out.println(inputString);
        } else {
            System.out.println("String does not contain keywords.");
        }
    }
}
