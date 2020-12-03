import java.util.*; // for scanner
import java.io.*; // for file 

public class Dolphin {
    static Menu Menu = new Menu();
    static FileHandling FileHandling = new FileHandling();
    public static ArrayList<Swimmer> mySwimmers = new ArrayList<>();;

    public static void main(String[] args) throws FileNotFoundException {
        FileHandling.readFromFile(mySwimmers);
        Menu.showMenu(mySwimmers);
    }
}
