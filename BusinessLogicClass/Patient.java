package BusinessLogicClass;

public class Patient {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient(String name, int age, String gender) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient ID: "+id+", Name: "+name+", Age: "+age+", Gender: "+gender;
    }
}