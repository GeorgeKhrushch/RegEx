package com.regex.khrushch.reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormatOrigin {

    /* THE MAIN METHOD TO EDIT ORIGIN STRING*/
    public static String performRegExp(String origin){
        String res = pasteRequiredSpaces(origin);
        res = removeRedundantSpaces(res);
        res = capitalFirstCharOfSentence(res);
        return lowerCaseFirstCharInsideSentence(res);
    }

    static String pasteRequiredSpaces(String origin){
        String pattern = "(\\w+)([,(.+)?!])(\\w+)";
        return origin.replaceAll(pattern, "$1$2 $3");
    }

    static String removeRedundantSpaces(String origin){
        String pattern = "(\\w+)\\s+([.,'?!;:’])";
        String res = origin.replaceAll(pattern, "$1$2");
        return removeMultipleSpaces(res);
    }

    private static String removeMultipleSpaces(String origin){
        String pattern = "(\\w+)\\s+(\\w+)";
        return origin.replaceAll(pattern, "$1 $2");
    }

    static String capitalFirstCharOfSentence(String origin){
        String pattern = "^[a-z]|[.!?]\\s[a-z]";
        return charCaseAction(Character::toUpperCase, pattern, origin);
    }

    static String lowerCaseFirstCharInsideSentence(String origin){
        String pattern = "[^.?!]\\s[A-Z]";
        return charCaseAction(Character::toLowerCase, pattern, origin);
    }

    private static String charCaseAction(CharRefactor refactor, String pattern, String origin){
        Matcher matcher = Pattern.compile(pattern).matcher(origin);
        StringBuilder sb = new StringBuilder();
        int last = 0;

        while (matcher.find()) {
            sb.append(origin.substring(last, matcher.start()));
            StringBuilder capitalChar = new StringBuilder(matcher.group(0));
            capitalChar.setCharAt(capitalChar.length()-1,
                    refactor.perform(capitalChar.charAt(capitalChar.length()-1)));
            sb.append(capitalChar);
            last = matcher.end();
        }

        sb.append(origin.substring(last));
        return sb.toString();
    }

    interface CharRefactor {
        char perform(char c);
    }
}
