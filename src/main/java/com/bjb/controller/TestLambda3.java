package com.bjb.controller;

public class TestLambda3 {
    public static void main(String[] args) {
        int a = useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                return (int)Math.floor(Math.random()*100);
            }
        });
        System.out.println("a===================>" + a);

        int b = useRandomNumHandler(() -> {return (int)Math.floor(Math.random()*100);});
        System.out.println("b=======================>" + b);

        int c = useRandomNumHandler2(new RandomNumHandler2() {
            @Override
            public int getNumber(int m, int n) {
                return m + n;
            }
        });
        System.out.println("c =========================>" + c);

        int d = useRandomNumHandler2(( m,  n) -> m * n );
        System.out.println("d ==============>" + d);
    }

    public static int useRandomNumHandler(RandomNumHandler randomNumHandler) {
        return randomNumHandler.getNumber();
    }

    public static int useRandomNumHandler2(RandomNumHandler2 randomNumHandler2) {
        return randomNumHandler2.getNumber(3, 2);
    }
}

interface RandomNumHandler {
    int getNumber();
}

interface RandomNumHandler2 {
    int getNumber(int m, int n);
}