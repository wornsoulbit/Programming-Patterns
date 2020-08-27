
package hotelroom;

/**
 *
 * @author Alex Vasil
 */
public class HotelRoom {
    
    private int roomNum;
    protected double rentRate;

    /**
     * Sets the rate of the rent depending on the room number.
     * 
     * @param roomNum Room number.
     */
    public HotelRoom(int roomNum) {
        this.roomNum = roomNum;
        
        if (roomNum < 299)
            rentRate = 69.95;
        else
            rentRate = 89.95;
    }

    @Override
    public String toString() {
        String strOut = String.format("%s %d\n", "Room Number:", roomNum);
        strOut += String.format("%-13s$%.2f", "Rent Rate:", rentRate);
        return strOut;
    }
    
    public int getRoomNum() {
        return roomNum;
    }

    public double getRentRate() {
        return rentRate;
    }
    
}
