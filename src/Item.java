
public class Item {
    protected String type;
    protected String description;

    public Item(String inType, String inDescription){
        type = inType;
        description = inDescription;
    }

    public String getType() {
        return type;}
    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        String itemDescription = type;
        itemDescription = itemDescription + "\n";
        itemDescription = itemDescription + description;
        return itemDescription;
    }
}
