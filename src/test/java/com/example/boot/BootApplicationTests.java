package com.example.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    public static Map<String,Object> map = new HashMap<>();

    static {
        map.put("a","a1");
    }
    @Test
    public void contextLoads() {

        map.keySet().stream()
                .map( e -> map.get(e))
                .sorted((a,b) ->  b.toString().compareTo(a.toString()))
                .distinct()
                .forEach(e -> System.out.println(e));
    }

}
