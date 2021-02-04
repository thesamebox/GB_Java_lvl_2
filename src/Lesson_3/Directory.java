package Lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Directory {
    public Map<String, Set<String>> dictionary = new HashMap<>();

    public void add(String name, String phone) {
        Set<String> phoneNumber = dictionary.getOrDefault(name, new HashSet<>());
        phoneNumber.add(phone);
        dictionary.put(name, phoneNumber);
    }

    public Set<String> get(String name) {
        return dictionary.get(name);
    }

}
