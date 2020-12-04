import java.util.*; // for scanner
import java.io.*; // for file 

public class HandleSwimmers {
    // Setting the Default Attributes
    private static Scanner input = new Scanner(System.in);
    private static Swimmer Swimmer;
    private static String name;
    private static String surename;
    private static String membership;
    private static String discipline;
    private static String activity;
    private static String status;
    private static int age;
    private static Boolean payed;
    private static String team;
    private static String coach;
    private static int result;

    // Setters of the Swimmers
    // Setting the name
    private void setSwimmerName() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|       PLEASE ENTER A NAME      |");
                Dolphin.Menu.bottomMenu(false, false);
                name = input.next().toUpperCase();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerSureName() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|     PLEASE ENTER A SURENAME    |");
                Dolphin.Menu.bottomMenu(false, false);
                surename = input.next().toUpperCase();
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerAge() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Dolphin.Menu.bottomMenu(false, false);
                age = input.nextInt();
                // Setting the status based on the Swimmer Age
                if (age >= 18) {
                    status = "SENIOR";
                } else {
                    status = "JUNIOR";
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
                input.nextLine();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerMemebership() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|       CHOSE A MEMBERSHIP       |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          ACTIVE - [A]          |");
                Dolphin.MessagesHandler.message("|         PASSIVE - [P]          |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("A".equals(inputField)) {
                    membership = "ACTIVE";
                } else if ("P".equals(inputField)) {
                    membership = "PASSIVE";
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerDiscipline() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|    PLEASE CHOSE A DISCIPLINE   |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          FREESTYLE - [F]       |");
                Dolphin.MessagesHandler.message("|           BUTERFLY - [B]       |");
                Dolphin.MessagesHandler.message("|         BACKSTROKE - [BA]      |");
                Dolphin.MessagesHandler.message("|       BREASTSTROKE - [BR]      |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("F".equals(inputField)) {
                    discipline = "FREESTYLE";
                } else if ("B".equals(inputField)) {
                    discipline = "BUTERFLY";
                } else if ("BA".equals(inputField)) {
                    discipline = "BACKSTROKE";
                } else if ("BR".equals(inputField)) {
                    discipline = "BREASTSTROKE";
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
                // Assigning a coach bases on the chosed discipline
                for (int j = 0; j < Dolphin.coachList.length; j++) {
                    if (discipline.equals(Dolphin.coachList[j].getDiscipline()) && "ELITE".equals(activity)) {
                        coach = Dolphin.coachList[j].getName();
                    }
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerActivity() {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|        CHOSE AN ACTIVITY       |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          CASUAL - [C]          |");
                Dolphin.MessagesHandler.message("|           ELITE - [E]          |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("C".equals(inputField)) {
                    activity = "CASUAL";
                    team = "null";
                } else if ("E".equals(inputField)) {
                    activity = "ELITE";
                    // Checking if the age is less than 18 and the activity is Elite
                    // Then Assigning the team based on the result
                    if (age < 18) {
                        team = "ONE";
                    } else {
                        team = "TWO";
                    }
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Edit options/menus
    private void editSwimmerName(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|      PLEASE ENTER THE NAME     |");
                Dolphin.Menu.bottomMenu(false, false);
                name = input.next().toUpperCase();
                Dolphin.mySwimmers.get(i).setName(name);
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerSureName(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|     PLEASE ENTER A SURENAME    |");
                Dolphin.Menu.bottomMenu(false, false);
                surename = input.next().toUpperCase();
                Dolphin.mySwimmers.get(i).setSurename(surename);
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerAge(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Dolphin.Menu.bottomMenu(false, false);
                age = input.nextInt();
                Dolphin.mySwimmers.get(i).setAge(age);
                // Same logic as seting the age, then assigning the status
                if (age >= 18) {
                    Dolphin.mySwimmers.get(i).setStatus("SENIOR");
                } else {
                    Dolphin.mySwimmers.get(i).setStatus("JUNIOR");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
                input.nextLine();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerMembership(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|       CHOSE A MEMBERSHIP       |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          ACTIVE - [A]          |");
                Dolphin.MessagesHandler.message("|         PASSIVE - [P]          |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("A".equals(inputField)) {
                    membership = "ACTIVE";
                    Dolphin.mySwimmers.get(i).setMembership(membership);
                } else if ("P".equals(inputField)) {
                    membership = "PASSIVE";
                    Dolphin.mySwimmers.get(i).setMembership(membership);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerDiscipline(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|    PLEASE CHOSE A DISCIPLINE   |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          FREESTYLE - [F]       |");
                Dolphin.MessagesHandler.message("|           BUTERFLY - [B]       |");
                Dolphin.MessagesHandler.message("|         BACKSTROKE - [BA]      |");
                Dolphin.MessagesHandler.message("|       BREASTSTROKE - [BR]      |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("F".equals(inputField)) {
                    discipline = "FREESTYLE";
                    Dolphin.mySwimmers.get(i).setDiscipline(discipline);
                } else if ("B".equals(inputField)) {
                    discipline = "BUTERFLY";
                    Dolphin.mySwimmers.get(i).setDiscipline(discipline);
                } else if ("BA".equals(inputField)) {
                    discipline = "BACKSTROKE";
                    Dolphin.mySwimmers.get(i).setDiscipline(discipline);
                } else if ("BR".equals(inputField)) {
                    discipline = "BREASTSTROKE";
                    Dolphin.mySwimmers.get(i).setDiscipline(discipline);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
                // Changing the coach based on the edited discipline
                for (int j = 0; j < Dolphin.coachList.length; j++) {
                    if (discipline.equals(Dolphin.coachList[j].getDiscipline())
                            && "ELITE".equals(Dolphin.mySwimmers.get(i).getActivity())) {
                        Dolphin.mySwimmers.get(i).setCoach(Dolphin.coachList[j].getName());
                    }
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerActivity(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|        CHOSE AN ACTIVITY       |");
                Dolphin.MessagesHandler.message("|                                |");
                Dolphin.MessagesHandler.message("|          CASUAL - [C]          |");
                Dolphin.MessagesHandler.message("|           ELITE - [E]          |");
                Dolphin.Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("C".equals(inputField)) {
                    activity = "CASUAL";
                    Dolphin.mySwimmers.get(i).setActivity(activity);
                    Dolphin.mySwimmers.get(i).setTeam("null");
                } else if ("E".equals(inputField)) {
                    activity = "ELITE";
                    Dolphin.mySwimmers.get(i).setActivity(activity);
                    // Updating the team based on the activity
                    if (age < 18) {
                        Dolphin.mySwimmers.get(i).setTeam("ONE");
                    } else {
                        Dolphin.mySwimmers.get(i).setTeam("TWO");
                    }
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Add Swimmer (problems on adding two words)
    public void addSwimmer(Boolean isCoach) throws FileNotFoundException {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                setSwimmerName();
                setSwimmerSureName();
                setSwimmerAge();
                setSwimmerMemebership();
                setSwimmerActivity();
                setSwimmerDiscipline();
                result = 0;
                // Setting the swimmer class
                Swimmer = new Swimmer(name, surename, membership, discipline, status, activity, age, payed, team, coach,
                        result);
                Dolphin.Menu.paymentMenu(Swimmer);
                Dolphin.mySwimmers.add(Swimmer);
                Dolphin.MessagesHandler
                        .message("SWIMMER : " + name + " " + surename + " WAS ADDED TO THE SWIMMERS LSIT");
                // Saving This swimmer to the file 
                Dolphin.FileHandling.saveSwimmersToFile();
                // Buffer clearing
                input.nextLine();
                Dolphin.Menu.swimmersMenu(isCoach);
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    // Editing the selected Swimmer if we are Coach
    private void editSwimmer(int i, Boolean isCoach) throws FileNotFoundException {
        editSwimmerName(i);
        editSwimmerSureName(i);
        editSwimmerAge(i);
        editSwimmerMembership(i);
        editSwimmerActivity(i);
        editSwimmerDiscipline(i);
        Dolphin.MessagesHandler.message("SWIMMER : " + name + " " + surename + " WAS EDITED TO THE SWIMMER LSIT");
        Dolphin.FileHandling.saveSwimmersToFile();
        input.nextLine();
        editSwimmers(isCoach);
    }

    // Way to show which Swimmer we are editing/deleting
    private String messageSwimmerLine(String inputField) {
        return (inputField) + " | " + " NAME: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getName()
                + " | SURENAME: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename()
                + " | MEMEMBERSHIP: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership()
                + " | DISCIPLINE: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline()
                + " | STATUS: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | ACTIVITY: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + " | COACH: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getCoach() + " | RESULT: "
                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getResult() + "\n";
    }

    // Editing a Swimmer
    public void editSwimmers(Boolean isCoach) throws FileNotFoundException {
        Dolphin.Menu.printSwimmers("ALL");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                // Checking if we have any swimmers in the arraylist
                if (Dolphin.mySwimmers.size() > 0) {
                    Dolphin.MessagesHandler.message("|    ENTER THE SWIMMMER NUMBER   |");
                    Dolphin.MessagesHandler
                            .message("|   YOU WANT TO EDIT - [1-" + Dolphin.mySwimmers.size() + "]     |");
                } else {
                    Dolphin.MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    Dolphin.MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Dolphin.Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    Dolphin.MessagesHandler.setSentinel(false);
                    // Setting a selector for the Swimmer
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > Dolphin.mySwimmers.size()) {
                        Dolphin.MessagesHandler
                                .message("ENTER A NUMBER BETWEEN [1-" + Dolphin.mySwimmers.size() + "] !!!");
                        editSwimmers(isCoach);
                        // A way to not run underr the non existant Array possition
                    } else if (Dolphin.mySwimmers.size() == 1) {
                        Dolphin.MessagesHandler.message("EDITING NUMBER: " + messageSwimmerLine(inputField));
                        editSwimmer(Integer.parseInt(inputField) - 1, isCoach);
                        Dolphin.Menu.swimmersMenu(isCoach);
                    } else if (Dolphin.mySwimmers.size() >= 1) {
                        Dolphin.MessagesHandler.message("EDITING NUMBER: " + messageSwimmerLine(inputField));
                        editSwimmer(Integer.parseInt(inputField) - 1, isCoach);
                        editSwimmers(isCoach);
                    }
                } catch (NumberFormatException err) {
                    Dolphin.MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Dolphin.Menu.swimmersMenu(isCoach);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    };

    // Result editor
    private void editResult(int i) {
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                Dolphin.MessagesHandler.message("|   PLEASE ENTER THE NEW RESULT  |");
                Dolphin.Menu.bottomMenu(false, false);
                result = input.nextInt();
                Dolphin.mySwimmers.get(i).setResult(result);
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
                input.nextLine();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerResult(int i) throws FileNotFoundException {
        editResult(i);
        Dolphin.FileHandling.saveSwimmersToFile();
        input.nextLine();
        editSwimmersResult();
    }

    // Editing a Swimmer(same as edit Swimmer)
    public void editSwimmersResult() throws FileNotFoundException {
        Dolphin.Menu.printSwimmers("ALL");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                if (Dolphin.mySwimmers.size() > 0) {
                    Dolphin.MessagesHandler.message("|    ENTER THE SWIMMMER NUMBER   |");
                    Dolphin.MessagesHandler
                            .message("|   YOU WANT TO EDIT - [1-" + Dolphin.mySwimmers.size() + "]     |");
                } else {
                    Dolphin.MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    Dolphin.MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Dolphin.Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    Dolphin.MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > Dolphin.mySwimmers.size()) {
                        Dolphin.MessagesHandler
                                .message("ENTER A NUMBER BETWEEN [1-" + Dolphin.mySwimmers.size() + "] !!!");
                        editSwimmersResult();
                    } else if (Dolphin.mySwimmers.size() == 1) {
                        Dolphin.MessagesHandler.message("EDITING NUMBER: " + messageSwimmerLine(inputField));
                        editSwimmerResult((Integer.parseInt(inputField) - 1));
                        Dolphin.Menu.swimingResultsMenu();
                    } else if (Dolphin.mySwimmers.size() >= 1) {
                        Dolphin.MessagesHandler.message("EDITING NUMBER: " + messageSwimmerLine(inputField));
                        editSwimmerResult((Integer.parseInt(inputField) - 1));
                        editSwimmersResult();
                    }
                } catch (NumberFormatException err) {
                    Dolphin.MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Dolphin.Menu.selectMenu(false, true, false);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    };

    // Deleting a Swimmer
    public void deleteSwimmers(Boolean isCoach) throws FileNotFoundException {
        Dolphin.Menu.printSwimmers("ALL");
        do {
            try {
                Dolphin.MessagesHandler.setSentinel(false);
                Dolphin.Menu.topMenu();
                if (Dolphin.mySwimmers.size() > 0) {
                    Dolphin.MessagesHandler.message("|    ENTER THE SWIMMERS NUMBER   |");
                    Dolphin.MessagesHandler
                            .message("|   YOU WANT TO DELETE - [1-" + Dolphin.mySwimmers.size() + "]   |");
                } else {
                    Dolphin.MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    Dolphin.MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Dolphin.Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    Dolphin.MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > Dolphin.mySwimmers.size()) {
                        Dolphin.MessagesHandler
                                .message("ENTER A NUMBER BETWEEN [1-" + Dolphin.mySwimmers.size() + "] !!!");
                        deleteSwimmers(isCoach);
                    } else if (Dolphin.mySwimmers.size() == 1) {
                        Dolphin.MessagesHandler
                                .message("SUCCESSFULL DELETED NUMBER: " + messageSwimmerLine(inputField));
                        Dolphin.mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        Dolphin.FileHandling.saveSwimmersToFile();
                        Dolphin.Menu.swimmersMenu(isCoach);
                    } else if (Dolphin.mySwimmers.size() >= 1) {
                        Dolphin.MessagesHandler
                                .message("SUCCESSFULL DELETED NUMBER: " + messageSwimmerLine(inputField));
                        Dolphin.mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        Dolphin.FileHandling.saveSwimmersToFile();
                        deleteSwimmers(isCoach);
                    }
                } catch (NumberFormatException err) {
                    Dolphin.MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Dolphin.Menu.swimmersMenu(isCoach);
                } else {
                    Dolphin.MessagesHandler.sentinel = true;
                    Dolphin.MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                Dolphin.MessagesHandler.handleError();
            }
        } while (Dolphin.MessagesHandler.getSentinel() == true);
    };

}
