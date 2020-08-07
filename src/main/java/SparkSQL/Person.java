package SparkSQL;

public class Person {

    private String name;
    private String city;
    private String dateOfBird;
    private String dateOfDeath;
    private Long age;

    public Person() {

    }

    public Person(String name, String city, String dateOfBird, String dateOfDeath, Long age) {
        this.name = name;
        this.city = city;
        this.dateOfBird = dateOfBird;
        this.dateOfDeath = dateOfDeath;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(String dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
