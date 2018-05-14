package Model;

import java.util.List;

/*****************************************************************************

File        : User.java

Date        : 06-Mar-2018

Description : This class represents the core of the backend. Goals, mood
              ,groups and assessments will be manipulated through this class.

Author      : Daniel Carey

******************************************************************************/

public class Profile {
    private List<Goal> goal;
    private List<Mood> mood;
    private List<Assessment> assessment;
    private List<Group> ownedGroups;
    private List<Group> partOfGroups;
    
    /**
     * Creates an empty profile
     */
    public Profile(){
        
    }
    
    /**
     * Method that creates a profile object with all properties populated
     * Used for population from database on login
     * @param goals list of goals
     * @param moods list of moods
     * @param assessments list of assessments
     * @param ownedGroups list of ownedGroups
     * @param partOfGroups list of groups the user is part of
     */
    public Profile(List<Goal> goals, List<Mood> moods, 
            List<Assessment> assessments, List<Group> ownedGroups,
            List<Group> partOfGroups){
        this.goal = goals;
        this.mood = moods;
        this.assessment = assessments;
        this.ownedGroups = ownedGroups;
        this.partOfGroups = partOfGroups;
    }
    
    /**
     * @return the goal
     */
    public List<Goal> getGoal() {
        return this.goal;
    }

    /**
     * @return the mood
     */
    public List<Mood> getMood() {
        return this.mood;
    }

    /**
     * @return the assessment
     */
    public List<Assessment> getAssessment() {
        return this.assessment;
    }

    /**
     * @return groups owned by the profile
     */
    public List<Group> getOwnedGroups() {
        return this.ownedGroups;
    }
    
    /**
     * 
     * @return groups that the profile is part of 
     */
    public List<Group> getPartOfGroups(){
        return this.partOfGroups;
    }
    
    /**
     * Method to add a goal to the list of goals
     * @param goal object you wish to add to the list
     */
    public void addGoal(Goal goal){
        this.goal.add(goal);
    }
    
    /**
     * Method to set the goal list to the one passed in as the argument
     * @param goal list of goals
     */
    public void setGoal(List<Goal> goal){
        this.goal = goal;
    }
    
    /**
     * Method to remove goal specified. 
     * @param goal
     * @return true if found and removed, false otherwise
     */
    public boolean removeGoal(Goal goal){
       return this.goal.remove(goal);
    }
    
    /**
     * Adds mood to list of moods
     * @param mood object for mood.
     */
    public void addMood(Mood mood)
    {
        this.mood.add(mood);
    }
    
    /**
     * Method to set the list stored in the profile to the one passed in as 
     * an argument
     * @param mood list of moods 
     */
    public void setMood(List<Mood> mood){
        this.mood = mood;
    }
    
    /**
     * Removed a mood object from the user's list.
     * @param mood object for mood
     * @return true if found and removed.
     */
    public boolean removeMood(Mood mood)
    {
        return this.mood.remove(mood);
    }
    
    /**
     * Adds Assessment object to list of Assessments.
     * @param assessment object for assessment.
     */
    public void addAssessment(Assessment assessment)
    {
        this.assessment.add(assessment);
    }
    
    /**
     * Method to set the assessment list to the one passed in as argument
     * @param assessment assessment list 
     */
    public void setAssessment(List<Assessment> assessment){
        this.assessment = assessment;
    }
    
    /**
     * Removes an assessment object from the assessment list.
     * @param assessment object to remove from list.
     * @return true if found & removed.
     */
    public boolean removeAssessment(Assessment assessment)
    {
        return this.assessment.remove(assessment);
    }
    
    /**
     * Adds a group to user's owned list of groups
     * @param group object to be added
     */
    public void addOwnedGroup(Group group)
    {
        this.ownedGroups.add(group);
    }
    
    /**
     * Method to set the groups owned by the user to the list passed in 
     * as argument
     * @param group group list
     */
    public void setOwnedGroups(List<Group> group){
        this.ownedGroups = group;
    }
    
    /**
     * Remove a group that the user owns
     * @param group object to be removed
     * @return true if object found and removed.
     */
    public boolean removeOwnedGroup(Group group)
    {
        return this.ownedGroups.remove(group);
    }
    
    /**
     * Adds user to be a part of a group
     * @param group group object
     */
    public void addPartOfGroup(Group group){
        this.partOfGroups.add(group);
    }
    
    /**
     * Sets the list of groups that the user is part of to the one passed 
     * in as an argument
     * @param group group object
     */
    public void setPartOfGroup(List<Group> group){
        this.partOfGroups = group;
    }
    
    /**
     * Removes the user from the group that they are part of
     * @param group group object
     * @return true if removed successfully false otherwise
     */
    public boolean removePartOfGroup(Group group){
        return this.partOfGroups.remove(group);
    }

}
