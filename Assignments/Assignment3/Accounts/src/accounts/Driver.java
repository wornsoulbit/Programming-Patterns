package accounts;

import accounts.Accounts;


/**
 *
 * @author Alex Vasil
 */
public class Driver {
    public static void main(String[] args) {
        Accounts acc1 = new Accounts();
        
        acc1.add(new Accounts(0, "John"), "Montreal");
        acc1.add(new Accounts(0, "John"), "Toronto");
        acc1.add(new Accounts(10, "Jane"), "Montreal");
        acc1.add(new Accounts(1, "John"), "Toronto");
        acc1.add(new Accounts(30, "Corn"), "Montreal");
        acc1.add(new Accounts(1, "John"), "Montreal");
        acc1.add(new Accounts(5, "Doe"), "Montreal");
        
        System.out.println(acc1.printMap());
    }
}
