import java.util.*; // for scanner
import java.io.*; // for file 

public class HandleSwimmers {
    static MessagesHandler MessagesHandler = new MessagesHandler();
    static FileHandling FileHandling = new FileHandling();
    static Menu Menu = new Menu();
    static Scanner input = new Scanner(System.in);
    static String name;
    static String surename;
    static String discipline;
    static String activity;
    static String status;
    static int age;
    static Swimmer Swimmer;

    // Add Swimmer (problems on adding two words)
    public void addSwimmer(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A NAME: ");
                        name = input.next().toUpperCase();
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A SURENAME: ");
                        surename = input.next().toUpperCase();
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER THE AGE: ");
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
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A DISCIPLINE: ");
                        discipline = input.next().toUpperCase();
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try { // todo
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER AN ACTIVITY: ");
                        activity = input.next().toUpperCase();
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                Swimmer = new Swimmer(name, surename, discipline, status, activity, age);
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
    public static void editSwimmer(int i, ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        do {
            try {
                MessagesHandler.setSentinel(false);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A NAME: ");
                        name = input.next().toUpperCase();
                        mySwimmers.get(i).setName(name);
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A SURENAME: ");
                        surename = input.next().toUpperCase();
                        mySwimmers.get(i).setSurename(surename);
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER THE AGE: ");
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
                do {
                    try {
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER A DISCIPLINE: ");
                        discipline = input.next().toUpperCase();
                        mySwimmers.get(i).setDiscipline(discipline);
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
                do {
                    try { // todo
                        MessagesHandler.setSentinel(false);
                        MessagesHandler.message("PLEASE ENTER AN ACTIVITY: ");
                        activity = input.next().toUpperCase();
                        mySwimmers.get(i).setActivity(activity);
                    } catch (InputMismatchException error) {
                        MessagesHandler.handleError();
                    }
                } while (MessagesHandler.getSentinel() == true);
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
    static public void editSwimmers(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
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
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + "\n");
                        editSwimmer(Integer.parseInt(inputField) - 1, mySwimmers);
                        Menu.showMenu(mySwimmers);
                    } else if (mySwimmers.size() >= 1) {
                        MessagesHandler.message("EDITING NUMBER: " + (inputField) + " | " + " Name: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | Surename: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | Age: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + "\n");
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
                    MessagesHandler.message("Wrong input!\n");
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
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + "\n");
                        mySwimmers.remove(Integer.parseInt(inputField) - 1);
                        FileHandling.saveToFile(mySwimmers);
                        Menu.showMenu(mySwimmers);
                    } else if (mySwimmers.size() >= 1) {
                        MessagesHandler.message("SUCCESSFULL DELETED NUMBER: " + (inputField) + " | " + " NAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getName() + " | SURENAME: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getSurename() + " | DISCIPLINE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getDiscipline() + " | ACTIVITY: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getActivity() + " | STATUS: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getStatus() + " | AGE: "
                                + mySwimmers.get(Integer.parseInt(inputField) - 1).getAge() + "\n");
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
                    MessagesHandler.message("Wrong input!\n");
                }
            } catch (InputMismatchException error) {
                MessagesHandler.handleError();
            }
        } while (MessagesHandler.getSentinel() == true);
    };

}
