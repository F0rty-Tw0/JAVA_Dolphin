import java.util.*; // for scanner
import java.io.*; // for file 

public class FileHandling {

    private void scaningLayout(Scanner file) throws FileNotFoundException {
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
            line.next();
            line.next();
            String team = line.next();
            line.next();
            line.next();
            String coach = line.next();
            line.next();
            line.next();
            int result = line.nextInt();
            Dolphin.mySwimmers.add(new Swimmer(name, surename, membership, discipline, status, activity, age, payed,
                    team, coach, result));
        }
    }

    public String savingLayout(Swimmer Swimmer) {
        return " | " + " NAME: " + Swimmer.getName() + " | SURENAME: " + Swimmer.getSurename() + " | MEMBERSHIP: "
                + Swimmer.getMembership() + " | DISCIPLINE: " + Swimmer.getDiscipline() + " | STATUS: "
                + Swimmer.getStatus() + " | ACTIVITY: " + Swimmer.getActivity() + " | AGE: " + Swimmer.getAge()
                + " | PAYED: " + Swimmer.getPayed() + " | TEAM: " + Swimmer.getTeam() + " | COACH: "
                + Swimmer.getCoach() + " | RESULT: " + Swimmer.getResult() + "\n";
    }

    // Reading Swimmers from file
    public void readSwimmersFromFile() throws FileNotFoundException {
        try {
            new File("SWIMMERS.txt").createNewFile();
            Scanner file = new Scanner(new File("SWIMMERS.txt")); // scans the file
            scaningLayout(file);
        } catch (IOException e) {
            Dolphin.MessagesHandler.message("AN ERROR HAS OCCURED");
        }
    };

    // Saving Swimmers to file
    public void saveSwimmersToFile() {
        try {
            FileWriter myWriter = new FileWriter("SWIMMERS.txt");
            int i = 0;
            Collections.sort(Dolphin.mySwimmers, Swimmer.SwimmerDisciplineComparator);
            for (Swimmer Swimmer : Dolphin.mySwimmers) {
                i++;
                myWriter.write(i + savingLayout(Swimmer));
            }
            myWriter.close();
        } catch (IOException e) {
            Dolphin.MessagesHandler.message("AN ERROR HAS OCCURED");
            e.printStackTrace();
        }
    }
}
