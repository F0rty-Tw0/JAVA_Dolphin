import java.util.*; // for scanner
import java.io.*; // for file 

public class Dolphin {
    private static Menu Menu = new Menu();
    private static FileHandling FileHandling = new FileHandling();
    private static ArrayList<Swimmer> mySwimmers = new ArrayList<>();;

    public static void main(String[] args) throws FileNotFoundException {
        FileHandling.readFromFile(mySwimmers);
        Menu.showMenu(mySwimmers);
    }
}
