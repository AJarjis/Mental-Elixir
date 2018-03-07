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
    private User user;
    private List<Goal> goal;
    private List<Mood> mood;
    private List<Assessment> assessment;
    private List<Group> group;

    /**
     * @return the goal
     */
    public List<Goal> getGoal() {
        return goal;
    }

    /**
     * @return the mood
     */
    public List<Mood> getMood() {
        return mood;
    }

    /**
     * @return the assessment
     */
    public List<Assessment> getAssessment() {
        return assessment;
    }

    /**
     * @return the group
     */
    public List<Group> getGroup() {
        return group;
    }
    /**
     * Method to add a goal to the list of goals
     * @param goal object you wish to add to the list
     */
    public void addGoal(Goal goal){
        this.goal.add(goal);
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
     * Removes an assessment object from the assessment list.
     * @param assessment object to remove from list.
     * @return true if found & removed.
     */
    public boolean removeAssessment(Assessment assessment)
    {
        return this.assessment.remove(assessment);
    }
    
    /**
     * Adds a group to user's list of groups
     * @param group object to be added
     */
    public void addGroup(Group group)
    {
        this.group.add(group);
    }
    
    /**
     * removes a group from user's group list
     * @param group object to be removed
     * @return true if object found and removed.
     */
    public boolean removeGroup(Group group)
    {
        return this.group.remove(group);
    }

}
