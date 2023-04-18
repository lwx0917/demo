package com.husky.demo.single;

public class LazySingle {

    private static LazySingle single;

    private LazySingle() {

    }

    public static LazySingle getInstance() {
        if (single == null) {
            single = new LazySingle();
            return single;
        }
        return single;
    }

    public static void main(String[] args) {
        LazySingle single1 = getInstance();
        LazySingle single2 = getInstance();
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);
    }
}
