/** ***************************************************************************
 *
 * File        : GroupController.java
 *
 * Date        : 18-Apr-2018
 *
 * Description : A class that will connect the views and the Mood model class
 * together.  *
 * Author      : Kieran Woodcock
 *
 ***************************************************************************** */
package Controller;

import Model.Group;
import Model.User;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupController {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
                    Pattern.CASE_INSENSITIVE);

    private Group group;

    public GroupController(Group group) {
        this.group = group;
    }

    /**
     *
     * @return groupName as a string
     */
    public String getGroupName() {
        return group.getGroupName();
    }

    /**
     *
     * @return Group description as a string
     */
    public String getDescription() {
        return group.getDescription();
    }

    /**
     *
     * @return returns the User that created the group
     */
    public User getCreator() {
        return group.getCreator();
    }

    /**
     *
     * @return 
     * @ returns a list of all members in a group
     */
    public List<User> getMembers() {
        return group.getMembers();
    }

    /**
     *
     * @param groupName Group Name as a String
     */
    public void setGroupName(String groupName) {
        group.setGroupName(groupName);
    }

    /**
     *
     * @param description Group description as a String
     */
    public void setDescription(String description) {
        group.setDescription(description);
    }

    /**
     *
     * @param user Member of group as a User object
     */
    public void addMember(User user) {
        group.addMember(user);
    }

    /**
     *
     * @param user Member of group as a User object
     * @return True if removed, false otherwise.
     */
    public boolean removeMember(User user) {
        return group.removeMember(user);
    }

    /**
     *
     * @param email Email in format of string
     * @return True if group shared, false otherwise
     */
    public boolean shareGroup(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        if(matcher.find())
        {
            //Send a link to join group to the email address
            return true;
        }
        else
            return false;
    }
    
    /**
     *
     * @param groupName Group name as a string
     * @param description Group description as a string
     * @param creator creator of the group as a User object.
     * @return the created group.
     */
    public Group createGroup(String groupName, String description, User creator)
    {
        group.setGroupName(groupName);
        group.setDescription(description);
        group.setCreator(creator);
        return group;
    }
}
