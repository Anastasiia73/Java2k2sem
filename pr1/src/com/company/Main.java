package com.company;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Integer[]> consumer = array-> Arrays.sort(array);
        Integer[] array = {7, 4, 9, 12, 0};
        consumer.accept(array);
        System.out.println(Arrays.toString(array));
    }
}