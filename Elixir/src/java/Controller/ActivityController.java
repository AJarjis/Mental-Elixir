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
