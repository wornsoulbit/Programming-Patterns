/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

import java.util.Comparator;

/**
 *
 * @author Alex Vasil
 */
public class ComparePatient implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        if (o1.isEmergencyCase() == o2.isEmergencyCase()) {
            return o1.getIdNumber() - o2.getIdNumber();
        } else {
            if (o1.isEmergencyCase()) {
                return -1;
            }else{
                return 1;
            }
        }
    }
}
