package Model;

import java.util.Calendar;
import java.util.Date;

/**
 * ***************************************************************************
 *
 * File : Mood.java
 *
 * Date : 06-Mar-2018
 *
 * Description : Code for class Mood. This class is based upon a user entering
 * a mood along with the date an optional notes.
 *
 * Author : Ashley Black
 *
 *****************************************************************************
 */

public class Mood {

    /**
     * moodType: the mood that a user selects when they wish to post an update.
     */
    private int moodType;

    /**
     * notes: any comments or thoughts the user would like to write which goes
     * along with their mood post.
     */
    private String notes;

    /**
     * date: the date the user selects when they post their mood.
     */
    private Calendar date;

    /**
     * @description constructor for the Mood without any notes being entered.
     * @param moodType
     * @param date
     *
     */
    public Mood(int moodType, Calendar date) {

        this.moodType = moodType;
        this.date = date;

    }
    
    /**
     * Creates a new mood for addition into database. Useful when the user 
     * is making an entry into their profile
     * @param moodType 
     */
    public Mood(int moodType){
        this.moodType = moodType;
    }

    /**
     * @description constructor for the Mood with notes being entered.
     *
     * @param moodType
     * @param date
     * @param notes
     *
     */
    public Mood(int moodType, Calendar date, String notes) {

        this.moodType = moodType;
        this.date = date;
        this.notes = notes;

    }

    /**
     * @return the moodType
     */
    public int getMoodType() {
        
        return moodType;
    }

    /**
     * @param moodType the moodType to set
     */
    public void setMoodType(int moodType) {
        
        this.moodType = moodType;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        
        this.notes = notes;
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
