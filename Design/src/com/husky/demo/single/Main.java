package com.husky.demo.single;

public class Main {
    public static void main(String[] args) {
        SingleType single1 = SingleType.INSTANCE;
        SingleType single2 = SingleType.INSTANCE;
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);
    }
}
