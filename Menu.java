import java.util.*; // for scanner
import java.io.*; // for file 

public class Menu {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static HandleSwimmers HandleSwimmers = new HandleSwimmers();
    private static FeeManagment FeeManagment = new FeeManagment();
    private static Scanner input = new Scanner(System.in);
    private Boolean coach;

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
                    + Swimmer.getActivity() + " | AGE: " + Swimmer.getAge() + " | PAYED: " + Swimmer.getPayed()
                    + " | TEAM: " + Swimmer.getTeam() + " | RESULT: " + Swimmer.getResult() + "\n");
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

    public void confirmMenu(Swimmer mySwimmer) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|       CONFIRM THE PAYMENT      |");
                MessagesHandler.message("|            YES - [Y]           |");
                MessagesHandler.message("|             NO - [N]           |");
                bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("Y".equals(inputField)) {
                    mySwimmer.setPayed(true);
                    MessagesHandler.message("THIS SWIMMER WAS GRANTED AN YEARLY SUBSCRIPTION");
                    input.nextLine();
                } else if ("N".equals(inputField)) {
                    mySwimmer.setPayed(false);
                    MessagesHandler.message("THIS SWIMMER HAS HIS PAYMENT ON HOLD");
                    paymentMenu(mySwimmer);
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    public void coachMenu(Boolean coach) {
        if (coach) {
            MessagesHandler.message("|   PRINT ALL SWIMMERS - [P]     |");
        }
    }

    public void paymentMenu(Swimmer mySwimmer) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|   WOULD YOU LIKE TO PAY NOW?   |");
                MessagesHandler.message("|            YES - [Y]           |");
                MessagesHandler.message("|             NO - [N]           |");
                bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("Y".equals(inputField)) {
                    FeeManagment.proceedPayment(mySwimmer);
                } else if ("N".equals(inputField)) {
                    mySwimmer.setPayed(false);
                    MessagesHandler.message("THIS SWIMMER HAS HIS PAYMENT ON HOLD");
                    input.nextLine();
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
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
