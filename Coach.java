public class Coach extends Administrator {
    String discipline;

    // Constructor to set the Name and Discipline
    public Coach(String name, String discipline) {
        super(name);
        this.discipline = discipline;
    }

    // Coach Discipline getter
    public String getDiscipline() {
        return discipline;
    }
}