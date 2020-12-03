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

    public Swimmer(String name, String surename, String membership, String discipline, String status, String activity,
            int age, Boolean payed, String team) {
        this.name = name;
        this.surename = surename;
        this.membership = membership;
        this.discipline = discipline;
        this.status = status;
        this.activity = activity;
        this.age = age;
        this.payed = payed;
        this.team = team;
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
}
