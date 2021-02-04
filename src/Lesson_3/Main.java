package Lesson_3;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] list = {"Каждый", "охотник", "желает", "знать", "сам",
                "где", "сидит", "фазан", "ты", "юра",
                "мал", "Каждый", "желает","сам","сидит", "ты"};

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);


        Directory directory = new Directory();

        directory.add("Каждолов", "12345452");
        directory.add("Охотников", "0987654321");
        directory.add("Желательнов", "99159159915");
        directory.add("Зналов", "99159159914");
        directory.add("Зналов", "515995195199");
        directory.add("Самин", "9152233487");
        directory.add("Самин", "9152233487");

        System.out.println(directory.get("Самин"));
        System.out.println(directory.get("Зналов"));
        System.out.println(directory.get("Желательнов"));
        System.out.println(directory.get("Охотников"));
        System.out.println(directory.get("Каждолов"));
    }
}
