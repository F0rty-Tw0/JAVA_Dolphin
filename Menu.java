import java.util.*; // for scanner
import java.io.*; // for file 

public class Menu {
    private static Scanner input = new Scanner(System.in);

    String pattern = "as";

    // Swimmers printer
    public void printSwimmers(String discipline) {
        // Checking if we have swimmers
        if (Dolphin.mySwimmers.size() == 0) {
            Dolphin.MessagesHandler.message("NO SWIMMER AVAILABLE, TRY TO ADD SOME.");
        } else {
            Dolphin.MessagesHandler.message("PRINTING THE AVAILABLE SWIMMERS...\n");
        }
        int i = 0;
        // Sorting the swimmers based on their result
        Collections.sort(Dolphin.mySwimmers, Swimmer.SwimmerResultComparator);
        for (Swimmer Swimmer : Dolphin.mySwimmers) {
            // Checking which discipline we want to print and ignoring the swimmers with result 0
            if (Swimmer.getDiscipline().contains(discipline) && (Swimmer.getResult() != 0)) {
                i++;
                Dolphin.MessagesHandler.message("NUMBER: " + i + Dolphin.FileHandling.savingLayout(Swimmer));
            // Printing all Swimmers
            } else if ("ALL".equals(discipline)) {
                i++;
                Dolphin.MessagesHandler.message("NUMBER: " + i + Dolphin.FileHandling.savingLayout(Swimmer));
            }
        }
    }

