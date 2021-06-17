package fixtures;

import java.util.HashMap;
import java.util.Map;

public class Room extends Fixture{

    private Map<String,Room> exits;

    public Room(String name, String shortDescription, String longDescription) {
        super(name, shortDescription, longDescription);
        this.exits = new HashMap<>();
    }

    public void setExits(Map<String,Room> exits) {
        this.exits = exits;
    }

    public Map<String,Room> getExits() {
        return exits;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }


}
