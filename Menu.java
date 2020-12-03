import java.util.*; // for scanner
import java.io.*; // for file 

public class Menu {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static HandleSwimmers HandleSwimmers = new HandleSwimmers();
    private static Scanner input = new Scanner(System.in);

    // Swimmers printer
    public void printSwimmers(ArrayList<Swimmer> mySwimers) {
        ArrayList<Swimmer> mySwimmers = mySwimers;
        int i = 0;
        if (mySwimmers.size() == 0) {
            MessagesHandler.message("NO SWIMMER AVAILABLE, TRY TO ADD SOME.");
        } else {
            MessagesHandler.message("PRINTING THE AVAILABLE SWIMMERS...\n");
        }
        for (Swimmer Swimmer : mySwimmers) {
            i++;
            MessagesHandler.message("NUMBER: " + i + " | NAME: " + Swimmer.getName() + " | SURENAME: "
                    + Swimmer.getSurename() + " | MEMBERSHIP: " + Swimmer.getMembership() + " | DISCIPLINE: "
                    + Swimmer.getDiscipline() + " | STATUS: " + Swimmer.getStatus() + " | ACTIVITY: "
                    + Swimmer.getActivity() + " | AGE: " + Swimmer.getAge() + "\n");
        }
    }

    public void topMenu() {
        MessagesHandler.message("==================================");
        MessagesHandler.message("|         SWIMMERS BOOK          |");
        MessagesHandler.message("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        MessagesHandler.message("|                                |");
    }

    public void bottomMenu(boolean back, boolean exit) {
        MessagesHandler.message("|                                |");
        if (back) {
            MessagesHandler.message("|         BACK - [BACK]          |");
        }
        if (exit) {
            MessagesHandler.message("|         EXIT - [EXIT]          |");
        }
        MessagesHandler.message("==================================");
        MessagesHandler.message("\nYOUR INPUT: ");
    }

    // Main Menu
    public void showMenu(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|    ADD A NEW SWIMMER - [A]     |");
                MessagesHandler.message("|   PRINT ALL SWIMMERS - [P]     |");
                MessagesHandler.message("|     DELETE A SWIMMER - [D]     |");
                MessagesHandler.message("| EDIT AN EXISTING SWIMMER - [E] |");
                bottomMenu(false, true);
                String inputField = input.nextLine().toUpperCase();
                if ("A".equals(inputField)) {
                    HandleSwimmers.addSwimmer(mySwimmers);
                } else if ("P".equals(inputField)) {
                    printSwimmers(mySwimmers);
                    showMenu(mySwimmers);
                } else if ("D".equals(inputField)) {
                    HandleSwimmers.deleteSwimmers(mySwimmers);
                } else if ("E".equals(inputField)) {
                    HandleSwimmers.editSwimmers(mySwimmers);
                } else if ("EXIT".equals(inputField)) {
                    MessagesHandler.message("EXITING THE PROGRAM!");
                    System.exit(1);
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }
}
