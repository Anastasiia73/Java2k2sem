package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Human> vector = new ArrayList<>();
        vector.add(new Human(32, "Vasya", "Pupkin", LocalDate.of(1992, 12,1), 324));
        vector.add(new Human(24, "Petya", "Zolotov", LocalDate.of(1998, 5,6), 65));
        vector.add(new Human(15, "Vlad", "Losev", LocalDate.of(2007, 7,23), 23));


        vector.stream()
                .forEach(s -> s.setWeight(s.getWeight()+3));

        vector.stream().forEach(System.out::println);

        System.out.println();

        vector.stream()
                .sorted(Comparator
                        .comparing(Human::getWeight)
                        .reversed())
                .forEach(System.out::println);


        System.out.println();

        vector.stream()
                .filter(s -> s.getBirthDate().isBefore(LocalDate.of(2000, 1, 1)))
                .forEach(System.out::println);

        System.out.println();

        System.out.println(vector.stream()
                .mapToInt(Human::getWeight)
                .sum());



    }
}
