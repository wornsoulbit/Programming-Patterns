package assignment3;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Alex Vasil
 */
public class AntonymMap {
    private static Map<String, String> antonymMap = new HashMap<>();
    
    public static void addAntonym(String key, String value) {
        antonymMap.put(key, value);
    }
    
    public static void find(String key) {
        if (antonymMap.containsValue(key)) {
            antonymMap.put(key, getKey(key));
        }
    }
    
    public static void printMap() {
        antonymMap.entrySet().forEach((entry) -> { System.out.println(entry); });
    }
    
    private static String getKey(String value) {
        for (Map.Entry<String, String> entry : antonymMap.entrySet()) {
            if (entry.getValue().equals(value))
                return entry.getKey();
        }
        return null;
    }
}
