public class Coach extends Administrator {
    String discipline;

    public Coach(String name, String discipline) {
        super(name);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    
}