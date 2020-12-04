import java.util.*; // for scanner
import java.io.*; // for file 

public class HandleSwimmers {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static FileHandling FileHandling = new FileHandling();
    private static Menu Menu = new Menu();
    static Date nowDate = new Date();
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
    private static int result;

    private void setSwimmerName() {
        do {
            try {
                System.out.println(nowDate);
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|       PLEASE ENTER A NAME      |");
                Menu.bottomMenu(false, false);
                name = input.next().toUpperCase();
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerSureName() {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|     PLEASE ENTER A SURENAME    |");
                Menu.bottomMenu(false, false);
                surename = input.next().toUpperCase();
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerAge() {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Menu.bottomMenu(false, false);
                age = input.nextInt();
                if (age >= 18) {
                    status = "SENIOR";
                } else {
                    status = "JUNIOR";
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
                input.nextLine();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerMemebership() {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|       CHOSE A MEMBERSHIP       |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          ACTIVE - [A]          |");
                MessagesHandler.message("|         PASSIVE - [P]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("A".equals(inputField)) {
                    membership = "ACTIVE";
                } else if ("P".equals(inputField)) {
                    membership = "PASSIVE";
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerDiscipline() {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|    PLEASE CHOSE A DISCIPLINE   |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          FREESTYLE - [F]       |");
                MessagesHandler.message("|           BUTERFLY - [B]       |");
                MessagesHandler.message("|         BACKSTROKE - [BA]      |");
                MessagesHandler.message("|       BREASTSTROKE - [BR]      |");
                Menu.bottomMenu(false, false);
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
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void setSwimmerActivity() {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|        CHOSE AN ACTIVITY       |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          CASUAL - [C]          |");
                MessagesHandler.message("|           ELITE - [E]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("C".equals(inputField)) {
                    activity = "CASUAL";
                    team = "NONE";
                } else if ("E".equals(inputField)) {
                    activity = "ELITE";
                    if (age < 18) {
                        team = "ONE";
                    } else {
                        team = "TWO";
                    }
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerName(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|      PLEASE ENTER THE NAME     |");
                Menu.bottomMenu(false, false);
                name = input.next().toUpperCase();
                Dolphin.mySwimmers.get(i).setName(name);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerSureName(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|     PLEASE ENTER A SURENAME    |");
                Menu.bottomMenu(false, false);
                surename = input.next().toUpperCase();
                Dolphin.mySwimmers.get(i).setSurename(surename);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerAge(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Menu.bottomMenu(false, false);
                age = input.nextInt();
                Dolphin.mySwimmers.get(i).setAge(age);
                if (age >= 18) {
                    Dolphin.mySwimmers.get(i).setStatus("SENIOR");
                } else {
                    Dolphin.mySwimmers.get(i).setStatus("JUNIOR");
                }
                Dolphin.mySwimmers.get(i).setAge(age);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
                input.nextLine();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerMembership(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|       CHOSE A MEMBERSHIP       |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          ACTIVE - [A]          |");
                MessagesHandler.message("|         PASSIVE - [P]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("A".equals(inputField)) {
                    membership = "ACTIVE";
                    Dolphin.mySwimmers.get(i).setMembership(membership);
                } else if ("P".equals(inputField)) {
                    membership = "PASSIVE";
                    Dolphin.mySwimmers.get(i).setMembership(membership);
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerDiscipline(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|    PLEASE CHOSE A DISCIPLINE   |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          FREESTYLE - [F]       |");
                MessagesHandler.message("|           BUTERFLY - [B]       |");
                MessagesHandler.message("|         BACKSTROKE - [BA]      |");
                MessagesHandler.message("|       BREASTSTROKE - [BR]      |");
                Menu.bottomMenu(false, false);
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
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerActivity(int i) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|        CHOSE AN ACTIVITY       |");
                MessagesHandler.message("|                                |");
                MessagesHandler.message("|          CASUAL - [C]          |");
                MessagesHandler.message("|           ELITE - [E]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("C".equals(inputField)) {
                    activity = "CASUAL";
                    Dolphin.mySwimmers.get(i).setActivity(activity);
                    Dolphin.mySwimmers.get(i).setTeam("NONE");
                } else if ("E".equals(inputField)) {
                    activity = "ELITE";
                    Dolphin.mySwimmers.get(i).setActivity(activity);
                    if (age < 18) {
                        Dolphin.mySwimmers.get(i).setTeam("ONE");
                    } else {
                        Dolphin.mySwimmers.get(i).setTeam("TWO");
                    }
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    // Add Swimmer (problems on adding two words)
    public void addSwimmer() throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                setSwimmerName();
                setSwimmerSureName();
                setSwimmerAge();
                setSwimmerMemebership();
                setSwimmerDiscipline();
                setSwimmerActivity();
                Swimmer = new Swimmer(name, surename, membership, discipline, status, activity, age, payed, team,
                        result);
                Menu.paymentMenu(Swimmer);
                Dolphin.mySwimmers.add(Swimmer);
                MessagesHandler.message("SWIMMER : " + name + " " + surename + " WAS ADDED TO THE SWIMMERS LSIT");
                FileHandling.saveSwimmersToFile();
                input.nextLine();
                Menu.swimmersMenu();
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    // Editing the selected Swimmer
    private void editSwimmer(int i) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                editSwimmerName(i);
                editSwimmerSureName(i);
                editSwimmerAge(i);
                editSwimmerMembership(i);
                editSwimmerDiscipline(i);
                editSwimmerActivity(i);
                MessagesHandler.message("SWIMMER : " + name + " " + surename + " WAS EDITED TO THE SWIMMER LSIT");
                FileHandling.saveSwimmersToFile();
                input.nextLine();
                editSwimmers();
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    // Editing a Swimmer
    public void editSwimmers() throws FileNotFoundException {
        Menu.printSwimmers();
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                if (Dolphin.mySwimmers.size() > 0) {
                    MessagesHandler.message("|    ENTER THE SWIMMMER NUMBER   |");
                    MessagesHandler.message("|   YOU WANT TO EDIT - [1-" + Dolphin.mySwimmers.size() + "]     |");
                } else {
                    MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > Dolphin.mySwimmers.size()) {
                        MessagesHandler.message("ENTER A NUMBER BETWEEN [1-" + Dolphin.mySwimmers.size() + "] !!!");
                        editSwimmers();
                    } else if (Dolphin.mySwimmers.size() == 1) {
                        MessagesHandler.message("EDITING NUMBER: " + (inputField) + " | " + " NAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename()
                                + " | MEMEMBERSHIP: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership()
                                + " | DISCIPLINE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline()
                                + " | STATUS: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus()
                                + " | ACTIVITY: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + " | RESULT: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getResult() + "\n");
                        editSwimmer(Integer.parseInt(inputField) - 1);
                        Menu.swimmersMenu();
                    } else if (Dolphin.mySwimmers.size() >= 1) {
                        MessagesHandler.message("EDITING NUMBER: " + (inputField) + " | " + " NAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename()
                                + " | MEMEMBERSHIP: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership()
                                + " | DISCIPLINE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline()
                                + " | STATUS: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus()
                                + " | ACTIVITY: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + " | RESULT: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getResult() + "\n");
                        editSwimmer(Integer.parseInt(inputField) - 1);
                        editSwimmers();
                    }
                } catch (NumberFormatException err) {
                    MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Menu.swimmersMenu();
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    };

    // Deleting a Swimmer
    public void deleteSwimmers() throws FileNotFoundException {
        Menu.printSwimmers();
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                if (Dolphin.mySwimmers.size() > 0) {
                    MessagesHandler.message("|    ENTER THE SWIMMERS NUMBER   |");
                    MessagesHandler.message("|   YOU WANT TO DELETE - [1-" + Dolphin.mySwimmers.size() + "]   |");
                } else {
                    MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > Dolphin.mySwimmers.size()) {
                        MessagesHandler.message("ENTER A NUMBER BETWEEN [1-" + Dolphin.mySwimmers.size() + "] !!!");
                        deleteSwimmers();
                    } else if (Dolphin.mySwimmers.size() == 1) {
                        MessagesHandler.message("SUCCESSFULL DELETED NUMBER: " + (inputField) + " | " + " NAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename()
                                + " | MEMEMBERSHIP: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership()
                                + " | DISCIPLINE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline()
                                + " | STATUS: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus()
                                + " | ACTIVITY: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + " | RESULT: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getResult() + "\n");
                        Dolphin.mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        FileHandling.saveSwimmersToFile();
                        Menu.swimmersMenu();
                    } else if (Dolphin.mySwimmers.size() >= 1) {
                        MessagesHandler.message("SUCCESSFULL DELETED NUMBER: " + (inputField) + " | " + " NAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename()
                                + " | MEMEMBERSHIP: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership()
                                + " | DISCIPLINE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline()
                                + " | STATUS: " + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus()
                                + " | ACTIVITY: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + " | RESULT: "
                                + Dolphin.mySwimmers.get(Integer.parseInt(inputField) - 1).getResult() + "\n");
                        Dolphin.mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        FileHandling.saveSwimmersToFile();
                        deleteSwimmers();
                    }
                } catch (NumberFormatException err) {
                    MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Menu.swimmersMenu();
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    };

}
