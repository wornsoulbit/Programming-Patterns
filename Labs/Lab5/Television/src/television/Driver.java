/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package television;

import java.util.Scanner;

/**
 *
 * @author Alex Vasil
 */
public class Driver {

    public static void main(String[] args) {
        // Create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Declare variables
        int station;         // The user's channel choice

        // Declare and instantiate a television object
        Television bigScreen = new Television("Toshiba", 55);

        // Turn the power on
        bigScreen.power();

        // Display the state of the television
        System.out.println("A "
                + bigScreen.getScreenSize()
                + " inch " + bigScreen.getManufacturer()
                + " has been turned on.");

        // Prompt the user for input and store into station
        System.out.print("What channel do you want? ");
        station = keyboard.nextInt();

        // Change the channel on the television
        bigScreen.setChannel(station);

        // Increase the volume of the television
        bigScreen.increaseVolume();

        // Display the current channel and volume of the television
        System.out.println("Channel: "
                + bigScreen.getChannel()
                + " Volume: " + bigScreen.getVolume());
        System.out.println("Too loud! Lowering the volume.");

        // Decrease the volume of the television
        for (int i = 1; i <= 5; i++) {
            bigScreen.decreaseVolume();
        }

        // Display the current channel and volume of the television
        System.out.println("Channel: "
                + bigScreen.getChannel()
                + " Volume: "
                + bigScreen.getVolume());

    }

}
