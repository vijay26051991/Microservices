package com.cloing.immutability;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

final class Foo {
    private final String name;
    private final Map<String, String> valueMap;


    public Foo(String name, Map<String, String> valueMap) {
        this.name = name;
        this.valueMap = valueMap;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getValueMap() {
        Map<String, String> cloneHashMap = new HashMap<>();
        Map<String, String> results = valueMap.entrySet().stream()
                .collect(Collectors.toMap(stringStringEntry -> stringStringEntry.getKey(), stringStringEntry -> stringStringEntry.getValue()));
        return results;
    }
}
