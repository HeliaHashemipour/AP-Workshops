/**
 * The Student class represents a student in a student
 * administration system.
 * It holds the student details relevant in our context.
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020-10-08
 *
 */
public class Student {
    // the students first name
    private String firstName;
    // the students last name
    private String lastName;
    // the student ID
    private String id;
    //the grade
    private double grade;
    /**
     * Create a new student with a given name and ID number.
     *
     * @param firstName first name of student
     * @param lastName last name of student
     * @param id student ID
     */
    public Student(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        grade = 0;
    }/**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * get the last name of student
     * @return lastName field
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * get the ID of student
     * @return ID field
     */
    public String getId() {
        return id;
    }
    /**
     * get the grade of student
     * @return grade field
     */
    public double getGrade() {
        return grade;
    }
    /**
     * set first name of a student
     * @param firstName first name of student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * set first name of a student
     * @param lastName last name of student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * set id of a student
     * @param id ID of student
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * set id of a student
     * @param grade grade of student
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
    /**
     * Print the students last name and ID number to the
     output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: "
                + id + ", grade: " + grade);
    }



}
