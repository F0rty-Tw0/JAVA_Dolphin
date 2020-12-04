import java.util.*; // for scanner
import java.io.*; // for file 

public class Menu {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static HandleSwimmers HandleSwimmers = new HandleSwimmers();
    private static FeeManagment FeeManagment = new FeeManagment();
    private static Scanner input = new Scanner(System.in);
    private Boolean coach;

    // Swimmers printer
    public void printSwimmers() {
        int i = 0;
        if (Dolphin.mySwimmers.size() == 0) {
            MessagesHandler.message("NO SWIMMER AVAILABLE, TRY TO ADD SOME.");
        } else {
            MessagesHandler.message("PRINTING THE AVAILABLE SWIMMERS...\n");
        }
        for (Swimmer Swimmer : Dolphin.mySwimmers) {
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
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|            YES - [Y]           |");
                MessagesHandler.message("|             NO - [N]           |");
                bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("Y".equals(inputField)) {
                    mySwimmer.setPayed(true);
                    MessagesHandler.message(mySwimmer.getName() + " WAS GRANTED AN YEARLY SUBSCRIPTION");
                    input.nextLine();
                } else if ("N".equals(inputField)) {
                    mySwimmer.setPayed(false);
                    MessagesHandler.message(mySwimmer.getName() + " HAS HIS PAYMENT ON HOLD");
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
                MessagesHandler.message("|                                |");
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
    public void swimmersMenu() throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|     MANNAGE SWIMMERS MENU      |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|    ADD A NEW SWIMMER - [A]     |");
                MessagesHandler.message("|   PRINT ALL SWIMMERS - [P]     |");
                MessagesHandler.message("|     DELETE A SWIMMER - [D]     |");
                MessagesHandler.message("| EDIT AN EXISTING SWIMMER - [E] |");
                bottomMenu(true, false);
                String inputField = input.nextLine().toUpperCase();
                if ("A".equals(inputField)) {
                    HandleSwimmers.addSwimmer();
                } else if ("P".equals(inputField)) {
                    printSwimmers();
                    swimmersMenu();
                } else if ("D".equals(inputField)) {
                    HandleSwimmers.deleteSwimmers();
                } else if ("E".equals(inputField)) {
                    HandleSwimmers.editSwimmers();
                } else if ("BACK".equals(inputField)) {
                    mainMenu();
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    public void selectMenu(Boolean isCoach, Boolean isTreasurer) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|       SELECT YOUR ACTION       |");
                MessagesHandler.message("|                                |");
                if (isCoach) {
                    MessagesHandler.message("|      MANAGE SWIMMERS - [M]     |");
                    MessagesHandler.message("|    SET SWIMING RESULTS - [S]   |");
                    MessagesHandler.message("|        PRINT TOP 5 - [T]       |");
                }
                if (isTreasurer) {
                    MessagesHandler.message("|  PRINT CURRENT PRICES - [P]    |");
                    MessagesHandler.message("|    SET CURRENT PRICES - [S]    |");
                    MessagesHandler.message("|    SET ELDER DISCOUNT - [E]    |");
                }
                bottomMenu(true, false);
                String inputField = input.nextLine().toUpperCase();
                if ("M".equals(inputField) && isCoach) {
                    swimmersMenu();
                } else if ("S".equals(inputField) && isCoach) {
                    System.out.println("SET RESULTS");
                } else if ("T".equals(inputField) && isCoach) {
                    System.out.println("PRINT TOP 5");
                } else if ("S".equals(inputField) && isTreasurer) {
                    System.out.println("SET CURRENT PRICES");
                } else if ("P".equals(inputField) && isTreasurer) {
                    Dolphin.treasurer.printPrices(FeeManagment);
                    System.out.println("PRINT CURRENT PRICES");
                } else if ("E".equals(inputField) && isTreasurer) {
                    System.out.println("SET ELDER DISCOUNT");
                } else if ("BACK".equals(inputField)) {
                    mainMenu();
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    public void mainMenu() throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                topMenu();
                MessagesHandler.message("|           MAIN MENU            |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|       ENTER YOUR PASSWORD      |");
                bottomMenu(false, true);
                String inputField = input.nextLine().toUpperCase();
                if ("CHAIRMAN".equals(inputField)) {
                    swimmersMenu();
                } else if ("COACH".equals(inputField)) {
                    selectMenu(true, false);
                } else if ("TREASURER".equals(inputField)) {
                    selectMenu(false, true);
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
