package com.husky.demo.single;

public class DoubleCheckSingle {

    private static DoubleCheckSingle single;

    private DoubleCheckSingle() {

    }

    public static DoubleCheckSingle getInstance() {
        if (single == null) {
            synchronized (DoubleCheckSingle.class) {
                if (single == null) {
                    single = new DoubleCheckSingle();
                    return single;
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        DoubleCheckSingle single1 = getInstance();
        DoubleCheckSingle single2 = getInstance();
        System.out.println(single1 == single2);
        System.out.println("hash address:" + single1);
        System.out.println("hash address:" + single2);
    }
}
