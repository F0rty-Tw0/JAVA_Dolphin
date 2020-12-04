import java.util.*; // for scanner
import java.io.*; // for file 

public class Dolphin {
    private static Menu Menu = new Menu();
    private static FileHandling FileHandling = new FileHandling();
    public static ArrayList<Swimmer> mySwimmers = new ArrayList<>();;
    private static Chairman chairman = new Chairman("Razvan");
    public static Treasurer treasurer = new Treasurer("Pawel");
    private static Coach coach = new Coach("Art", "FREESTYLE");

    public static void main(String[] args) throws FileNotFoundException {
        FileHandling.readSwimmersFromFile();
        Menu.mainMenu();
    }
}
