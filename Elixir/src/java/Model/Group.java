package Model;

import java.util.List;

/*****************************************************************************

File        : Group.java

Date        : 07-Mar-2018

Description : A class that will allow the user to create and manipulate
*             the properties of his/her group.

Author      : Daniel Carey

******************************************************************************/

public class Group {
    private String groupName; //holds the name of the group that user assigns
    private String description;//holds description of the group made by user
    private User creator; //holds user object that made this group
    private List<User> members; //holds list of members that belong to this group

    /**
     * Constructor that will create a group by user
     * @param groupName
     * @param description
     * @param creator
     * @param members 
     */
    public Group(String groupName, String description, User creator, List<User> members) {
        this.groupName = groupName;
        this.description = description;
        this.creator = creator;
        this.members = members;
    }

    /**
     * Method to create a group without members
     * @param groupName
     * @param description
     * @param creator 
     */
    public Group(String groupName, String description, User creator){
        this.groupName = groupName;
        this.description = description;
        this.creator = creator;
    }
    
    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
     * @return the creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }
    
    /**
     * Method to set all the members
     * @param members 
     */
    public void setMembers(List<User> members){
        this.members = members;
    }

    /**
     * @return the members
     */
    public List<User> getMembers() {
        return members;
    }
    
    /**
     * Method that will allow the user to add members to the list 
     * @param user 
     */
    public void addMember(User user){
        this.members.add(user);
    }
    
    /**
     * Method that will remove the user from the member list. 
     * Will return true if the member has been removed successfully.
     * False otherwise.
     * @param user
     * @return 
     */
    public boolean removeMember(User user){
        return this.members.remove(user);
    }
    
    @Override
    public String toString(){
        return "\nGroup Name: " + this.groupName
                + "\nGroup Description: " + this.description
                + "\nGroup Leader: " + this.creator.getUserName() + "\n";
    }
    
    /**
     * Method that should allow the user to share group with other users
     * Need more clarifications on the vision on this.
     * @param email 
     */
//    public void shareGroup(Email email){
//        //Needs to be developed later
//    }
}
