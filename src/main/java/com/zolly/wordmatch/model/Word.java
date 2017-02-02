package com.zolly.wordmatch.model;

import javax.persistence.*;

/**
 * Created by oliver on 31/01/17.
 */
@Entity
@Table(name="german")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String english;
    private String german;
    private int correct;
    private int incorrect;

    private Word() { }

    public Word(String english, String german, int correct, int incorrect) {
        this.english = english;
        this.german = german;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", english='" + english + '\'' +
                ", german='" + german + '\'' +
                ", correct=" + correct +
                ", incorrect=" + incorrect +
                '}';
    }
}
