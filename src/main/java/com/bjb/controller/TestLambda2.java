package com.bjb.controller;

public class TestLambda2 {

    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String message) {
                System.out.println("我是匿名内部类" + message);
            }
        });
        useStringHandler((String msg) -> {
            System.out.println("=======================>" + msg);
        });
    }

    public static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage("lambda输出");
    }

}

interface StringHandler {
    void printMessage(String message);
}
