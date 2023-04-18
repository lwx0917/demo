package com.husky.demo.single;

public class StaticInnerSingle {

    public static volatile StaticInnerSingle single;

    private StaticInnerSingle() {

    }

    public static class innerSingle {
        private static final StaticInnerSingle single = new StaticInnerSingle();
    }

    public static StaticInnerSingle getInstance() {
        return innerSingle.single;
    }

    public static void main(String[] args) {
        StaticInnerSingle single1 = getInstance();
        StaticInnerSingle single2 = getInstance();
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);
    }
}
