/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examtest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class ExamTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] strArr = {"take", "it", "as", "it", "is", "as", "you", "want", "it"};
        NumOccurances numOcc = new NumOccurances(strArr);
        
        numOcc.outputMostOccurances();
    }
    
}

class StackArray {
    
}

class NumOccurances {
    private static HashMap<String, Integer> stringMap = new HashMap();
    
    public NumOccurances(String[] strArr) {
        for (String str : strArr) {
            if (!stringMap.containsKey(str)) {
                stringMap.put(str, 1);
            } else {
                stringMap.put(str, stringMap.get(str) + 1);
            }
        }
    }
    
    public void outputMostOccurances() {
        int maxValue = Collections.max(stringMap.values());
        
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey() + " has occured " + entry.getValue());
            }
        }
    }
}
