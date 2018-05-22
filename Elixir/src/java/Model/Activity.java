package Model;

/**
 * ***************************************************************************
 *
 * File : Activity.java
 *
 * Date : 06-Mar-2018
 *
 * Description : Code for class Activity. Enables the user to set an activity,
 * add a descripton and track whether the activity has been completed (true),
 * or whether the activity is still a work in progress (false).
 *
 * Author : Ashley Black
 *
 *****************************************************************************
 */

public class Activity {
    
    /**
    * activityType: the activity a user specifies they would like   
    * to attempt.
    */   
    private ActivityTypes activityType;
    
    /**
    * description: a description of the activity the user has selected.
    */
    private String description;
    
    /**
    * completionStatus: determines whether the activity in question has 
    * been completed (true) or not (false).
    */
    private boolean completionStatus = false;
    
    /**
     * @description constructor for Activity.
     *
     * @param activityType
     * @param description
     *
     */
    public Activity(ActivityTypes activityType, String description) {
             
        this.activityType     = activityType;  
        this.description      = description;
        this.completionStatus = false;
    }
    
    /**
     * Method used to create new activities, mostly used for database retrieval
     * @param activityType
     * @param description
     * @param stat 
     */
    public Activity(ActivityTypes activityType, String description, boolean stat) {
             
        this.activityType     = activityType;  
        this.description      = description;
        this.completionStatus = stat;
    }

    /**
     * @return the activityType
     */
    public ActivityTypes getActivityType() {
        
        return activityType;
    }

    /**
     * @param activityType the activityType to set
     */
    public void setActivityType(ActivityTypes activityType) {
        
        this.activityType = activityType;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        
        this.description = description;
    }

    /**
     * @return the completionStatus
     */
    public boolean isCompletionStatus() {
        
        return completionStatus;
    }

    /**
     * @param completionStatus the completionStatus to set
     */
    public void setCompletionStatus(boolean completionStatus) {
        
        this.completionStatus = completionStatus;
    }

}
