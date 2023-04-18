package com.husky.demo.single;

public class StaticVariableSingle {

    private static StaticVariableSingle single = new StaticVariableSingle();

    private StaticVariableSingle() {

    }

    public static StaticVariableSingle getInstance() {
        return single;
    }

    public static void main(String[] args) {
        StaticVariableSingle single1 = getInstance();
        StaticVariableSingle single2 = getInstance();
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);
    }

}
