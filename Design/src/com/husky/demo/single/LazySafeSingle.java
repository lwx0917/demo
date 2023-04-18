package com.husky.demo.single;

public class LazySafeSingle {

    private static LazySafeSingle single;

    private LazySafeSingle() {

    }

    public synchronized static LazySafeSingle getInstance() {
        if (single == null) {
            single = new LazySafeSingle();
            return single;
        }
        return single;
    }

}
