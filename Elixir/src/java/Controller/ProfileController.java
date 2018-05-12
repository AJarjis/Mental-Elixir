/*****************************************************************************

File        : ProfileController.java

Date        : 11-Mar-2018

Description : A class for dealing with a user's profile. This involves dealing
              with all aspects of the profile, goals, assessments, groups etc.   

Author      : Ashley Black & Daniel Carey

******************************************************************************/

package Controller;

import Model.Goal;
import Model.Mood;
import Model.MoodTypes;
import Model.Profile;
import Model.Assessment;
import Model.Group;
import Model.Activity;
import Model.User;
import java.util.Date;
import java.util.List;

public class ProfileController {
    
    private Profile profile;
    
    /**
     * Method that creates an empty profile
     * useful to retrieve data from database 
     * @param user
     */
    public ProfileController(User user){
        this.profile = new Profile(user);
    }
    
    /**
     * Used to create a profile controller
     * @param profile 
     */
    public ProfileController(Profile profile) {
        
        this.profile = profile;
    }
    
    public User getUser(){
        return this.profile.getUser();
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
     * Method to set the user for the profile
     * @param user user object
     */
    public void setUser(User user){
        this.profile.setUser(user);
    }
    
    /**
     * Method to set goals for the profile
     * @param goal list of goals 
     */
    public void setGoals(List<Goal> goal){
        this.profile.setGoal(goal);
    }
    
    /**
     * Method to set the moods for the profile
     * @param mood list of moods
     */
    public void setMoods(List<Mood> mood){
        this.profile.setMood(mood);
    }
    
    /**
     * Method to set the assessments for the profile
     * @param assessment list of assessments
     */
    public void setAssessments(List<Assessment> assessment){
        this.profile.setAssessment(assessment);
    }
    
    /**
     * Method to set the groups for the profile
     * @param group 
     */
    public void setGroups(List<Group> group){
        this.profile.setGroup(group);
    }
    
    /**
     * @param activities
     * 
     * Description: creates a new goal from the list of activities entered as a
     *              param, before adding this goal to the profile
     */
    public void addGoal(List<Activity> activities, String description) {
        
        Goal goal = new Goal(activities, description);
        
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
     * @param moodType
     * 
     * Description: Takes the moodType and date to create a new mood, before 
     *              adding this to the profile
     */
    public void addMood(MoodTypes moodType) {
        
        Mood mood = new Mood(moodType);
        
        
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
     * @param date
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
