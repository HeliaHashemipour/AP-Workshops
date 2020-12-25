
import java.util.ArrayList;

/**
 * The college class represents the college conditions.
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020-10-08
 * @version 0.0
 */
public class College {

    private ArrayList<EducationalGroup> educationalGroups = new ArrayList<>();
    private String bossName;
    private String collageName;

    /**
     * create new college with given boss name and name of college
     *
     * @param bossName    for boss name
     * @param collageName for name of college
     */
    public College(String bossName, String collageName) {
        this.bossName = bossName;
        this.collageName = collageName;
    }

    /**
     * getCollegeName
     *
     * @return college's name
     */
    public String getCollageName() {
        return collageName;
    }

    /**
     * setCollageName
     *
     * @param collageName name of collage
     */
    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    /**
     * getEducationalGroups
     *
     * @return ArrayList of educationalGroups
     */
    public ArrayList<EducationalGroup> getEducationalGroups() {
        return educationalGroups;
    }

    /**
     * setEducationalGroups
     *
     * @param educationalGroups for List of educationalGroups
     */
    public void setEducationalGroups(ArrayList<EducationalGroup> educationalGroups) {
        this.educationalGroups = educationalGroups;
    }

    /**
     * getBossName
     *
     * @return boss name
     */
    public String getBossName() {
        return bossName;
    }

    /**
     * setBossName
     *
     * @param bossName for boss name
     */
    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    /**
     * getCollageAverage
     * @return total average of college
     */
    public double getCollageAverage() {
        double sumAve = 0;
        for (EducationalGroup educationalGroup : educationalGroups) {
            for (Lab lab : educationalGroup.getLabs()) {
                sumAve += (lab.getAvg() / educationalGroup.getNumberOfLabs());
            }
        }
        return (sumAve / this.getEducationalGroups().size());
    }

    /**
     * prints info of collage and educationalGroups
     */
    public void printCollegeInfo() {
        System.out.println("College name: " + this.getCollageName());
        System.out.println("Boss name: " + this.getBossName());
        for (int i = 0; i < educationalGroups.size(); i++)
            System.out.println((i + 1) + "." + educationalGroups.get(i).getInfo());
    }


    /**
     * prints full report of everything
     */
    public void printFullReport() {
        System.out.println("College name: " + this.getCollageName());
        System.out.println("Boss name: " + this.getBossName());
        for (int i = 0; i < educationalGroups.size(); i++) {
            System.out.println((i + 1) + "." + educationalGroups.get(i).getInfo());
            educationalGroups.get(i).printLabsFullReport();
        }
    }
}
