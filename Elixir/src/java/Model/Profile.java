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
     * Method to remove goal specified. Truth 
     * @param goal
     * @return 
     */
    public boolean removeGoal(Goal goal){
       return this.goal.remove(goal);
    }
    

}
