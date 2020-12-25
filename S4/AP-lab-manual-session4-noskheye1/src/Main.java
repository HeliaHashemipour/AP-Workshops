import ir.huri.jcal.JalaliCalendar;
import java.util.*;

/**
 * This program represents the simple voting system.
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020
 */

public class Main {
    public static void main (String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        Person voter = new Person("Helia","Hashemipour");
        Person voter1 = new Person("Negin","Goli");

        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> days = new ArrayList<>();

        options.add("yes");
        options.add("no");

        days.add("Saturday");
        days.add("Sunday");
        days.add("Monday");
        //0 tak ray
        //1 chand ray
        votingSystem.createVoting("Do you want to come?",0,options);//one option to choose
        votingSystem.createVoting("Which day?",1,days);

        System.out.println("Printing voting questions");
        votingSystem.printVotingQuestions();

        System.out.println("Print voting");

        votingSystem.printVoting(0);

        ArrayList<String> vote1 = new ArrayList<>();
        vote1.add("yes");

        ArrayList<String> vote2 = new ArrayList<>();
        vote2.add("no");

        ArrayList<String> vote3 = new ArrayList<>();
        vote3.add("no");

        ArrayList<String> vote4 = new ArrayList<>();
        vote4.add("Sunday");
        vote4.add("Friday");

        ArrayList<String> vote5 = new ArrayList<>();
        vote5.add("Sunday");
        vote5.add("Monday");

        Person person = new Person("Nazanin","Javaheri");

        votingSystem.vote(0,voter,vote1);
        votingSystem.vote(0,voter,vote2);
        votingSystem.vote(0,person,vote2);
        votingSystem.vote(0,voter1,vote3);
        votingSystem.vote(1,voter,vote4);
        votingSystem.vote(1,person,vote5);

        System.out.println("Print result:");
        votingSystem.printResults(0);
        votingSystem.printResults(1);


        Vote vote6 = new Vote(person,"2019");
        Vote vote7 = new Vote(person,"2019");
        System.out.println("If two votes are equal: " + vote6.equals(vote7));

    }
}
