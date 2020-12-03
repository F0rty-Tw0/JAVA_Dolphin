import java.util.*; // for scanner
import java.io.*; // for file 

public class HandleSwimmers {
    private static MessagesHandler MessagesHandler = new MessagesHandler();
    private static FileHandling FileHandling = new FileHandling();
    private static Menu Menu = new Menu();
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

    private void setSwimmerName() {
        do {
            try {
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
                MessagesHandler.message("|    PLEASE ENTER A DISCIPLINE   |");
                Menu.bottomMenu(false, false);
                discipline = input.next().toUpperCase();
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

    private void editSwimmerName(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Menu.bottomMenu(false, false);
                name = input.next().toUpperCase();
                mySwimmers.get(i).setName(name);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerSureName(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|     PLEASE ENTER A SURENAME    |");
                Menu.bottomMenu(false, false);
                surename = input.next().toUpperCase();
                mySwimmers.get(i).setSurename(surename);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerAge(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|      PLEASE ENTER THE AGE      |");
                Menu.bottomMenu(false, false);
                age = input.nextInt();
                mySwimmers.get(i).setAge(age);
                if (age >= 18) {
                    mySwimmers.get(i).setStatus("SENIOR");
                } else {
                    mySwimmers.get(i).setStatus("JUNIOR");
                }
                mySwimmers.get(i).setAge(age);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
                input.nextLine();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerMembership(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|       CHOSE A MEMBERSHIP       |");
                MessagesHandler.message("|          ACTIVE - [A]          |");
                MessagesHandler.message("|         PASSIVE - [P]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("A".equals(inputField)) {
                    membership = "ACTIVE";
                    mySwimmers.get(i).setMembership(membership);
                } else if ("P".equals(inputField)) {
                    membership = "PASSIVE";
                    mySwimmers.get(i).setMembership(membership);
                } else {
                    MessagesHandler.sentinel = true;
                    MessagesHandler.message("WRONG INPUT!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerDiscipline(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|    PLEASE ENTER A DISCIPLINE   |");
                Menu.bottomMenu(false, false);
                discipline = input.next().toUpperCase();
                mySwimmers.get(i).setDiscipline(discipline);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    private void editSwimmerActivity(int i, ArrayList<Swimmer> mySwimmers) {
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                MessagesHandler.message("|        CHOSE AN ACTIVITY       |");
                MessagesHandler.message("|          CASUAL - [C]          |");
                MessagesHandler.message("|           ELITE - [E]          |");
                Menu.bottomMenu(false, false);
                String inputField = input.next().toUpperCase();
                if ("C".equals(inputField)) {
                    activity = "CASUAL";
                    mySwimmers.get(i).setActivity(activity);
                    mySwimmers.get(i).setTeam("NONE");
                } else if ("E".equals(inputField)) {
                    activity = "ELITE";
                    mySwimmers.get(i).setActivity(activity);
                    if (age < 18) {
                        mySwimmers.get(i).setTeam("ONE");
                    } else {
                        mySwimmers.get(i).setTeam("TWO");
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
    public void addSwimmer(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                setSwimmerName();
                setSwimmerSureName();
                setSwimmerAge();
                setSwimmerMemebership();
                setSwimmerDiscipline();
                setSwimmerActivity();
                Swimmer = new Swimmer(name, surename, membership, discipline, status, activity, age, payed, team);
                Menu.paymentMenu(Swimmer);
                mySwimmers.add(Swimmer);
                MessagesHandler.message("SWIMMER : " + name + " " + surename + " WAS ADDED TO THE SWIMMERS LSIT");
                FileHandling.saveToFile(mySwimmers);
                input.nextLine();
                Menu.showMenu(mySwimmers);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    // Editing the selected Swimmer
    private void editSwimmer(int i, ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                editSwimmerName(i, mySwimmers);
                editSwimmerSureName(i, mySwimmers);
                editSwimmerAge(i, mySwimmers);
                editSwimmerMembership(i, mySwimmers);
                editSwimmerDiscipline(i, mySwimmers);
                editSwimmerActivity(i, mySwimmers);
                MessagesHandler.message("SWIMMER : " + name + " " + surename + " WAS EDITED TO THE SWIMMER LSIT");
                FileHandling.saveToFile(mySwimmers);
                input.nextLine();
                editSwimmers(mySwimmers);
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    }

    // Editing a Swimmer
    public void editSwimmers(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        Menu.printSwimmers(mySwimmers);
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                if (mySwimmers.size() > 0) {
                    MessagesHandler.message("|    ENTER THE SWIMMMER NUMBER   |");
                    MessagesHandler.message("|   YOU WANT TO EDIT - [1-" + mySwimmers.size() + "]     |");
                } else {
                    MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > mySwimmers.size()) {
                        MessagesHandler.message("ENTER A NUMBER BETWEEN [1-" + mySwimmers.size() + "] !!!");
                        editSwimmers(mySwimmers);
                    } else if (mySwimmers.size() == 1) {
                        MessagesHandler.message("EDITING NUMBER: " + (inputField) + " | " + " NAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | MEMEMBERSHIP: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + "\n");
                        editSwimmer(Integer.parseInt(inputField) - 1, mySwimmers);
                        Menu.showMenu(mySwimmers);
                    } else if (mySwimmers.size() >= 1) {
                        MessagesHandler.message("EDITING NUMBER: " + (inputField) + " | " + " NAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | MEMEMBERSHIP: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + "\n");
                        editSwimmer(Integer.parseInt(inputField) - 1, mySwimmers);
                        editSwimmers(mySwimmers);
                    }
                } catch (NumberFormatException err) {
                    MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Menu.showMenu(mySwimmers);
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
    public void deleteSwimmers(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        Menu.printSwimmers(mySwimmers);
        do {
            try {
                MessagesHandler.setSentinel(false);
                Menu.topMenu();
                if (mySwimmers.size() > 0) {
                    MessagesHandler.message("|    ENTER THE SWIMMERS NUMBER   |");
                    MessagesHandler.message("|   YOU WANT TO DELETE - [1-" + mySwimmers.size() + "]   |");
                } else {
                    MessagesHandler.message("|     NO SWIMMERS AVAILABLE      |");
                    MessagesHandler.message("|        TRY TO ADD SOME         |");
                }
                Menu.bottomMenu(true, false);
                String inputField = input.next().toUpperCase();
                try {
                    MessagesHandler.setSentinel(false);
                    if (Integer.parseInt(inputField) == 0 || Integer.parseInt(inputField) > mySwimmers.size()) {
                        MessagesHandler.message("ENTER A NUMBER BETWEEN [1-" + mySwimmers.size() + "] !!!");
                        deleteSwimmers(mySwimmers);
                    } else if (mySwimmers.size() == 1) {
                        MessagesHandler.message("SUCCESSFULL DELETED NUMBER: " + (inputField) + " | " + " NAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | MEMEMBERSHIP: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + "\n");
                        mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        FileHandling.saveToFile(mySwimmers);
                        Menu.showMenu(mySwimmers);
                    } else if (mySwimmers.size() >= 1) {
                        MessagesHandler.message("SUCCESSFULL DELETED NUMBER: " + (inputField) + " | " + " NAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | MEMEMBERSHIP: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getMembership() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + " | PAYED: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getPayed() + " | TEAM: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getTeam() + "\n");
                        mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        FileHandling.saveToFile(mySwimmers);
                        deleteSwimmers(mySwimmers);
                    }
                } catch (NumberFormatException err) {
                    MessagesHandler.sentinel = true;
                }
                if ("BACK".equals(inputField)) {
                    input.nextLine();
                    Menu.showMenu(mySwimmers);
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
