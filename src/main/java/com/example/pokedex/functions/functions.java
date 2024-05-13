package com.example.pokedex.functions;

import java.util.ArrayList;
import java.util.List;

public class functions
{
    public List<String> parseStringToList(String str) {
        List<String> list = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            String[] items = str.split(",");
            for (String item : items) {
                list.add(item.trim());
            }
        }
        return list;
    }
}
