/**
 * Vote class holds vote information like voter info and vote submitted date.
 * @author Helia Sadat Hashemipour
 * @version 0.0
 * @since 2020
 */

import java.util.Objects;

public class Vote {
    private Person person;
    private String date;

    /**
     * Create a new vote with a given person and date
     * @param person person who votes
     * @param date   date of vote
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * Get person
     * @return person that voted
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Get date
     * @return date that vote submitted.
     */
    public String getDate() {
        return date;
    }

    /**
     * Overriding equals method
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return getPerson().equals(vote.getPerson()) &&
                getDate().equals(vote.getDate());
    }

    /**
     * Overriding hashCode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPerson(), getDate());
    }
}
