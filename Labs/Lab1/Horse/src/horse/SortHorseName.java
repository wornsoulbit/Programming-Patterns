package horse;

import java.util.Comparator;

/**
 * Sorts horse's names.
 * 
 * @author Alex Vasil
 */
public class SortHorseName implements Comparator<Horse>{

    @Override
    public int compare(Horse o1, Horse o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
