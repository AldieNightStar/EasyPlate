package com.fox;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EasyPlate {
    public static String specialSymbolStart = "$[[";
    public static String specialSymbolEnd = "]]";

    public static String render(String string, Map<String, String> model){
        String line = string;
        if (!line.contains(specialSymbolStart)){
            return line;
        }
        while (containsSpecialSubstrings(line)){
            String gotString = nextSpecialSubString(line);
            String key = gotString; // May be in some time it will be as function, so i did that
            String stringToBeReplaced = specialSymbolStart + gotString + specialSymbolEnd;
            String stringToReplace = model.getOrDefault(key, "");
            line = line.replace(stringToBeReplaced, stringToReplace);
        }
        return line;
    }

    private static String nextSpecialSubString(String str){
        int startPosition = str.indexOf(specialSymbolStart);
        int endPosition   = str.indexOf(specialSymbolEnd, startPosition) + specialSymbolEnd.length();
        int len1 = specialSymbolStart.length();
        int len2 =   specialSymbolEnd.length();
        return str.substring(startPosition+len1, endPosition-len2);
    }

    private static boolean containsSpecialSubstrings(String line){
        return line.contains(specialSymbolStart) && line.contains(specialSymbolEnd);
    }
}
