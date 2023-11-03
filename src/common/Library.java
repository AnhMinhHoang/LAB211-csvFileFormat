/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author GoldCandy
 */
public class Library {

    private String lowerCaseAll(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = Character.toLowerCase(c[i]);
        }
        str = String.valueOf(c);
        return str;
    }

    private String firstCharUpperCase(String str) {
        str = lowerCaseAll(str);
        char[] c = str.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        for (int i = 2; i < str.length(); i++) {
            if (c[i - 1] == ' ') {
                c[i] = Character.toUpperCase(c[i]);
            }
        }
        str = String.valueOf(c);
        return str;
    }

    public String format(String str) {
        str = str.replaceAll("\\s+", " ").trim();
        str = firstCharUpperCase(str);
        return str;
    }
}
