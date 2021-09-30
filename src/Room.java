public class Room {

    // We have variables for name, description and other parameters since this is necessary to determine the players
    // current state in the world.
    private String name;
    private String description;
    public int numberOfDoors = 2;

    private Item item;

    // Store the default values for name and description of a room.
    public Room(String inName, String inDescription) {
        name = inName;
        description = inDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Return the decription of an item
    public String getItemDescription() {
        //If item isn't null (we have stored an item in item)
        if(item != null) {
            return item.toString();
        }else { // else if item is null and no item stored in item (by adding through setItem)
            return "";
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setItem(Item inItem){
        item = inItem;
    }
    @Override
    public String toString(){
        String roomString = getName() + "\n";
        roomString = roomString + getDescription() + "\n";
        roomString = roomString + "Items\n-------------\n";

        if (item != null){
            roomString = roomString + item.getType();

        }
        return roomString;
        }

    }

