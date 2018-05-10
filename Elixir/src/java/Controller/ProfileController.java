/*****************************************************************************

File        : ProfileController.java

Date        : 11-Mar-2018

Description : A class for dealing with a user's profile. This involves dealing
              with all aspects of the profile, goals, assessments, groups etc.   

Author      : Ashley Black

******************************************************************************/

package Controller;

import Model.Goal;
import Model.Mood;
import Model.MoodTypes;
import Model.Profile;
import Model.Assessment;
import Model.Group;
import Model.Activity;
import java.util.Date;
import java.util.List;

public class ProfileController {
    
    private Profile profile;
    
    public ProfileController(Profile profile) {
        
        this.profile = profile;
    }
    
    /**
     * @return the list of goals for the user
     */
    public List<Goal> getGoals() {
        
        return profile.getGoal();   
    }
    
    /**
     * @return the list of moods for the user
     */
    public List<Mood> getMoods() {
        
        return profile.getMood();
    }
    
    /**
     * @return the list of assessments for the user
     */
    public List<Assessment> getAssessments() {
        
        return profile.getAssessment();
    }
    
    /**
     * @return the list of groups for the user
     */
    public List<Group> getGroups() {
        
        return profile.getGroup();
    }
    
    /**
     * @param activities
     * 
     * Description: creates a new goal from the list of activities entered as a
     *              param, before adding this goal to the profile
     */
    public void addGoal(List<Activity> activities) {
        
        Goal goal = new Goal(activities);
        
        this.profile.addGoal(goal);
    }
    
    /**
     * @param goal
     * 
     * Description: removes the specified goal from the profile
     */
    public void removeGoal(Goal goal) {
        
        this.profile.removeGoal(goal);
    }
    
    /**
     * @param moodtype, date
     * 
     * Description: Takes the moodType and date to create a new mood, before 
     *              adding this to the profile
     */
    public void addMood(MoodTypes moodType, Date date) {
        
        Mood mood = new Mood(moodType, date);
        
        this.profile.addMood(mood);
    }
    
    /**
     * @param mood
     * 
     * Description: removes the specified mood from the profile
     */
    public void removeMood(Mood mood) {
        
        this.profile.removeMood(mood);
    }
    
    /**
     * @param score, date
     * 
     * Description: Takes the score and date to create a new assessment, before 
     *              adding this to the profile
     */
    public void addAssessment(int score, Date date) {
        
        Assessment assessment = new Assessment(score, date);
        
        this.profile.addAssessment(assessment);
    }
    
    /**
     * @param assessment
     * 
     * Description: removes the specified assessment from the profile
     */
    public void removeAssessment(Assessment assessment) {
        
        this.profile.removeAssessment(assessment);
    }
}
