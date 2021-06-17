package game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        roomManager.init();
        Player player = new Player(roomManager.getStartingRoom());

       while (true){
           printRoom(player);
           String[] input = collectInput();
           parse(input,player);
       }
    }

    private static void printRoom(Player player) {
        System.out.println(player.getRoom().getName() + "\n");
        System.out.println(player.getRoom().getLongDescription() + "\n");
        System.out.println("Exists:");

        player.getRoom().getExits().forEach((s, room) -> {
            System.out.println(s + ": " +  room.getShortDescription());
        });
        System.out.println();
    }


    private static String[] collectInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.split(" ");
    }


    private static void parse(String[] command, Player player) {
        String direction = command[1];
        player.setRoom(player.getRoom().getExit(direction));
    }

}
