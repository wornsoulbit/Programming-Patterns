
package bird;

public interface Bird { 
    // birds implement Bird interface that allows 
    // them to fly and make sounds adaptee interface 
    public void fly(); 
    public void makeSound(); 
}
  
class Sparrow implements Bird { 
    // a concrete implementation of bird 
    public void fly() { 
        System.out.println("Flying"); 
    } 
    
    public void makeSound() { 
        System.out.println("Chirp Chirp"); 
    } 
} 
  
interface ToyDuck { 
    // target interface 
    // toyducks dont fly they just make 
    // squeaking sound 
    public void squeak(); 
} 
  
class PlasticToyDuck implements ToyDuck { 
    public void squeak() { 
        System.out.println("Squeak"); 
    } 
} 

