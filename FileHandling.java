import java.util.*; // for scanner
import java.io.*; // for file 

public class FileHandling {
    private static MessagesHandler MessagesHandler = new MessagesHandler();

    // Reading from file
    public void readFromFile(ArrayList<Swimmer> mySwimmers) throws FileNotFoundException {
        try {
            new File("MySwimmers.txt").createNewFile();
            Scanner file = new Scanner(new File("MySwimmers.txt")); // scans the file
            while (file.hasNextLine()) {
                Scanner line = new Scanner(file.nextLine()); // Scans the line
                line.nextInt();
                line.next();
                line.next();
                String name = line.next();
                line.next();
                line.next();
                String surename = line.next();
                line.next();
                line.next();
                String membership = line.next();
                line.next();
                line.next();
                String discipline = line.next();
                line.next();
                line.next();
                String status = line.next();
                line.next();
                line.next();
                String activity = line.next();
                line.next();
                line.next();
                int age = line.nextInt();
                line.next();
                line.next();
                Boolean payed = line.nextBoolean();
                mySwimmers.add(new Swimmer(name, surename, membership, discipline, status, activity, age, payed));
            }
        } catch (IOException e) {
            MessagesHandler.message("An error occurred.");
        }
    };

    // Saving to file
    public void saveToFile(ArrayList<Swimmer> mySwimmers) {
        try {
            FileWriter myWriter = new FileWriter("MySwimmers.txt");
            int i = 0;
            for (Swimmer Swimmer : mySwimmers) {
                i++;
                myWriter.write(i + " | " + " NAME: " + Swimmer.getName() + " | SURENAME: " + Swimmer.getSurename()
                        + " | MEMBERSHIP: " + Swimmer.getMembership() + " | DISCIPLINE: " + Swimmer.getDiscipline()
                        + " | STATUS: " + Swimmer.getStatus() + " | ACTIVITY: " + Swimmer.getActivity() + " | AGE: "
                        + Swimmer.getAge() + " | PAYED: " + Swimmer.getPayed() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            MessagesHandler.message("An error occurred.");
            e.printStackTrace();
        }
    }
}
