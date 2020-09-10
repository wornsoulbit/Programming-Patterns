package horse;

import java.util.Comparator;

/**
 * Sorts strings based off their lengths.
 * 
 * @author Alex Vasil
 */
public class SortStringLength implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    
}
