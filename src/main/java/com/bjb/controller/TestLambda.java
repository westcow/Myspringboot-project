package com.bjb.controller;

public class TestLambda {
    public static void main(String[] args) {
        userShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("局部内部类输出");
            }
        });

        userShowHandler(() -> {
            System.out.println("lambda表达式输出");
        });

    }

    public static void userShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }

}
interface ShowHandler {
        void show();
    }
