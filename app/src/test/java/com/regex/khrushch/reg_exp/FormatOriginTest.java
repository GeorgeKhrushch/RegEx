package com.regex.khrushch.reg_exp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormatOriginTest {

    private static final String ORIGIN_ONE = "with     its powerful tools and dazzling effects,Keynote " +
            "makes it Easy to create stunning and memorable presentations.tail";

    private static final String ORIGIN_TWO = "See Who you ’re  working with ... While you’re editing," +
            " a separate list lets you quickly see who else is in the presentation.";

    @Test
    public void capitalizeFirstCharOfSentence() throws Exception {
        String res = FormatOrigin.capitalFirstCharOfSentence(ORIGIN_ONE);
        System.out.println(res);
        assertTrue(res.length() == ORIGIN_ONE.length());
        assertTrue(res.charAt(0) == 'W');
    }

    @Test
    public void removeRedundantSpaces() throws Exception {
        String res = FormatOrigin.removeRedundantSpaces(ORIGIN_TWO);
        System.out.println(res);
        assertEquals(res.length(), ORIGIN_TWO.length()-3);
    }

    @Test
    public void pasteRequiredSpaces() throws Exception {
        String res = FormatOrigin.pasteRequiredSpaces(ORIGIN_ONE);
        System.out.println(res);
        assertEquals(res.length(), ORIGIN_ONE.length()+2);
    }

    @Test
    public void lowerCaseFirstCharInsideSentence() throws Exception {
        String res = FormatOrigin.removeRedundantSpaces(ORIGIN_ONE);
        res = FormatOrigin.pasteRequiredSpaces(res);
        res = FormatOrigin.lowerCaseFirstCharInsideSentence(res);
        System.out.println(res);
        assertTrue(res.contains("keynote"));
    }

    @Test
    public void fullRegExpTest() throws Exception {
        String res = FormatOrigin.performRegExp(ORIGIN_ONE);
        System.out.println("FINAL ORIGIN ONE: " + res);
        res = FormatOrigin.performRegExp(ORIGIN_TWO);
        System.out.println("FINAL ORIGIN TWO: " + res);
    }
}