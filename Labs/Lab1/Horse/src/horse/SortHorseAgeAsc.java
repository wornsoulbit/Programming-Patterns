package horse;

import java.util.Comparator;

/**
 * Sorts horse's age in ascending order.
 * 
 * @author Alex Vasil
 */
public class SortHorseAgeAsc implements Comparator<Horse>{

    @Override
    public int compare(Horse o1, Horse o2) {
        return o1.getAge() - o2.getAge();
    }
}
