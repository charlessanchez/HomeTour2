package game;

import fixtures.Room;

public class Player {

    private Room room;

    public Player(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
