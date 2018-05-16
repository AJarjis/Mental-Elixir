package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*****************************************************************************

File        : Goal.java

Date        : 08-Mar-2018

Description : A class that will allow users or groups to create and manipulate 
*             their goals.

Author      : Daniel Carey

******************************************************************************/


public class Goal {

    private List<Activity> activities; //activities that user will commit to
    private Calendar targetDate; //date by which user wants to complete their activities
    private boolean completionStatus = false; //tracks the status of the goal false by default. 
    private String description; // gives basic description of the goal
    //TODO: complete activity method neeeds to be implemented
    /**
     * Constructor that will allow the user to create a goal with one or 
     * multiple goals and set a target date by which they should be able 
     * to complete self assigned activities
     * @param activities list containing activities user selected
     * @param targetDate date object which will represent user deadline
     */
    public Goal(List<Activity> activities, Calendar targetDate) {
        this.activities = activities;
        this.targetDate = targetDate;
    }
    
    /**
     * Similar constructor to the one above. However, this one does 
     * not require a date object.
     * @param activities 
     * @param description 
     */
    public Goal(List<Activity> activities, String description){
        this.activities = activities;
        this.description = description;
    }
    
    /**
     * Goal constructor only requiering a description
     * @param description 
     */
    public Goal(String description){
        this.description = description;
    }
    
    /**
     * Constructor for Goal used for Database retrieval
     * @param stat
     * @param date
     * @param desc 
     */
    public Goal(boolean stat, Calendar date, String desc){
        this.completionStatus = stat;
        this.targetDate = date;
        this.description = desc;
    }

    /**
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * @return the targetDate
     */
    public Calendar getTargetDate() {
        return targetDate;
    }

    /**
     * @param targetDate the targetDate to set
     */
    public void setTargetDate(Calendar targetDate) {
        this.targetDate = targetDate;
    }
    
    /**
     * 
     * @param desc new description to set
     */
    public void setDescription(String desc){
        this.description = desc;
    }

    /**
     * @return the completionStatus
     */
    public boolean getCompletionStatus() {
        return this.completionStatus;
    }
    
    /**
     * Gets the description of the goal
     * @return 
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * Method that will set completion status to true when called
     */
    public void completeGoal(){
        this.completionStatus = true;
    }

    /**
     * @param completionStatus the completionStatus to set
     */
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
    
    /**
     * method that will allow the user to add activity to their current 
     * goal
     * @param activity 
     */
    public void addActivity(Activity activity){
        this.activities.add(activity);
    }
    
    /**
     * method that allows the user to remove a target date
     */
    public void removeTargetDate(){
        this.targetDate = null;
    }
    
    /**
     * method that will allow the user to remove an acivity from thier goal
     * @param activity
     * @return 
     */
    public boolean removeActivity(Activity activity){
        return this.activities.remove(activity);
    }
    
    /**
     * Not sure what this method needs to do. More clarification needed.
     * @param user 
     */
   public void recommendGoal(User user){
       //Not entiery sure what needs to be here0
   }  
   
    @Override
   public String toString(){
       String date = "";
       if(this.targetDate == null)
       {
           date = "null";
       }else{
           date = this.targetDate.toString();
        } 
       return "\nGoal Description: " + this.description
               + "\n Target Date: " +  date
               + "\n Completion Stat: " + this.completionStatus;
   }
    
    
}
