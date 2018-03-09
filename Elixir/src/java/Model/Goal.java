package Model;

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
    private Date targerDate; //date by which user wants to complete their activities
    private boolean completionStatus = false; //tracks the status of the goal false by default. 
    
    /**
     * Constructor that will allow the user to create a goal with one or 
     * multiple goals and set a target date by which they should be able 
     * to complete self assigned activities
     * @param activities list containing activities user selected
     * @param targerDate date object which will represent user deadline
     */
    public Goal(List<Activity> activities, Date targerDate) {
        this.activities = activities;
        this.targerDate = targerDate;
    }
    
    /**
     * Similar constructor to the one above. However, this one does 
     * not require a date object.
     * @param activities 
     */
    public Goal(List<Activity> activities){
        this.activities = activities;
    }

    /**
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * @return the targerDate
     */
    public Date getTargerDate() {
        return targerDate;
    }

    /**
     * @param targerDate the targerDate to set
     */
    public void setTargerDate(Date targerDate) {
        this.targerDate = targerDate;
    }

    /**
     * @return the completionStatus
     */
    public boolean getCompletionStatus() {
        return completionStatus;
    }
    
    /**
     * Method that will set completeion status to true when called
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
    public void removeTargerDate(){
        this.targerDate = null;
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
    
    
}
