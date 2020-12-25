import java.util.ArrayList;

/**
 * Physician class
 *
 * @author Helia Sadat Hashemipour
 */
public class Physician {
    //physician's name
    private String name;
    private String diagnoses;
    ArrayList<String>medicines=new ArrayList<>();

    /**
     * Set diagnoses of patient
     */
    public void setRecord(String record) {
        this.diagnoses = record;
    }

    /**
     * Set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Create medical history for patient
     *
     * @return
     */
    public MedicalHistory createMedicalHistory() {
        //here we have do creating medical history process
        //because it is blank block it returns null
        return null;
    }

    /**
     * Refer a patient to another doctor
     *
     * @return
     */
    public Physician refer() {
        //here we have do referring a patient to another doctor
        //because it is blank block it returns null
        return null;
    }

    /**
     * Get physician's name
     *
     * @return
     */
    public String[] getPhysiciansName() {
        //here we have to get physician's name
        //because it is blank block it returns null
        return null;
    }

    /**
     * Get medicine
     * @return
     */
    public ArrayList<String> getMedicines() {
        return medicines;
    }
}
