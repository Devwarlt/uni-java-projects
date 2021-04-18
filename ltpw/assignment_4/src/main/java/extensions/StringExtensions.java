/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extensions;

/**
 *
 * @author devwarlt
 */
public final class StringExtensions {
    /**
     * Check if string is null or empty.
     * 
     * @param string
     * @return 
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
    
    /**
     * 
     * Check if string is null or contains whitespace characters.
     * 
     * @param string
     * @return 
     */
    public static boolean isNullOrWhitespace(String string) {
        return string == null || string.isBlank();
    }
}
