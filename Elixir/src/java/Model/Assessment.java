package Model;

import java.util.Calendar;
import java.util.Date;

/**
 * ***************************************************************************
 *
 * File : Assessment.java
 *
 * Date : 06-Mar-2018
 *
 * Description : Code for class Assessment, based on the WEMWBS assessment a
 * user takes on the Mental Health Application.
 *
 * Author : Ashley Black
 *
 *****************************************************************************
 */
public class Assessment {

    /**
     * score: the result a user receives once they have finished taking the
     * WEMWBS assessment.
     */
    private int score;

    /**
     * date: the date that a user takes the WEMWBS assessment.
     */
    private Calendar date;
    
    /**
     * Assessment constructor only with the score as the paramiter
     * @param score 
     */
    public Assessment(int score){
        this.score = score;
    }

    /**
     * @description constructor for the Assessment class.
     *
     * @param score
     * @param date
     *
     */
    public Assessment(int score, Calendar date) {

        this.score = score;
        this.date = date;

    }

    /**
     * @return the score
     */
    public int getScore() {

        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {

        this.score = score;
    }

    /**
     * @return the date
     */
    public Calendar getDate() {

        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {

        this.date = date;
    }
}
