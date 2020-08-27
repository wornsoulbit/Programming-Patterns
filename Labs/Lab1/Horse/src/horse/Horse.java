
package horse;

/**
 *
 * @author Alex
 */
public class Horse {
    protected String name;
    protected String color;
    protected int age;

    public Horse(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    
    public void print() {
        System.out.printf("%s %s\n", "Name:", name);
        System.out.printf("%s %s\n", "Color:", color);
        System.out.printf("%s %d years old\n", "Age:", age);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    
}
