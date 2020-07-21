package com.grootan.quiz.util;

import java.util.*;

public class Util {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static <T> List<T> pickRandomElements(List<T> list, int size) {
        Random random = new Random();
        Set<T> randomSet = new HashSet<>();
        while(randomSet.size() <= size) {
            int randomIndex = random.nextInt(list.size());
            randomSet.add(list.get(randomIndex));
        }
        return (List<T>) Arrays.asList(randomSet.toArray());
    }
}