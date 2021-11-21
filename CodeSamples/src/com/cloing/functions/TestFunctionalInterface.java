package com.cloing.functions;

import java.util.ArrayList;
import java.util.List;

public class TestFunctionalInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Vijay");
        list.add("Vimal");
        list.add("Vishwa");
        list.add("Vignesh");
        list.stream()
                .peek(s -> System.out.println(s.toString()));
    }
}
