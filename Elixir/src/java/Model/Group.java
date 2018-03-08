package Model;

import java.util.List;

/*****************************************************************************

File        : Group.java

Date        : 06-Mar-2018

Description : A class 

Author      : Daniel Carey

******************************************************************************/

public class Group {
    private String groupName;
    private String description;
    private User creator;
    private List<User> members;

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
     * @return the members
     */
    public List<User> getMembers() {
        return members;
    }
    
    
}
