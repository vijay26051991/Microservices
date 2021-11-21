package com.cloing.immutability;

import java.util.HashMap;
import java.util.Map;

public class ImmutableSample {
    public static void main(String[] args) {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("age", "30");
        Foo foo = new Foo("Vijay", valueMap);
        foo.getValueMap().put("sex", "male");

        System.out.println(foo.getValueMap());
        foo.getValueMap().put("sex", "male");
        System.out.println(foo.getValueMap());
    }

}


