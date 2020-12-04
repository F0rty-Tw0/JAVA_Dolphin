import java.util.*; // for scanner
import java.io.*; // for file 

public class Menu {
    private static Scanner input = new Scanner(System.in);

    // Swimmers printer
    public void printSwimmers() {
        int i = 0;
        if (Dolphin.mySwimmers.size() == 0) {
            Dolphin.MessagesHandler.message("NO SWIMMER AVAILABLE, TRY TO ADD SOME.");
        } else {
            Dolphin.MessagesHandler.message("PRINTING THE AVAILABLE SWIMMERS...\n");
        }
        for (Swimmer Swimmer : Dolphin.mySwimmers) {
            i++;
            Dolphin.MessagesHandler
                    .message("NUMBER: " + i + " | NAME: " + Swimmer.getName() + " | SURENAME: " + Swimmer.getSurename()
                            + " | MEMBERSHIP: " + Swimmer.getMembership() + " | DISCIPLINE: " + Swimmer.getDiscipline()
                            + " | STATUS: " + Swimmer.getStatus() + " | ACTIVITY: " + Swimmer.getActivity() + " | AGE: "
                            + Swimmer.getAge() + " | PAYED: " + Swimmer.getPayed() + " | TEAM: " + Swimmer.getTeam()
                            + " | COACH: " + Swimmer.getCoach() + " | RESULT: " + Swimmer.getResult() + "\n");
        }
    }

    public void topMenu() {
        Dolphin.MessagesHandler.message("==================================");
        Dolphin.MessagesHandler.message("|         SWIMMERS BOOK          |");
        Dolphin.MessagesHandler.message("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        Dolphin.MessagesHandler.message("|                                |");
    }

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

    public void coachMenu(Boolean coach) {
        if (coach) {
            Dolphin.MessagesHandler.message("|   PRINT ALL SWIMMERS - [P]     |");
        }
    }

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

    // Main Menu
    public void swimmersMenu() throws FileNotFoundException {
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
                    Dolphin.HandleSwimmers.addSwimmer();
                } else if ("P".equals(inputField)) {
                    printSwimmers();
                    swimmersMenu();
                } else if ("D".equals(inputField)) {
                    Dolphin.HandleSwimmers.deleteSwimmers();
                } else if ("E".equals(inputField)) {
                    Dolphin.HandleSwimmers.editSwimmers();
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
                    selectMenu(false, true);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    public void selectMenu(Boolean isCoach, Boolean isTreasurer) throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                topMenu();
                Dolphin.MessagesHandler.message("|       SELECT YOUR ACTION       |");
                Dolphin.MessagesHandler.message("|                                |");
                if (isCoach) {
                    Dolphin.MessagesHandler.message("|      MANAGE SWIMMERS - [M]     |");
                    Dolphin.MessagesHandler.message("|    SET SWIMING RESULTS - [S]   |");
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
                if ("M".equals(inputField) && isCoach) {
                    swimmersMenu();
                } else if ("S".equals(inputField) && isCoach) {
                    System.out.println("SET RESULTS");
                } else if ("T".equals(inputField) && isCoach) {
                    System.out.println("PRINT TOP 5");
                } else if ("S".equals(inputField) && isTreasurer) {
                    setPricesMenu();
                    selectMenu(isCoach, isTreasurer);
                } else if ("P".equals(inputField) && isTreasurer) {
                    Dolphin.treasurer.printPrices();
                    selectMenu(isCoach, isTreasurer);
                } else if ("E".equals(inputField) && isTreasurer) {
                    Dolphin.FeeManagment.changeElderDiscount();
                    selectMenu(isCoach, isTreasurer);
                } else if ("D".equals(inputField) && isTreasurer) {
                    Dolphin.treasurer.printHoldPayments();
                    selectMenu(isCoach, isTreasurer);
                } else if ("BACK".equals(inputField)) {
                    mainMenu();
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

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
                    swimmersMenu();
                } else if ("COACH".equals(inputField)) {
                    selectMenu(true, false);
                } else if ("TREASURER".equals(inputField)) {
                    selectMenu(false, true);
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
