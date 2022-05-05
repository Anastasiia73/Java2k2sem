package com.company;

public class Main {
    public static void main(String[] args){
        MyMap map = new MyMap();
        map.put(2, 3);
        map.put(3, 4);
        System.out.println(map.get(2));
        System.out.println(map.size());

        MySet set = new MySet();
        set.add("3");
        set.add("4");
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
