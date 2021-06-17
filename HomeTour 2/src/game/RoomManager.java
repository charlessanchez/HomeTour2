package game;

import fixtures.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomManager {

    private Room startingRoom;

    private final Room[] rooms = new Room[4];

    public void init() {
        loadRooms();
        this.startingRoom = rooms[0];

    }
\
    public Room getStartingRoom() {
        return startingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }

    private void loadRooms(){
        Room foyer = new Room(
                "The Foyer",
                "a small foyer",
                "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
                        + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
                        + "To the north is a small room, where you can see a piano.");
        Room library = new Room(
                "The library",
                "A quite place",
                "a place where many books are kept. Most libraries are public and let people take the books to use in their home.\n" +
                        "Most libraries let people borrow books for several weeks."
        );

        Room cinema = new Room(
                "The cinema",
                "An entertainment venture",
                "a theatre where films are shown for public entertainment"
        );

        Room casino = new Room(
                "The Casino",
                "For gambling addicts",
                "A casino is a facility for certain types of gambling. Casinos are often built near or combined with hotels, resorts, restaurants,\n" +
                        "retail shopping, cruise ships, and other tourist attractions. Some casinos are also known\n" +
                        "for hosting live entertainment, such as stand-up comedy, concerts, and sports."
        );

        Room church = new Room(
                "The church",
                "A place of worship",
                "is a building used for Christian worship services and other Christian religious activities.\n" +
                        "The term is used to refer to the physical buildings where Christians worship and also to refer\n" +
                        "to the community of Christians. Sometimes it is used as an analogy for the buildings of other religions."
        );


        /*
        * Initial Set Up
        * Foyer is center
        * Church is north of Foyer
        * Library is east of Foyer
        * Casino is west of Foyer
        * Cinema is South of Foyer
        * */

        rooms[0]= foyer;
        rooms[3] = casino;
        rooms[4] = cinema;
        rooms[1]= church;
        rooms[2] = library;


        //Set the exits to the rooms
        for (Room room :
                rooms) {
            room.setExits(getRoomExists(room,rooms));
        }
    }

    private Map<String,Room> getRoomExists(Room room,Room[] rooms){
        Map<String,Room> exits = new HashMap<>();
        int index = 0;;

        for (int i = 0; i < rooms.length; i++) {
           if(room.getName().equals(rooms[i].getName())){
               index = i;
           }
        }

        for (int i = 0; i < rooms.length; i++) {
            if(!(i == index)){
                exits.put(parseIndexToDirection(i),rooms[i]);
            }
        }

        return exits;
    }

    private String parseIndexToDirection(int index){
        String direction = "";

        switch (index){
            case 0:
                direction = "north";
                break;
            case 1:
                direction = "east";
                break;
            case 2:
                direction = "south";
                break;
            case 3:
                direction = "west";
                break;
        }

        return direction;
    }

    public void showMap(){
        System.out.println("\t\t\t\t"+ rooms[0].getName());
        System.out.println("\n");
        System.out.println(rooms[3].getName() + "\t\t\t  \t\t\t" + rooms[1].getName());
        System.out.println("\n");
        System.out.println("\t\t\t\t"+ rooms[2].getName());
    }
}