    // Reusable Component - Top menu
    public void topMenu() {
        Dolphin.MessagesHandler.message("==================================");
        Dolphin.MessagesHandler.message("|         SWIMMERS BOOK          |");
        Dolphin.MessagesHandler.message("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        Dolphin.MessagesHandler.message("|                                |");
    }

    // Reusable Component - Bottom menu, back or exit 
    public void bottomMenu(boolean back, boolean exit) {
        Dolphin.MessagesHandler.message("|                                |");
        if (back) {
            Dolphin.MessagesHandler.message("|         BACK - [BACK]          |");
        }
        if (exit) {
            Dolphin.MessagesHandler.message("|         EXIT - [EXIT]          |");
        }
        Dolphin.MessagesHandler.message("==================================");
        Dolphin.MessagesHandler.message("\nYOUR INPUT: ");
    }

    // Reusable Component - Confirmation menu
    public void confirmMenu(Swimmer mySwimmer) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|       CONFIRM THE PAYMENT      |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|            YES - [Y]           |");
                Dolphin.MessagesHandler.message("|             NO - [N]           |");
                bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("Y".equals(inputField)) {
                    mySwimmer.setPayed(true);
                    Dolphin.MessagesHandler.message(mySwimmer.getName() + " WAS GRANTED AN YEARLY SUBSCRIPTION");
                    input.nextLine();
                } else if ("N".equals(inputField)) {
                    mySwimmer.setPayed(false);
                    Dolphin.MessagesHandler.message(mySwimmer.getName() + " HAS HIS PAYMENT ON HOLD");
                    paymentMenu(mySwimmer);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Payment menu
    public void paymentMenu(Swimmer mySwimmer) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|   WOULD YOU LIKE TO PAY NOW?   |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|            YES - [Y]           |");
                Dolphin.MessagesHandler.message("|             NO - [N]           |");
                bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("Y".equals(inputField)) {
                    Dolphin.FeeManagment.proceedPayment(mySwimmer);
                } else if ("N".equals(inputField)) {
                    mySwimmer.setPayed(false);
                    Dolphin.MessagesHandler.message("THIS SWIMMER HAS HIS PAYMENT ON HOLD");
                    input.nextLine();
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Mannage swimmers Menu
    public void swimmersMenu(Boolean isCoach) throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|     MANNAGE SWIMMERS MENU      |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|    ADD A NEW SWIMMER - [A]     |");
                Dolphin.MessagesHandler.message("|   PRINT ALL SWIMMERS - [P]     |");
                Dolphin.MessagesHandler.message("|     DELETE A SWIMMER - [D]     |");
                Dolphin.MessagesHandler.message("| EDIT AN EXISTING SWIMMER - [E] |");
                bottomMenu(true, false);
                String inputField = input.nextLine().toUpperCase();
                if ("A".equals(inputField)) {
                    Dolphin.HandleSwimmers.addSwimmer(isCoach);
                } else if ("P".equals(inputField)) {
                    printSwimmers("ALL");
                    swimmersMenu(isCoach);
                } else if ("D".equals(inputField)) {
                    Dolphin.HandleSwimmers.deleteSwimmers(isCoach);
                } else if ("E".equals(inputField)) {
                    Dolphin.HandleSwimmers.editSwimmers(isCoach);
                } else if ("BACK".equals(inputField)) {
                    selectMenu(true, isCoach, false);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Set prices menu
    public void setPricesMenu() throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|        SET PRICES MENU         |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|   CHANGE PASSIVE PRICE - [P]   |");
                Dolphin.MessagesHandler.message("|    CHANGE SENIOR PRICE - [S]   |");
                Dolphin.MessagesHandler.message("|    CHANGE JUNIOR PRICE - [J]   |");
                bottomMenu(true, false);
                String inputField = input.nextLine().toUpperCase();
                if ("P".equals(inputField)) {
                    Dolphin.FeeManagment.changePassivePrice();
                } else if ("S".equals(inputField)) {
                    Dolphin.FeeManagment.changeSeniorPrice();
                } else if ("J".equals(inputField)) {
                    Dolphin.FeeManagment.changeJuniorPrice();
                } else if ("BACK".equals(inputField)) {
                    selectMenu(false, false, true);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Printing swimming results menu
    public void swimingResultsMenu() throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|  PRINT SWIMMING RESULTS MENU   |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          FREESTYLE - [F]       |");
                Dolphin.MessagesHandler.message("|           BUTERFLY - [B]       |");
                Dolphin.MessagesHandler.message("|         BACKSTROKE - [BA]      |");
                Dolphin.MessagesHandler.message("|       BREASTSTROKE - [BR]      |");
                bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                if ("F".equals(inputField)) {
                    printSwimmers("FREESTYLE");
                    swimingResultsMenu();
                } else if ("B".equals(inputField)) {
                    printSwimmers("BUTERFLY");
                    swimingResultsMenu();
                } else if ("BA".equals(inputField)) {
                    printSwimmers("BACKSTROKE");
                    swimingResultsMenu();
                } else if ("BR".equals(inputField)) {
                    printSwimmers("BREASTSTROKE");
                    swimingResultsMenu();
                } else if ("BACK".equals(inputField)) {
                    input.nextLine();
                    selectMenu(false, true, false);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Main menu based on the Administrator
    public void selectMenu(Boolean isChairman, Boolean isCoach, Boolean isTreasurer) throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|       SELECT YOUR ACTION       |");
                Dolphin.MessagesHandler.message("|                                |");
                if (isCoach || isChairman) {
                    Dolphin.MessagesHandler.message("|      MANAGE SWIMMERS - [M]     |");
                }
                if (isCoach) {
                    Dolphin.MessagesHandler.message("|   EDIT SWIMING RESULTS - [E]   |");
                    Dolphin.MessagesHandler.message("|        PRINT TOP 5 - [T]       |");
                }
                if (isTreasurer) {
                    Dolphin.MessagesHandler.message("|  PRINT CURRENT PRICES - [P]    |");
                    Dolphin.MessagesHandler.message("|    SET CURRENT PRICES - [S]    |");
                    Dolphin.MessagesHandler.message("|    SET ELDER DISCOUNT - [E]    |");
                    Dolphin.MessagesHandler.message("| PRINT ALL WHO DIDN'T PAY - [D] |");
                }
                bottomMenu(true, false);
                String inputField = input.nextLine().toUpperCase();
                if ("M".equals(inputField) && (isCoach || isChairman)) {
                    swimmersMenu(isCoach);
                } else if ("E".equals(inputField) && isCoach) {
                    Dolphin.HandleSwimmers.editSwimmersResult();
                } else if ("T".equals(inputField) && isCoach) {
                    swimingResultsMenu();
                } else if ("S".equals(inputField) && isTreasurer) {
                    setPricesMenu();
                    selectMenu(isChairman, isCoach, isTreasurer);
                } else if ("P".equals(inputField) && isTreasurer) {
                    Dolphin.treasurer.printPrices();
                    selectMenu(isChairman, isCoach, isTreasurer);
                } else if ("E".equals(inputField) && isTreasurer) {
                    Dolphin.FeeManagment.changeElderDiscount();
                    selectMenu(isChairman, isCoach, isTreasurer);
                } else if ("D".equals(inputField) && isTreasurer) {
                    Dolphin.treasurer.printHoldPayments();
                    selectMenu(isChairman, isCoach, isTreasurer);
                } else if ("BACK".equals(inputField)) {
                    mainMenu();
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Main login Screen
    public void mainMenu() throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|           MAIN MENU            |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|       ENTER YOUR PASSWORD      |");
                bottomMenu(false, true);
                String inputField = input.nextLine().toUpperCase();
                if ("CHAIRMAN".equals(inputField)) {
                    selectMenu(true, false, false);
                } else if ("COACH".equals(inputField)) {
                    selectMenu(false, true, false);
                } else if ("TREASURER".equals(inputField)) {
                    selectMenu(false, false, true);
                } else if ("EXIT".equals(inputField)) {
                    Dolphin.MessagesHandler.message("EXITING THE PROGRAM!");
                    System.exit(1);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }
}
