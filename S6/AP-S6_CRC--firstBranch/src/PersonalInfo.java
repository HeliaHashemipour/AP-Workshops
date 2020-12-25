import java.util.Date;
enum baseInsuranceType {
    //write any base insurance types
}
enum supplementaryInsuranceType {
    //write any supplementary insurance types
}
 enum Gender {
    men,
     women
}
enum AcademicCertification {
}


public class PersonalInfo {

    private String name;
    private String family;
    private Date birthday;
    private Gender gender;
    private baseInsuranceType baseInsuranceType;
    private supplementaryInsuranceType supplementaryInsuranceType;
    private String job;
    private String address;

    public void getInfo() {}
}
