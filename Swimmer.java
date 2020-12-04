import java.util.Comparator;

public class Swimmer {
    String name;
    String surename;
    String membership;
    String discipline;
    String activity;
    String status;
    int age;
    Boolean payed;
    String team;
    String coach;
    int result;

    public Swimmer(String name, String surename, String membership, String discipline, String status, String activity,
            int age, Boolean payed, String team, String coach, int result) {
        this.name = name;
        this.surename = surename;
        this.membership = membership;
        this.discipline = discipline;
        this.status = status;
        this.activity = activity;
        this.age = age;
        this.payed = payed;
        this.team = team;
        this.coach = coach;
        this.result = result;
    };

    public int getAge() {
        return age;
    };

    public String getName() {
        return name;
    };

    public String getDiscipline() {
        return discipline;
    };

    public String getMembership() {
        return membership;
    };

    public String getActivity() {
        return activity;
    }

    public String getSurename() {
        return surename;
    };

    public String getStatus() {
        return status;
    }

    public Boolean getPayed() {
        return payed;
    }

    public String getTeam() {
        return team;
    }

    public int getResult() {
        return result;
    }

    public String getCoach() {
        return coach;
    }

    public void setAge(int age) {
        this.age = age;
    };

    public void setName(String name) {
        this.name = name;
    };

    public void setSurename(String surename) {
        this.surename = surename;
    };

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    };

    public void setMembership(String membership) {
        this.membership = membership;
    };

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public static Comparator<Swimmer> SwimmerDisciplineComparator = new Comparator<Swimmer>() {

        public int compare(Swimmer Swimmer1, Swimmer Swimmer2) {
            String SwimmerDiscipline1 = Swimmer1.getDiscipline().toUpperCase();
            String SwimmerDiscipline2 = Swimmer2.getDiscipline().toUpperCase();

            // ascending order
            return SwimmerDiscipline1.compareTo(SwimmerDiscipline2);

            // descending order
            // return SwimmerDiscipline2.compareTo(SwimmerDiscipline1);
        }
    };

    public static Comparator<Swimmer> SwimmerResultComparator = new Comparator<Swimmer>() {
        public int compare(Swimmer Swimmer1, Swimmer Swimmer2) {

            int result1 = Swimmer1.getResult();
            int result2 = Swimmer2.getResult();

            // For ascending order
            return result1 - result2;

            // For descending order
            // return result2-result1;
        }
    };
}
