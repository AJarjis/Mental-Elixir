package Model;

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
    private MoodTypes moodType;

    /**
     * notes: any comments or thoughts the user would like to write which goes
     * along with their mood post.
     */
    private String notes;

    /**
     * date: the date the user selects when they post their mood.
     */
    private Date date;

    /**
     * @description constructor for the Mood without any notes being entered.
     * @param moodType
     * @param date
     *
     */
    public Mood(MoodTypes moodType, Date date) {

        this.moodType = moodType;
        this.date = date;

    }
    
    /**
     * Creates a new mood for addition into database. Useful when the user 
     * is making an entry into their profile
     * @param moodType 
     */
    public Mood(MoodTypes moodType){
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
    public Mood(MoodTypes moodType, Date date, String notes) {

        this.moodType = moodType;
        this.date = date;
        this.notes = notes;

    }

    /**
     * @return the moodType
     */
    public MoodTypes getMoodType() {
        
        return moodType;
    }

    /**
     * @param moodType the moodType to set
     */
    public void setMoodType(MoodTypes moodType) {
        
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
    public Date getDate() {
        
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        
        this.date = date;
    }
    
    /**
     * Method to return mood info for debug
     * @return 
     */
    @Override
    public String toString(){
        return "Mood: " + this.moodType.convertToString() 
                + "\nDate: " + (this.date != null ? this.date.toString() : "N/A") 
                + "\nNotes: " + (this.notes != null ? this.notes : "N/A")
                + "\n";
    }

}
