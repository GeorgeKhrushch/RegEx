package com.regex.khrushch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegExpTest {

    @Test
    public void groupTest() throws Exception {
        String origin = "as d as d as";
        String modified = origin.replaceAll("(a)s", "$1");
        System.out.println(modified);
        assertTrue(modified.length() == origin.length() - 3);
    }
}
