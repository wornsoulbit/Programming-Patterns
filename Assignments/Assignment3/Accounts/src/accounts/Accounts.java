package accounts;


import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author Alex Vasil
 */
public class Accounts {
    private int accNum;
    private String accName;
    private Map<Accounts, String> accountMap;

    public Accounts() {
        
    }
    
    public Accounts(int accNum, String accName) {
        this.accNum = accNum;
        this.accName = accName;
    }
    
    public Accounts(int accNum, String accName, String city) {
        this.accNum = accNum;
        this.accName = accName;
        add(new Accounts(accNum, accName), city);
    }
    
    public void add(Accounts account, String city) {
        if (accountMap == null) {
            accountMap = new TreeMap<>((Accounts o1, Accounts o2) -> o1.accNum - o2.accNum);
            accountMap.put(account, city);
            return;
        }
                       
        if (!accountMap.containsKey(account)) {
            accountMap.put(account, city);
        }
    }
    
    public String printMap() {
        return accountMap.toString();
    }
    
    @Override
    public String toString() {
        return "Accounts{" + "accNum=" + accNum + ", accName=" + accName + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.accNum;
        hash = 37 * hash + Objects.hashCode(this.accName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accounts other = (Accounts) obj;
        if (this.accNum != other.accNum) {
            return false;
        }
        if (!Objects.equals(this.accName, other.accName)) {
            return false;
        }
        return true;
    }
}
