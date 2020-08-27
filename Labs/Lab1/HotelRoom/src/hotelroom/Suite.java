
package hotelroom;

/**
 * 
 * @author Alex Vasil
 */
public class Suite extends HotelRoom {

    /**
     * Adds to the price of the suite depending on the super rent rate.
     * 
     * @param roomNum Room number.
     */
    public Suite(int roomNum) {
        super(roomNum);
        super.rentRate = super.getRentRate() + 40;
    }
    
}
