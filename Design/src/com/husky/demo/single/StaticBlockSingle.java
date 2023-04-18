package com.husky.demo.single;

public class StaticBlockSingle {

    private static StaticBlockSingle single;

    private StaticBlockSingle() {

    }

    static {
        single = new StaticBlockSingle();
    }

    public static StaticBlockSingle getInstance() {
        return single;
    }

    public static void main(String[] args) {
        StaticBlockSingle single1 = getInstance();
        StaticBlockSingle single2 = getInstance();
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);

    }
}
