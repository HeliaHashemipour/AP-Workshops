
/**
 * The EducationalGroup class represents the educational system conditions.
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020-10-08
 *
 */
public class EducationalGroup {

    private String educationalGroupName;
    private String educationalGroupBossName;
    private int numberOfLabs;
    private Lab[] labs;
    private int currentSize;

    /**
     * create a new educational Group with given educational Group's Name ,educational Group's Boss Name and number Of Labs
     * tge number of labs cant be minus
     * @param educationalGroupName     for educational Group's Name
     * @param educationalGroupBossName for educational Group's Boss Name
     * @param numberOfLabs    for number Of Labs
     */
    public EducationalGroup(String educationalGroupName, String educationalGroupBossName, int numberOfLabs) {
        this.educationalGroupName = educationalGroupName;
        this.educationalGroupBossName = educationalGroupBossName;
        this.numberOfLabs = numberOfLabs;
        labs = new Lab[numberOfLabs];
        currentSize = 0;
    }

    /**
     * getEducationalGroupName
     *
     * @return educational Group's Name
     */
    public String getEducationalGroupName() {
        return educationalGroupName;
    }

    /**
     * set college's name
     *
     * @param educationalGroupName name of educationalGroup
     */
    public void setEducationalGroupName(String educationalGroupName) {
        this.educationalGroupName = educationalGroupName;
    }

    /**
     * @return educationalGroup's name
     */
    public String getEducationalGroupBossName() {
        return educationalGroupBossName;
    }

    /**
     * set educationalGroup's boss name
     *
     * @param educationalGroupBossName for educationalGroup's boss name
     */
    public void setEducationalGroupBossName(String educationalGroupBossName) {
        this.educationalGroupBossName = educationalGroupBossName;
    }

    /**
     * @return number of labs
     */
    public int getNumberOfLabs() {
        return numberOfLabs;
    }

    /**
     * set number of labs for educationalGroup
     *
     * @param numberOfLabs for number of labs
     */
    public void setNumberOfLabs(int numberOfLabs) {
        this.numberOfLabs = numberOfLabs;
    }

    /**
     * get labs
     *
     * @return labs
     */
    public Lab[] getLabs() {
        return labs;
    }

    /**
     * set labs for educationalGroup
     *
     * @param labs for labs of educationalGroup
     */
    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    /**
     * add lab to educationalGroup
     *
     * @param lab for lab
     *            if currentSize less then numberOfLabs, lab will be added else print an error.
     */
    public void addLab(Lab lab) {
        if (currentSize < numberOfLabs)
            labs[currentSize++] = lab;
        else
            System.out.println("College is full");
    }

    /**
     * print labs full report
     * prints lab's and students information
     */
    public void printLabsFullReport() {
        for (int i = 0; i < labs.length; i++) {
            if (labs[i] != null) {
                System.out.println("Lab" + (i + 1) + " Ave: " + labs[i].getAvg() + " Day: " + labs[i].getDay() + " Capacity: " + labs[i].getCapacity());
                labs[i].print();
                System.out.println();
            }
        }

    }

    /**
     * prints lab's information such as average, formed day and capacity.
     */
    public void printLabsInfo() {
        for (int i = 0; i < labs.length; i++) {
            if (labs[i] != null)
                System.out.println("Lab" + (i + 1) + " Ave: " + labs[i].getAvg() + " Day: " + labs[i].getDay() + " Capacity" + labs[i].getCapacity());
        }
    }

    /**
     * prints educationalGroup's info
     * @return educationalGroupName and educationalGroupBossName and numberOfLabs
     */
    public String getInfo(){
        return  "educationalGroupName='" + educationalGroupName + '\'' +
                ", educationalGroupBossName='" + educationalGroupBossName + '\'' +
                ", numberOfLabs=" + numberOfLabs ;}

}
