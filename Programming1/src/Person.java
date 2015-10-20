/**
 * @author Gataullin Kamil
 *         09.02.2015 23:55
 */
public class Person {
    public String firstName;
    public String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
