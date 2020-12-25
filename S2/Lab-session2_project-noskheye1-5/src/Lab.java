/**
 * The Lab class represents advanced programming lab conditions
 * for students.
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020-10-08
 */
public class Lab {
    private Student[] students;
    private double avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * create a new lab with a given capacity and day.
     * @param capacity capacity of the lab
     * @param day the day the lab is formed
     *  the capacity cant be minus
     */
    public Lab(int capacity, String day) {
        this.day = day;
        this.capacity = capacity;
        currentSize=0;
        students = new Student[capacity];
    }
    /**
     * get students
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }
    /**
     * set students
     * @param students students of the lab
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }
    /**
     *
     * @return average
     */
    public double getAvg() {
        calculateAvg();
        return avg;
    }
    /**
     * get a day
     * @return lab formation day
     */
    public String getDay() {
        return day;
    }
    /**
     * set lab formation day
     * @param day the day the lab is formed
     */
    public void setDay(String day) {
        this.day = day;
    }
    /**
     * get capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * set capacity
     * @param capacity capacity of the lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    //find the number of students that enrolled
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        }
        else
            System.out.println("Lab is full!!!");
    }
    // calculate the average
    private void calculateAvg() {
        double sum = 0;
        for(int i = 0;i<currentSize;i++){
            sum += students[i].getGrade();
        }
        avg = sum / currentSize;
    }
    // print students information
    public void print() {
        for (int i = 0;i<currentSize;i++){
            System.out.println("student" + (i+1) + ": " + " first name: "+ students[i].getFirstName() + "   last name: "
                    + students[i].getLastName() + "   id: " + students[i].getId() + "   grade: " + students[i].getGrade());
        }
    }
}
