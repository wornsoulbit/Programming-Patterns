package hotelroom;

import java.util.ArrayList;

/**
 * Test file.
 *
 * @author Alex
 */
public class UseHotelRoom {

    public static void main(String[] args) {

        System.out.println("Inital Room/Rent rate test");
        HotelRoom room = new HotelRoom(32);
        System.out.println(room);
        Suite nSuite = new Suite(0);
        System.out.println(nSuite);

        System.out.println("");
        System.out.println("Printing an array of HotelRooms");

        //Array of 5 objects, 3 HotelRoom and 2 Suite objects.
        HotelRoom[] rooms = new HotelRoom[5];
        rooms[0] = new HotelRoom(1);
        rooms[1] = new HotelRoom(2);
        rooms[2] = new Suite(100);
        rooms[3] = new Suite(200);
        rooms[4] = new Suite(300);

        for (Object roomNum : rooms) {
            System.out.println(roomNum);
        }

        System.out.println("");

        //ArrayList of 4 objects, 2 HotelRoom and 2 Suite objects.
        ArrayList<HotelRoom> rooms2 = new ArrayList<>();
        rooms2.add(new HotelRoom(299));
        rooms2.add(new HotelRoom(100));
        rooms2.add(new Suite(50));
        rooms2.add(new Suite(45));

        //Prints out the ArrayList using Lamda expression.
        rooms2.forEach((roomNum) -> {
            System.out.println(roomNum);
        });
    }
}
