/**
 *The Run class which is run the various classes that use in this program.
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020-10-08
 */
public class Run {


    public static void main(String[] args) {
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");
        Lab lab = new Lab(10, "shanbe");

        EducationalGroup educationalGroup = new EducationalGroup("CE", "Dr.Fallah", 1);
        College college = new College("Dr.Zarandi", "electronic and computer engineering");

        std1.print();
        std1.setGrade(15);
        std1.setFirstName("Ehsan");
        std1.setLastName("Edalat");
        std1.setId("9031066");
        std1.print();
        lab.enrollStudent(std1);
        enter();
        std2.print();
        std2.setGrade(11);
        std2.setFirstName("Seyed");
        std2.setLastName("Ahmadpanah");
        std2.setId("9031806");
        std2.print();
        lab.enrollStudent(std2);
        enter();
        std3.print();
        std3.setGrade(16);
        std3.setFirstName("Ahmad");
        std3.setLastName("Asadi");
        std3.setId("9031054");
        std3.print();
        lab.enrollStudent(std3);
        lab.print();
        System.out.println("average: " + lab.getAvg());
        enter();
        educationalGroup.addLab(lab);
        enter();
        System.out.println("Full Report EducationalGroup");
        educationalGroup.printLabsFullReport();
        enter();
        System.out.println("Info EducationalGroup");
        educationalGroup.printLabsInfo();
        enter();
        college.getEducationalGroups().add(educationalGroup);
        enter();
        System.out.println("College Average");
        college.getCollageAverage();
        enter();
        System.out.println("College Info");
        college.printCollegeInfo();
        enter();
        System.out.println("College Full Report");
        college.printFullReport();
    }

    static void enter() {
        System.out.println();
    }
}
