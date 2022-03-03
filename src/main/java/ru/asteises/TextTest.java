package ru.asteises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TextTest {
    private final String path = "C:\\Users\\User\\IdeaProjects\\PracticsTest\\src\\main\\resources\\text.txt";

    public void count() throws IOException {
        FileReader fileReader = new FileReader(path);
        int i = -1;
        StringBuffer sb = new StringBuffer();
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }
        String string = sb.toString();
        String[] strings = string.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (i = 1; i < strings.length; i++) {
            if (map.get(strings[i]) == null) {
                map.put(strings[i], 1);
            } else {
                map.replace(strings[i], map.get(strings[i]) + 1);
            }
        }
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(x -> System.out.println(x));
    }
}
