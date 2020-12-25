
import java.util.List;

public class Patient {

    private PersonalInfo personalInfo;
    private MedicalHistory medicalHistory;
    private Disease disease;
    private List<Physician> physicians;

    /**
     *
     */
    public void showInfo() {}

    /**
     *
     * @return
     */
    public MedicalHistory getMedicalHistory () {return null;}

    /**
     *
     * @return
     */
    public Disease getDisease() {return null;}

    /**
     *
     * @param type
     * @return
     */
    public Disease search(DiseaseType type) {return null;}

    /**
     *
     */
    public void choosePhysician() {}
}
