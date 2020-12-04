import java.util.*; // for scanner
import java.io.*; // for file 

public class Dolphin {
    public static Menu Menu = new Menu();
    public static FileHandling FileHandling = new FileHandling();
    public static MessagesHandler MessagesHandler = new MessagesHandler();
    public static HandleSwimmers HandleSwimmers = new HandleSwimmers();
    public static FeeManagment FeeManagment = new FeeManagment();
    public static ArrayList<Swimmer> mySwimmers = new ArrayList<>();;
    private static Chairman chairman = new Chairman("RAZVAN");
    public static Treasurer treasurer = new Treasurer("PAWEL");
    public static Coach[] coachList = { new Coach("JOHN", "FREESTYLE"), new Coach("DOE", "BUTERFLY"),
            new Coach("ART", "BACKSTROKE"), new Coach("FENIX", "BREASTSTROKE") };

    public static void main(String[] args) throws FileNotFoundException {
        FileHandling.readSwimmersFromFile();
        Menu.mainMenu();
    }
}
