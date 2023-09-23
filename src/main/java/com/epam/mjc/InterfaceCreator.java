package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str: x) {
                if(str.length()!=0){
                    char letter=str.charAt(0);
                    if(Character.isLowerCase(letter) || Character.isDigit(letter)){
                        return false;
                    }
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x->{
            int size = x.size();
            for (int i=0;i<size;i++) {
                if(x.get(i) % 2 == 0) x.add(x.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            List<String> list = new ArrayList<>();
            for (String line:values) {
                if(Character.isUpperCase(line.charAt(0)) && line.endsWith(".") && line.split(" ").length>3)
                    list.add(line);
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String, Integer> map = new HashMap<>();
            for (String str: x) {
                map.put(str,str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y)->{
            List<Integer> list = new ArrayList<>();
            list.addAll(x);
            list.addAll(y);
            return list;
        };
    }
}
