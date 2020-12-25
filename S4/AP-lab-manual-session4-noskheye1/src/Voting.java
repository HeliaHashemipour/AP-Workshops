import java.util.ArrayList;
import java.util.*;
import ir.huri.jcal.JalaliCalendar;
/**
 * Voting class represents voting
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020
 */


public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voter;
    private HashMap<String, HashSet<Vote>> polls;
    private ArrayList<String> listOfPolls;

    /**
     * Create a new voting
     * @param type     voting type
     * @param question voting question
     */
    public Voting (int type , String question) {
        this.type = type;
        this.question = question;
        voter = new ArrayList<>();
        polls = new HashMap<>();
        listOfPolls = new ArrayList<>();
    }
    /**
     * Get question
     * @return voting question
     */
    public String getQuestion() {
        return question;
    }
    /**
     * add options of voting
     * @param choice
     */
    public void createPolls(String choice) {
        listOfPolls.add(choice);
    }

    /**
     * Submit a vote
     * @param person voter
     * @param votes  list of votes
     */
    public void vote (Person person, ArrayList<String> votes) {
        for (String choice : listOfPolls) {
            if (polls.get(choice) == null)
                polls.put(choice, new HashSet<>());
        }
        int index = voter.indexOf(person);
        if (index < 0) {//returns -1
            if ((type == 0 && votes.size() == 1) || type == 1) {
                voter.add(person);
                JalaliCalendar jalaliCalendar = new JalaliCalendar();
                String date = jalaliCalendar.toString();
                Vote vote = new Vote(person,date);
                for (String choice : listOfPolls)
                    for (String chosen : votes)
                        if (choice.equals(chosen))
                            polls.get(choice).add(vote);
                System.out.println("Vote submitted");
            }
            else
                System.out.println("Vote does not submitted, you choose wrong type of voting");
        }
        else
            System.out.println("You cant vote more than one time");

    }
    /**
     * Print full name of voters.
     */
    public void printVoters() {
        for (Person person : voter)
            System.out.println(person.toString());
    }

    /**
     * Print result of voting
     */
    public void printVotes() {
        for (String choice : polls.keySet()) {
            System.out.println(choice + "=> " + polls.get(choice).size());
        }
    }

    /**
     * Get options list
     * @return options list
     */
    public ArrayList<String> getPolls() {
        return listOfPolls;
    }

}

