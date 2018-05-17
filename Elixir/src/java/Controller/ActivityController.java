/*****************************************************************************

File        : ActivityController.java

Date        : 11-Mar-2018

Description : A class for dealing with a user's activity/ies on their profile

Author      : Ashley Black

******************************************************************************/

package Controller;

import Model.Activity;
import Model.ActivityTypes;

public class ActivityController {
    
    private Activity activity;

    public ActivityController(Activity activity){
        
       this.activity = activity;
    }
    
    /**
     * Activity controller constructor with a constructor for activity object
     * @param activity
     * @param description 
     */
    public ActivityController(ActivityTypes activity, String description){
        this.activity = new Activity(activity, description);
    }
    
    /**
     * @return the activityType
     */
    public ActivityTypes getActivityType() {
        
        return activity.getActivityType();
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        
        return activity.getDescription();
    }
    
    /**
     * @return the completionStatus
     */
    public Boolean getCompletionStatus() {
        
        return activity.isCompletionStatus();
    }
    
    /**
     * Method to return the current activity stored in the controller
     * @return 
     */
    public Activity getActivity(){
        return this.activity;
    }
    
    /**
     * @param activityType
     * 
     * Description: Sets the activityType for the activity in question to the
     *              param given
     */
    public void setActivityType(ActivityTypes activityType) {
        
        this.activity.setActivityType(activityType);
    }
    
    /**
     * @param description
     * 
     * Description: Sets the description for the activity in question to the
     *              param given
     */
    public void setDescription(String description) {
        
        this.activity.setDescription(description);
    }
    
    /**
     * Method to set activity object that is currently stored in the controller
     * @param activity 
     */
    public void setActivity(Activity activity){
        this.activity = activity;
    }
    
    /**
     * @param status
     * 
     * Description: Sets the completionStatus for the activity in question to 
     *              the param given
     */
    public void setCompletionStatus(Boolean status) {
        
        this.activity.setCompletionStatus(status);
    }
    
    public static void createActivity(ActivityTypes activityType, 
                                                          String description) {     
        
    }

}
