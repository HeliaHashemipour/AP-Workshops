import java.util.ArrayList;
/**
 * This class represents the  voting system duty.
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;


    public VotingSystem () {
        votingList = new ArrayList<>();
    }
    /**
     * Create voting
     * @param question  question of voting.
     * @param type      type of voting.
     * @param choices   options of voting.
     */
    public void createVoting(String question, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type,question);
        for (String choice : choices)
            voting.createPolls(choice);
        votingList.add(voting);
    }
    /**
     * Print voting questions.
     */
    public void printVotingQuestions() {
        for (Voting voting : votingList)
            System.out.println(voting.getQuestion());
    }

    /**
     * Print voting question and options.
     * @param index index of voting
     */
    public void printVoting(int index) {
        if (index >= 0 && index < votingList.size()) {
            for (Voting voting : votingList)
                if (votingList.get(index) == voting) {
                    System.out.println(voting.getQuestion());
                    for (String choice : voting.getPolls())
                        System.out.println(choice);
                }
        }
        else
            System.out.println("Invalid index");

    }

    /**
     * Submit vote
     * @param index       index of voting
     * @param person      voter
     * @param votesChosen list of votes
     */
    public void vote(int index, Person person, ArrayList<String> votesChosen) {
        if (index >= 0 && index < votingList.size()) {
            votingList.get(index).vote(person,votesChosen);
        }

        else
            System.out.println("Invalid index");
    }

    /**
     * Print voting result
     * @param index index of voting
     */
    public void printResults(int index) {
        if (index >= 0 && index < votingList.size()) {
            votingList.get(index).printVotes();
            votingList.get(index).printVoters();
        }

        else
            System.out.println("Invalid index");
    }
}