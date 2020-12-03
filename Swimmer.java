public class Swimmer {
    String name;
    String surename;
    String discipline;
    String activity;
    int age;

    public Swimmer(String name, String surename, String discipline, String activity, int age) {
        this.name = name;
        this.surename = surename;
        this.discipline = discipline;
        this.activity = activity;
        this.age = age;
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

    public String getActivity() {
        return activity;
    }

    public String getSurename() {
        return surename;
    };

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

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
