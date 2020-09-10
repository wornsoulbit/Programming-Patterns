package horse;

/**
 *
 * @author Alex
 */
public class RaceHorse extends Horse{
    private int raceNumber;

    /**
     * Constructor for RaceHorse, with name, color, age and number of races for the horse.
     * 
     * @param name Name of the horse.
     * @param color Color of the horse.
     * @param age Age of the horse.
     * @param raceNumber Number of races the horse had.
     */
    public RaceHorse(String name, String color, int age, int raceNumber) {
        super(name, color, age);
        this.raceNumber = raceNumber;
    }

    /**
     * To string method for how many races a horse had.
     * 
     * @return A formatted string of how many races a horse had.
     */
    @Override
    public String toString() {
        return String.format("%s %d", "Race Number: ", raceNumber) + super.toString();
    }
    
    /**
     * Getter for how many races a horse had.
     * 
     * @return Number of races a horse had.
     */
    public int getRaceNumber() {
        return raceNumber;
    }

    /**
     * Setter for how many races a horse had.
     * 
     * @param raceNumber How many races a horse had.
     */
    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }
}
