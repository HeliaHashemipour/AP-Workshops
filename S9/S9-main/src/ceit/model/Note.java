package ceit.model;

import java.io.Serializable;

public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    /**
     * Create a new note
     * @param title note title
     * @param content note content
     * @param date date of creation
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * override toString method
     * @return string
     */
    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

