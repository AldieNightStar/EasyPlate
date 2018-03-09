package com.fox.TestEasyPlate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.fox.EasyPlate.*;
import static org.junit.Assert.*;

public class TestEasyPlate {
    Map<String, String> model;

    @Before
    public void beforeTest(){
        model = new HashMap<String, String>();
        model.put("name", "Ihor-fox");
        model.put("date", "08.05.1998");
        model.put("ver", "8");
    }

    @Test
    public void renderTesting(){
        String someString = "My name is $[[name]], i born at $[[date]] and my version of java is $[[ver]]";
        String result = render(someString, model);
        String expected = "My name is Ihor-fox, i born at 08.05.1998 and my version of java is 8";

        assertEquals(expected, result);
    }
}
