/** ***************************************************************************
 *
 * File        : MoodController.java
 *
 * Date        : 18-Apr-2018
 *
 * Description : A class that will connect the views and the Mood model class 
              together.
 * Author      : Kieran Woodcock
 *
 ***************************************************************************** */
package Controller;

import Model.Mood;
import Model.MoodTypes;
import java.util.Calendar;
import java.util.Date;

public class MoodController {

    private Mood mood;
    /**
     * 
     * @param mood Object for users mood; Type of mood, notes and date.
     */
    public MoodController(Mood mood) {
        this.mood = mood;
    }
    
    /**
     * Controller with creation of a mood object using a mood type
     * @param mood 
     */
    public MoodController(MoodTypes mood){
        this.mood = new Mood(mood);
    }
    
    /**
     * Retrieve the mood stored
     * @return 
     */
    public Mood getMood(){
        return this.mood;
    }
    
    /**
     * 
     * @return the moodType for the current object
     */
    public MoodTypes getMoodType() {
        return mood.getMoodType();
    }
    
    /**
     * 
     * @return the notes for the current object
     */
    public String getNotes() {
        return mood.getNotes();
    }
    
    /**
     *
     * @return the date for the current object
     */
    public Calendar getDate() {
        return mood.getDate();
    }
    
    public void setMood(Mood mood){
        this.mood = mood;
    }
    
    /**
     *
     * @param MoodType Enum specified in the MoodTypes Model Class
     */
    public void SetMoodType(MoodTypes MoodType) {
        mood.setMoodType(MoodType);
    }
    
    /**
     *
     * @param notes String that stores the notes of the mood.
     */
    public void setNotes(String notes) {
        mood.setNotes(notes);
    }
    
    /**
     *
     * @param date Date that the mood was created.
     */
    public void setDate(Calendar date) {
        mood.setDate(date);
    }
    
    public static void main(String[] args) {
        Mood testMood = new Mood(MoodTypes.Joy);
            MoodController moodContr = new MoodController(testMood);
    }
}
