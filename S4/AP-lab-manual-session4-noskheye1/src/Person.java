/**
 * Person class holds first name and last name of each person.
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * create a new person
     * @param firstName voter first name
     * @param lastName voter last name
     */
    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get first name of person
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name of person
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return full name of person
     */
    public String toString() {
        return firstName + " " + lastName;
    }

}
