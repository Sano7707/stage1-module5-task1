package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {


    public Predicate<List<String>> isValuesStartWithUpperCase() {
       return x -> {
           for (String s : x) {
               if ((int) (s.charAt(0)) < 65 || (int) (s.charAt(0)) > 90) {
                   return false;
               }
           }
           return true;
       };
    };


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x ->{
            List<Integer> l = new ArrayList<>();
            for (Integer integer : x) {
                if (integer % 2 == 0)
                    l.add(integer);
            }
            x.addAll(l);
        };
    }


    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> l = new ArrayList<>();
            for (String value : values) {
                if ((int) value.charAt(0) > 65 && (int) value.charAt(0) < 90 &&
                        value.charAt(value.length() - 1) == '.' &&
                        value.split(" ").length > 3) {
                    l.add(value);
                }
            }
            return l;
        }

        ;}



    public Function<List<String>, Map<String, Integer>> stringSize(){
        return x -> {

            Map<String,Integer> mp = new HashMap<>();
            for (int i = 0; i < x.size(); i++) {
                mp.put(x.get(i),x.get(i).length());
            }

        return mp;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {

            List<Integer> l = new ArrayList<>(list1);
            l.addAll(list2);
        return l;
        };
    }


}
