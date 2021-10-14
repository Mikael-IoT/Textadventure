import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextAdventureGame {
    public static void save(int row, int col) {

        File file = new File("./save/saved_game.txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            String position = String.format("%d, %d", row, col);
            fileWriter.write(position);
            fileWriter.close();
            System.out.println("You have saved your game!");

        } catch (IOException e) {
            System.out.println("Could not save game");
        }
    }

    public static String load() {
        File file = new File("./save/saved_game.txt");
        try{
            Scanner fileScanner = new Scanner(file);
            String position = fileScanner.nextLine();
            fileScanner.close();
            return position;
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not load game");

        }
        return null;
    }

    public void runGame(){
        // Initialisering
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls filled with pink furniture");
        Room aHall = new Room("A hall", "A large hallway with a fancy rug on the floor");
        Room theEntrance = new Room("The entrance", "A large entrance to the map.");
        Room aDarkCave = new Room("A dark cave", "A very dark cave without any lights, and it is close to pitch black.");


        //Creating a dagger and adding it to the entrance
        Item dagger = new Item("Dagger", "A small but deadly weapon");
        theEntrance.setItem(dagger);

        //Create a chest with three items and places it in the hall on the map.
        Chest chest = new Chest("Chest", "A large chest containing some items");
        Item shield = new Item("Shield", "A massive shield that works as a wall");
        Item potion = new Item("Health Potion", "A potion that restores your health");
        Item sword = new Item("Sword", "A sharp and mighty sword. You can barely wield it one handed");
        chest.addItemsToChest(shield);
        chest.addItemsToChest(potion);
        chest.addItemsToChest(sword);
        aHall.setItem(chest);



        Room[][] map = {
                {pinkRoom, aHall},
                {theEntrance, aDarkCave}
        };
        int row = 1;
        int col = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game (TAG)");

        boolean running = true;

        // Här börjar spelloopen
        while(running) {
            // 1. Skriv ut i vilket rum vi är i
            System.out.println(map[row][col].toString());


            // 2. Läs in kommando från användaren
            System.out.print("> ");
            String command = input.nextLine();

            // 3. Dela upp kommandot i delar, varje ord blir en sträng i en array
            //    Vi delar upp det inmatade värdet vid varje mellanslag
            String[] commandParts = command.split(" ");

            // 4. Kollar vilket "huvudkommando" som angivits
            //    Dessa är:
            //      - go
            //      - quit
            //      - save
            //      - load
            if(commandParts[0].equalsIgnoreCase("go")) {
                // Vi har angett go som kommando


                // Kontrollera att man har skrivit något efter go, alltså en riktning
                if(commandParts.length >= 2) {
                    // Kolla efter riktning
                    if(commandParts[1].equalsIgnoreCase("north")) {
                        row--;
                        // Kontrollera så vi inte hamnar utanför kartan
                        if(row < 0) {
                            row = 0;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("south")) {
                        row++;
                        if(row >= map.length) {
                            row--;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("east")) {
                        col++;
                        if(col >= map[row].length) {
                            col--;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("west")) {
                        col--;
                        if(col < 0) {
                            col = 0;
                        }
                    }
                    System.out.println("Going " + commandParts[1]);
                }
                else {
                    System.out.println("You can't go without any direction");
                }
            }
            if(command.equalsIgnoreCase("save")) {
                save(row, col);
            }
            if(command.equalsIgnoreCase("Look at item")){
                String itemDescription = map[row][col].getItemDescription();
                System.out.println(itemDescription);

            }

            if(command.equalsIgnoreCase("load")) {
                String position = load();
                if(position != null){
                    String[] pos = position.split(", ");
                    int oldRow = row;
                    int oldCol = col;
                    row = Integer.parseInt(pos[0]);
                    col = Integer.parseInt(pos[1]);
                    if (row >= map.length) {
                        System.out.println("Error reading row coordinates from file. Cheater alert!");
                        row = oldRow;
                        col = oldCol;
                    }
                    else
                    if (col >= map[row].length) {
                        row = oldRow;
                        col = oldCol;
                        System.out.println("Error reading column coordinates from file. Cheater alert!");
                    }
                }



            }

            if(command.equalsIgnoreCase("quit")) {
                running = false;
            }
        }
        System.out.println("Thanks for playing TAG");
    }
}
