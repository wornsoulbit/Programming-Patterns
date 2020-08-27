/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horse;

/**
 *
 * @author Alex
 */
public class RaceHorse extends Horse{
    private int raceNumber;

    public RaceHorse(String name, String color, int age, int raceNumber) {
        super(name, color, age);
        this.raceNumber = raceNumber;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("%s %s", "Race Number:", raceNumber);
    }
    
    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }
}
