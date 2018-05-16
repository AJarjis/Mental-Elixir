/*****************************************************************************

File        : GoalController.java

Date        : 11-Mar-2018

Description : A class for dealing with a user's goal/s on their profile

Author      : Ashley Black

******************************************************************************/

package Controller;

import Model.Goal;
import Model.Activity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GoalController {
    
    private Goal goal;
    
    /**
     * GoalController constructor
     * @param goal 
     */
    public GoalController(Goal goal) {
        
        this.goal = goal;
    }
    
    /**
     * GoalController constructor that constructs a goal object within it
     * @param description 
     */
    public GoalController(String description){
        this.goal = new Goal(description);
    }
    
    /**
     * Method to return the goal object stored in the controller
     * @return 
     */
    public Goal getGoal(){
        return this.goal;
    }
    
    /**
     * @return the list of activities for the specified goal
     */
    public List<Activity> getActivities() {
        
        return goal.getActivities();
    }
    
    
    /**
     * @return the date for the specified goal
     */
    public Calendar getTargetDate() {
        
        return goal.getTargetDate();
    }
    
    /**
     * @return the completionStatus for the specified goal
     */
    public Boolean getCompletionStatus() {
        
        return goal.getCompletionStatus();
    }
    
    /**
     * Get the goal description
     * @return 
     */
    public String getDescription(){
        return this.goal.getDescription();
    }
    
    /**
     * @param activity
     * 
     * Description: adds an activity to the goal in question
     */
    public void addActivity(Activity activity) {
        
        this.goal.addActivity(activity);
    }
    
    /**
     * @param activity
     * 
     * Description: removes an activity to the goal in question
     */
    public void removeActivity(Activity activity) {
        
        this.goal.removeActivity(activity);
    }
    
    /**
     * @param activity
     * 
     * Description: completes the activity for the specified goal
     */
    public void completeGoal(Activity activity) {
        
        this.goal.completeGoal();
    }
    
    /**
     * Method to set the goal object of the controller
     * @param goal 
     */
    public void setGoal(Goal goal){
        this.goal = goal;
    }
    
    /**
     * @param date
     * 
     * Description: sets the target date for the goal in question
     */
    public void setTargetDate(Calendar date) {
        
        this.goal.setTargetDate(date);
    }
    
    /**
     * @param status
     * 
     * Description: sets the completionStatus for the goal in question
     */
    public void setCompletionStatus(Boolean status) {
        
        this.goal.setCompletionStatus(status);
    }
    
    /**
     * Sets the description for the goal
     * @param desc 
     */
    public void setDescription(String desc){
        this.goal.setDescription(desc);
    }
    
    /**
     * Description: removes the target date for the goal in question
     */
    public void removeTargetDate() {
        
        this.goal.removeTargetDate();
    }
}

