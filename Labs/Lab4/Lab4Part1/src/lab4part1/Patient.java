/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

/**
 *
 * @author Alex Vasil
 */
public class Patient {
    private int idNumber;
    private String name;
    private boolean emergencyCase;

    public Patient(int idNumber, String name, boolean emerengyCase) {
        this.idNumber = idNumber;
        this.name = name;
        this.emergencyCase = emerengyCase;
    }

    @Override
    public String toString() {
        return "Patient{" + "idNumber=" + idNumber + ", name=" + name + ", emerengyCase=" + emergencyCase + '}';
    }
    
    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public boolean isEmergencyCase() {
        return emergencyCase;
    }
}
