package tr.com.akifsen.redis.wrapper.model;
public class User {
    private String name;
    private int age;

    // Default constructor (Redis için gerekli)
    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter ve Setter metodları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}