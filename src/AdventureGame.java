import java.util.Scanner;

public class AdventureGame {
    public void initialization() {
        // Initialisering
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls and pink furniture");
        Room aHall = new Room("A hall", "A large hallway with rugs on the floor");
        Room theEntrance = new Room("The entrence", "A large entrance to the map");
        Room aDarkCave = new Room("A dark cave", "A very dark cave without any lights");

        Room[][] map = {
                {pinkRoom, aHall},
                {theEntrance, aDarkCave}
        };

        int row = 1;
        int col = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game (TAG)");

        boolean running = true;

    }

    public void gameLoop() {

    }

    public void exitGame(){


    }
}

