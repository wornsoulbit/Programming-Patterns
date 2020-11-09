
package genealogy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class Genealogy {
    private static HashMap<String, String[]> familyTree = new LinkedHashMap<>();
    private static String treeString = "";
    
    /**
     * Adds a family to the familyTree.
     * 
     * @param parent The parent.
     * @param children The children of the parent.
     */
    public static void addFamily(String parent, String[] children) {
        familyTree.put(parent, children);
    }
    
    /**
     * Finds if descendant one is a relative of descendant two.
     * 
     * @param descendantOne Person one.
     * @param descendantTwo Person two.
     * @return A string if they're related.
     */
    public static String isDescendant(String descendantOne, String descendantTwo) {
        for (Map.Entry<String, String[]> familyEntry : familyTree.entrySet()) {
            for (String child : familyEntry.getValue()) {
                if (child.equals(descendantTwo)) {
                    treeString += child + " --> ";
                    isDescendant(descendantOne, familyEntry.getKey());
                }
            }
        }
        
        return treeString.equals("") ? descendantOne + " is not realted to " + descendantTwo : treeString + descendantOne;
    }
}
