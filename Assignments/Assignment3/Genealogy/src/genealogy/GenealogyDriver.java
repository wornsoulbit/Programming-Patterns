
package genealogy;

/**
 *
 * @author Alex Vasil
 */
public class GenealogyDriver {
    public static void main(String[] args) {
        Genealogy.addFamily("Ben", new String[]{"Anna", "Sam", "Eddy"});
        Genealogy.addFamily("Anna", new String[]{"Pierre"});
        Genealogy.addFamily("Pierre", new String[]{});
        Genealogy.addFamily("Alex", new String[]{});
        System.out.println(Genealogy.isDescendant("Anna", "Alex"));
    }
}
