
package horse;

/**
 * Class of a Horse.
 * 
 * @author Alex Vasil
 */
public class Horse {
    protected String name;
    protected String color;
    protected int age;

    /**
     * Constructor for a horse, with a name, color and age.
     * 
     * @param name Name of the horse.
     * @param color Color of the horse.
     * @param age Age of the horse.
     */
    public Horse(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    
    /**
     * To string of the name, age and color of the horse.
     * 
     * @return A formatted string of name, age and color of the horse.
     */
    @Override
    public String toString() {
        String strOut = String.format("%s %s\n", "Name:", name);
        strOut += String.format("%s %s\n", "Color:", color);
        strOut += String.format("%s %s\n", "Age:", age);
        
        return strOut;
    }
    
    /**
     * Getter for the name of the horse.
     * 
     * @return Name of the horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name of the horse.
     * 
     * @param name name of the horse
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the color of the horse.
     * 
     * @return Color of the horse.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color of the horse.
     * 
     * @param color Color of the horse.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for age of the horse.
     * 
     * @return Age of the horse.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for age of the horse.
     * 
     * @param age Age of the horse.
     */
    public void setAge(int age) {
        this.age = age;
    }    
}
