package org.student;

import java.util.HashMap;
import java.util.Map;

public class TestImpl {
    public static void main(String[] args) {
        // out : a3b3c1

        String str = "a,b,a,c,d,c,c,c,c,c,c";
        String trim = str.replace(" ", "");
        String charArray[] = trim.split(",");

        HashMap<String, Integer> charMap = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charMap.keySet().contains(charArray[i])) {
                charMap.put(charArray[i], charMap.get(charArray[i]) + 1);
            } else {
                charMap.put(charArray[i], 1);
            }
        }
        String out = "";
        for (Map.Entry<String, Integer> e : charMap.entrySet()) {
            out = out+e.getKey() + e.getValue();
        }
        System.out.println(out);
    }




}
