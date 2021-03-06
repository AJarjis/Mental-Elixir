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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProfileController {
    
    private Profile profile;
    
    /**
     * Method that creates an empty profile
     * useful to retrieve data from database 
     */
    public ProfileController(){

    }
    
//    /**
//     * Constructor to create new profile that is populated with data from 
//     * the SQL database
//     * @param user
//     * @param goals
//     * @param moods
//     * @param assessments
//     * @param ownedGroups
//     * @param partOfGroups 
//     */
//    public ProfileController(List<Goal> goals, List<Mood> moods, 
//            List<Assessment> assessments, List<Group> ownedGroups,
//            List<Group> partOfGroups){
//        this.profile = new Profile(goals, moods, assessments,
//        ownedGroups, partOfGroups);
//    }
    
    /**
     * Used to create a profile controller
     * @param profile 
     */
    public ProfileController(Profile profile) {
        
        this.profile = profile;
    }
    
    /**
     * Method to get the profile object stored in the controller
     * @return 
     */
    public Profile getProfile(){
        return this.profile;
    }
    
    /**
     * @return the list of goals for the user
     */
    public List<Goal> getGoals() {
        
        return this.profile.getGoal();   
    }
    
    /**
     * @return the list of moods for the user
     */
    public List<Mood> getMoods() {
        
        return this.profile.getMood();
    }
    
    /**
     * @return the list of assessments for the user
     */
    public List<Assessment> getAssessments() {
        
        return this.profile.getAssessment();
    }
    
    /**
     * @return the list of groups for the user
     */
    public List<Group> getOwnedGroups() {
        
        return this.profile.getOwnedGroups();
    }
    
    /**
     * 
     * @return list of groups the user is part of
     */
    public List<Group> getPartOfGroups(){
        return this.profile.getPartOfGroups();
    }
    
    /**
     * Set the profile object
     * @param profile 
     */
    public void setProfile(Profile profile){
        this.profile = profile;
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
     * Method to set the groups the user owns
     * @param group 
     */
    public void setOwnedGroups(List<Group> group){
        this.profile.setOwnedGroups(group);
    }
    
    /**
     * Method to set the groups the user is part of
     * @param group 
     */
    public void setPartOfGroups(List<Group> group){
        this.profile.setPartOfGroup(group);
    }
    
    /**
     * @param activities
     * 
     * Description: creates a new goal from the list of activities entered as a
     *              param, before adding this goal to the profile
     * @param description
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
     * @param mood
     * 
     * Description: Takes the mood creates a new mood, before 
     *              adding this to the profile
     */
    public void addMood(Mood mood) {
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
    public void addAssessment(int score, Calendar date) {
        
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
    
    /**
     * Removes the specified group that the user owns
     * @param group group object
     * @return true if successful false otherwise
     */
    public boolean removeOwnedGroup(Group group){
        return this.profile.removeOwnedGroup(group);
    }
    
    /**
     * Removes the user from the group that they are part of 
     * @param group group object
     * @return true if successful false otherwise
     */
    public boolean removePartOfGroup(Group group){
        return this.profile.removePartOfGroup(group);
    }
    
}
