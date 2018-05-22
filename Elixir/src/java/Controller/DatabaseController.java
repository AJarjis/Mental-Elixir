/** ***************************************************************************
 *
 * File        : DatabaseController.java
 *
 * Date        : 5-May-2018
 *
 * Description : A class that connects the views to the database class
 *
 * Author      : Daniel Carey
 *
 ***************************************************************************** */
package Controller;

import Model.Activity;
import Model.ActivityTypes;
import Model.Assessment;
import Model.Goal;
import Model.Group;
import Model.Mood;
import Model.MoodTypes;
import Model.Profile;
import Model.User;
import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;

public class DatabaseController {

    private static final String URL 
            = "jdbc:postgresql://elixir-ver2.postgres"
            + ".database.azure.com:5432/postgres";
    private static final String USER = "elixir@elixir-ver2";
    private static final String PASS = "Softeng1221";
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    private static ComboPooledDataSource pool;
    /**
     * Start of the Pooled connection initialization
     */
    static{
        try {
            pool = new ComboPooledDataSource();
            pool.setDriverClass("org.postgresql.Driver"); //loads the jdbc driver
            pool.setJdbcUrl(URL);
            pool.setUser(USER);   
            pool.setPassword(PASS);
            pool.setMaxPoolSize(10);
            pool.setMinPoolSize(1);
            System.out.println("STUFF IN STATIC");
        } catch (PropertyVetoException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * ********************BASIC DATABASE COMMANDS***************************
     */
    /**
     * Method to close result set
     * @param o 
     */
    static void attemptClose(ResultSet o)
    {
	try
	    { if (o != null) o.close();}
	catch (SQLException e){ 
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to close statement
     * @param o 
     */
    static void attemptClose(Statement o)
    {
	try
	    { if (o != null) o.close();}
	catch (SQLException e){ 
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to close connection
     * @param o 
     */
    static void attemptClose(Connection o)
    {
	try
	    { if (o != null) o.close();}
	catch (SQLException e){ 
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * ********************ACCOUNT DATABASE COMMANDS**************************
     */
    /**
     * Method used to add a user to the SQL server
     *
     * @param user object
     */
    public static void addUserToDb(User user) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO account VALUES(?,?,?,?,?)");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
        
    }

    /**
     * Method to check if the username passed in has an account associated with
     * it in the database
     * @param username
     * @return true if account does not exist false if it does
     */
    public static boolean checkUsername(String username) {
        boolean chk = true;
        stmt = null;
        rs = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT username FROM account WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                chk = false;
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(rs);
            attemptClose(stmt);
        }
        return chk;
    }

    /**
     * Method used to update records concerning the account table in SQL. Will
     * be used as utility method
     *
     * @param fieldName SQL field name for the table account
     * @param dataToUpdate new data to be used in SQL
     * @param username
     */
    public static void updateUser(String fieldName, 
            String dataToUpdate, String username) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("UPDATE account SET ? = ? WHERE username = ?");
            stmt.setString(1, fieldName);
            stmt.setString(2, dataToUpdate);
            stmt.setString(3, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     *
     * Method that will allow retrieval of the user information. This will then
     * go into a user object which will be returned for further processing
     *
     * @param username unique string that allows to you to find the user details
     * on the SQL server
     * @return user object that is filled in
     */
    public static User selectUser(String username) {
        User user = null;
        stmt = null;
        conn = null;
        ResultSet rsTemp = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM account WHERE username = ?");
            stmt.setString(1, username);
            rsTemp = stmt.executeQuery();
            while (rsTemp.next()) {
                String usrName = rsTemp.getString("Username");
                String firstName = rsTemp.getString("FirstName");
                String surname = rsTemp.getString("Surname");
                String email = rsTemp.getString("email");
                String password = rsTemp.getString("password");
                user = new User(usrName, firstName, surname, email, password);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rsTemp);
        }
        return user;
    }

    /**
     * Method used to add User to the database
     *
     * @param user object
     */
    public static void AddUser(User user) {
        addUserToDb(user);
    }

    /**
     * Method that returns a user object from the database based on the username
     * that was inserted NEEDS MORE WORK ON ERROR DETECTION
     *
     * @param username
     * @return USER object
     */
    public static User getUserByUsername(String username) {
        return selectUser(username);
    }

    /**
     * Method used to update the username SHOULD NOT BE ACCESABLE TO USER!
     *
     * @param username
     * @param newUsername
     */
    public static void updateUsername(String username, String newUsername) {
        updateUser("username", newUsername, username);
    }

    /**
     * Method used to update the user's firstname on database
     *
     * @param username
     * @param newFirstName
     */
    public static void updateFirstName(String username, String newFirstName) {
        updateUser("firstname", newFirstName, username);
    }

    /**
     * Method to update the surname of a user on the database
     *
     * @param username
     * @param newSurname
     */
    public static void updateSurname(String username, String newSurname) {
        updateUser("surname", newSurname, username);
    }

    /**
     * Method to update the email of a user on the database
     *
     * @param username
     * @param newEmail
     */
    public static void updateEmail(String username, String newEmail) {
        updateUser("email", newEmail, username);
    }

    /**
     * Method used to update the password that belongs to the user Use with
     * caution MAYBE KEEP PASSWORD CHANGES TO ONE SPECIFIC CLASS
     *
     * @param username
     * @param newPassword
     */
    public static void updatePassword(String username, String newPassword) {
        updateUser("password", newPassword, username);
    }

    /**
     * Method that returns hashed password that is stored in the database for
     * login verification
     *
     * @param username
     * @return
     */
    public static String getPasswordForLogin(String username) {
        return getUserDetails("password", username);
    }

    /**
     * Get any of the user details that are present in the account table of SQL
     *
     * @param field
     * @param username
     * @return
     */
    public static String getUserDetails(String field, String username) {
        String userDetails = null;
        stmt = null;
        rs = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM account WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                userDetails = rs.getString(field);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return userDetails;
    }
    
    /**
     * Method that deletes an account that is associated with the username 
     * passed. The delete will delete all the records that are associated with 
     * the account deleted.
     * @param username 
     */
    public static void deleteUser(String username){
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("DELETE FROM account WHERE username = ?");
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * ********************MOOD DATABASE COMMANDS***************************
     */
    /**
     * Method used to add new mood entries to the database
     *
     * @param username
     * @param mood
     */
    public static void addMoodEntry(String username, Mood mood) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO mood (mood_id," +
"                + moodtype, notes, date, username)" +
"                + VALUES (DEFAULT , ?, ?, DEFAULT , ?)");
            stmt.setInt(1, mood.getMoodType());
            stmt.setString(2, mood.getNotes());
            stmt.setString(3, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Method that allows to get all the moods entries that are related to the
     * username passed in
     *
     * @param username String username
     * @return
     */
    public static List<Mood> getUserMoodsAsList(String username) {
        stmt = null;
        rs = null;
        conn = null;
        List<Mood> moodList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM mood WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int mood = rs.getInt("moodtype");
                String notes = rs.getString("notes");
                Calendar stamp = Calendar.getInstance();
                stamp.setTimeInMillis(rs.getTimestamp("date").getTime());
                Mood temp = new Mood(mood, stamp, notes);
                moodList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return moodList;
    }
    
    /**
     * Allows retrieval of moods for a user between said dates
     * @param username
     * @param start
     * @param end
     * @return 
     */
    public static List<Mood> getMoodsBetweenDates(String username, 
            Calendar start, Calendar end){
        stmt = null;
        rs = null;
        conn = null;
        List<Mood> moodList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM mood WHERE username= ? "
                    + "AND date BETWEEN ? AND ?");
            stmt.setString(1, username);
            Date d1 = new java.sql.Date(start.getTimeInMillis());
            Date d2 = new java.sql.Date(end.getTimeInMillis());
            stmt.setDate(2, d1);
            stmt.setDate(3, d2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int mood = rs.getInt("moodtype");
                String notes = rs.getString("notes");
                Calendar stamp = Calendar.getInstance();
                stamp.setTimeInMillis(rs.getTimestamp("date").getTime());
                Mood temp = new Mood(mood, stamp, notes);
                moodList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return moodList;
    }

    /**
     * WIP MORE NEEDED AFTER FURTHER TESTING. SHOULD THE USER BE ABLE TO UPDATE
     * THEIR MOODS? General method used to update mood data on the database
     *
     * @param username
     * @param date
     * @param fieldName
     * @param dataToUpdate
     */
    public static void updateMoodTable(String username, Calendar date,
            String fieldName, String dataToUpdate) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("UPDATE mood SET ? = ? WHERE username = ? AND date = ?");
            stmt.setString(1, fieldName);
            stmt.setString(2, dataToUpdate);
            stmt.setString(3, username);
            stmt.setDate(4, new java.sql.Date(date.getTimeInMillis()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Method that lets a mood type to be modified
     * @param username
     * @param moodType 
     * @param date 
     */
    public static void updateMoodType(String username, MoodTypes moodType, Calendar date) {
        updateMoodTable(username, date,"moodtype", moodType.toString());
    }

    /**
     * Method that allows notes of a mood entry to be modified
     * @param username
     * @param notes 
     * @param date 
     */
    public static void updateNotes(String username, String notes, Calendar date) {
        updateMoodTable(username, date, "notes", notes);
    }
    /**
     * Method that allows all moods logged for a user to be deleted
     * @param username 
     */
     public static void deleteAllMoods(String username){
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("DELET FROM  mood WHERE username = ?");
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
     }
    
    /**
     * *******************ASSESSMENT DATABASE COMMANDS************************
     */
    /**
     * Method to add new assessment entries to the database
     *
     * @param entry
     * @param username
     */
    public static void addAssessmentEntry(Assessment entry, String username) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO assessment (assessment_id, "
                    + "score, date, username) VALUES (DEFAULT , ?, DEFAULT , ?)");
            stmt.setInt(1, entry.getScore());
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }
    /**
     * Method to retrieve all assessments that are stored on the database
     * for the desired user
     * @param username
     * @return 
     */
    public static List<Assessment> getAllAssessmentsForUser(String username) {
        stmt = null;
        rs = null;
        conn = null;
        List<Assessment> assessmentList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM assessment WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int score = rs.getInt("score");
                Calendar stamp = Calendar.getInstance();
                stamp.setTimeInMillis(rs.getTimestamp("date").getTime());
                Assessment temp = new Assessment(score, stamp);
                assessmentList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(rs);
            attemptClose(stmt);
        }
        return assessmentList;
    }

    /**
     * *********************ACTIVITY DATABASE COMMANDS************************
     */
    /**
     * Method used to add a new activity entry to the databse using the username
     *
     * @param entry
     * @param goal_id
     */
    public static void addActivityEntry(Activity entry, int goal_id) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO activity (activity_id, "
                    + "activitytype, description, completionstatus, goal_id) "
                    + "VALUES (DEFAULT, ?, ?, DEFAULT , ?)");
            stmt.setString(1, entry.getActivityType().convertToString());
            stmt.setString(2, entry.getDescription());
            stmt.setInt(3, goal_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Method used to retrieve all the activities for a goal. Utility method
     * used within retrieval of the goals
     *
     * @param goal_id
     * @return
     */
    public static List<Activity> getAllActivitiesForGoal(int goal_id) {
        stmt = null;
        ResultSet rsTemp = null;
        conn = null;
        List<Activity> activityList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM activity WHERE goal_id = ?");
            stmt.setInt(1, goal_id);
            rsTemp = stmt.executeQuery();
            while (rsTemp.next()) {
                ActivityTypes actType = ActivityTypes.convertToActivityType(rsTemp.getString("activitytype"));
                String description = rsTemp.getString("description");
                boolean stat = rsTemp.getBoolean("completionstatus");
                Activity temp = new Activity(actType, description, stat);
                activityList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rsTemp);
        }
        return activityList;
    }

    /**
     * *********************GOAL DATABASE COMMANDS************************
     */
    /**
     * Method used to add a goal entry to the database
     *
     * @param entry
     * @param username
     */
    public static void addGoalEntry(Goal entry, String username) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            if (entry.getTargetDate() == null) {
            stmt = conn.prepareStatement("INSERT INTO goal (completion_status, target_date, description, username)"
                + "VALUES  (DEFAULT , DEFAULT, ?, ?)");
            stmt.setString(1, entry.getDescription());
            stmt.setString(2, username);
            } else {
            stmt = conn.prepareStatement("INSERT INTO goal (completion_status, target_date, description, username)"
                + "VALUES  (DEFAULT , ?, ?, ?)");
            stmt.setDate(1, new java.sql.Date(entry.getTargetDate().getTimeInMillis()));
            stmt.setString(2, entry.getDescription());
            stmt.setString(3, username);
        }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Used to retrieve goals that the user has
     *
     * @param username
     * @return
     */
    public static List<Goal> getAllGoalsForUser(String username) {
        stmt = null;
        rs = null;
        conn = null;
        List<Goal> goalList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM goal WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            Calendar date = Calendar.getInstance();
            while (rs.next()) {
                int goal_id = rs.getInt("goal_id");
                boolean stat = rs.getBoolean("completion_status");
                if (rs.getTimestamp("target_date") == null) {
                    date = null;
                } else {
                    date.setTime(rs.getTimestamp("target_date"));
                }
                String description = rs.getString("description");
                List<Activity> aList = 
                        DatabaseController.getAllActivitiesForGoal(goal_id);
                Goal temp = new Goal(stat, date, description, aList);
                goalList.add(temp);
                date = Calendar.getInstance();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return goalList;
    }

    /**
     * Method used to retrieve goal ID useful for setting activities for goals
     *
     * @param descritpion
     * @param username
     * @return
     */
    public static int getGoalID(String descritpion, String username) {
        stmt = null;
        rs = null;
        conn = null;
        int goalID = -1;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT goal_id FROM goal WHERE description = ? AND username = ?");
            stmt.setString(1, descritpion);
            stmt.setString(2, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                goalID = rs.getInt("goal_id");
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        if (goalID < 0) {
            System.err.println("ERROR NO GOAL ID FOUND");
            return goalID;
        } else {
            return goalID;
        }
    }
    
    /**
     * Method that allows a goal entry to be deleted from the database
     * @param entry
     * @param username 
     */
    public static void deleteGoal(Goal entry, String username){
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("DELETE FROM goal WHERE goal_id = ?");
            stmt.setInt(1, getGoalID(entry.getDescription(), username));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * *********************GROUP DATABASE COMMANDS************************
     */
    /**
     * Method to add group to the database
     *
     * @param group
     */
    public static void addGroup(Group group) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO trackergroup (groupname, description, ownerusername) "
                + "VALUES (?, ?, ?)");
            stmt.setString(1, group.getGroupName());
            stmt.setString(2, group.getDescription());
            stmt.setString(3, group.getCreator().getUserName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Method used to retrieve all the groups from the database
     *
     * @return list of groups
     */
    public static List<Group> getAllGroups() {
        stmt = null;
        rs = null;
        conn = null;
        List<Group> groupList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM trackergroup");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupname");
                String description = rs.getString("description");
                String username = rs.getString("ownerusername");
                User tempUsr = selectUser(username);
                Group tempGroup = new Group(groupName, description, tempUsr);
                groupList.add(tempGroup);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return groupList;
    }

    /**
     * Method used to get all the groups that belong to the user
     *
     * @param username
     * @return list of groups
     */
    public static List<Group> getAllGroupsThatBelongToUser(String username) {
        stmt = null;
        rs = null;
        conn = null;
        List<Group> groupList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM trackergroup "
                    + "WHERE ownerusername = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupname");
                String description = rs.getString("description");
                User tempUsr = selectUser(username);
                Group tempGroup = new Group(groupName, description, tempUsr);
                groupList.add(tempGroup);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return groupList;
    }
    /**
     * Checks if a group already exists
     * @param groupName
     * @return false if group doesn't exist, true if it does.
     */
    public static boolean alreadyGroup(String groupName) {
        List<Group> groupList = getAllGroups();
        for(Group group : groupList)
        {
            if(group.getGroupName().equals(groupName))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method used to add user to the an existing group
     *
     * @param username
     * @param groupName
     */
    public static void addUserToGroup(String username, String groupName) {
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("INSERT INTO usergroup "
                + "(username, groupname) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, groupName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * Method that returns a list of groups that the user is part of
     *
     * @param username
     * @return list of groups
     */
    public static List<Group> getAllGroupsThatTheUserIsPartOf(String username) {
        stmt = null;
        rs = null;
        conn = null;
        List<Group> groupList = new LinkedList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("SELECT tg.groupname, tg.description, "
                    + "tg.ownerusername FROM trackergroup AS tg\n"
                    + "INNER JOIN usergroup u on tg.groupname = u.groupname\n"
                    + "WHERE u.username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupname");
                String description = rs.getString("description");
                User tempUsr = selectUser(username);
                Group tempGroup = new Group(groupName, description, tempUsr);
                groupList.add(tempGroup);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            attemptClose(conn);
            attemptClose(stmt);
            attemptClose(rs);
        }
        return groupList;
    }
    
    /**
     * Method that allows the deletion of any user owned group/s
     * @param entry 
     */
    public static void deleteOwnGroup(Group entry){
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("DELETE FROM trackergroup WHERE groupname = ?");
            stmt.setString(1, entry.getGroupName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }
    
    /**
     * Method that allows deletion of a group that the user is part of
     * @param entry
     * @param username 
     */
    public static void deletePartOfGroup(Group entry, String username){
        stmt = null;
        conn = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement("DELETE FROM usergroup WHERE groupname = ?"
                + "AND username = ?");
            stmt.setString(1, entry.getGroupName());
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally{
            attemptClose(conn);
            attemptClose(stmt);
        }
    }

    /**
     * *********************PROFILE CREATION*********************************
     */
    /**
     * Method used to create a profile from data gathered from Database
     *
     * @param username
     * @return
     */
    public static Profile getUserProfile(String username) {
        List<Goal> goalsTemp = DatabaseController.
                getAllGoalsForUser(username);
        List<Mood> moodsTemp = DatabaseController.
                getUserMoodsAsList(username);
        List<Assessment> asmtTemp = DatabaseController.
                getAllAssessmentsForUser(username);
        List<Group> ownedGroupsTemp = DatabaseController.
                getAllGroupsThatBelongToUser(username);
        List<Group> partOfGroupsTemp = DatabaseController.
                getAllGroupsThatTheUserIsPartOf(username);


        Profile existingProfile
                = new Profile(goalsTemp, moodsTemp, asmtTemp,
                        ownedGroupsTemp, partOfGroupsTemp);
        return existingProfile;
    }

    public static void main(String[] args) {
//        Assessment test = new Assessment(5);
//        DatabaseController.addAssessmentEntry(test, "SecondTest");
//        List<Mood> mood = DatabaseController.getUserMoodsAsList("FirstRec");
//        List<Assessment> assmt = DatabaseController
//                .getAllAssessmentsForUser("SecondTest");
//        Activity test = new Activity(Love, "do good for others");
//        DatabaseController.addActivityEntry(test, 1);
//        List<Activity> act = DatabaseController.getAllActivitiesForGoal(1);
//        Goal goal = new Goal("Do well");
//        DatabaseController.addGoalEntry(goal, "FirstRec");

//        User bestUsr = new User();
//        bestUsr.setUserName("SecondTest");
//        Group groupTest = new Group("other Cool GHuys", "This group is better than the cool guys", bestUsr);
//        DatabaseController.addGroup(groupTest);
//        List<Group> testGroup = DatabaseController.getAllGroups();
//        List<Group> testUserGroups = DatabaseController
//                .getAllGroupsThatBelongToUser("FirstRec");
//        DatabaseController.addUserToGroup("FirstRec", "other Cool GHuys");
//        List<Group> testPartOfGroups = DatabaseController
//                .getAllGroupsThatTheUserIsPartOf("FirstRec");
//        System.out.println("GoalID: " + DatabaseController
//                .getGoalID("Improve general wellbeing", "FirstRec"));
//          List<Goal> testGoal = DatabaseController.getAllGoalsForUser("IronMan");
//        System.out.println("GROUP LIST:\n" + testGroup);
//        System.out.println("GROUP LIST:\n" + testUserGroups);
//        System.out.println("MOOD LIST:\n" + mood.toString());
//        System.out.println("ASSESSMENT LIST: " + assmt.toString());
//        System.out.println("ACT LIST:\n " + act.toString());
//        System.out.println("GOAL LIST: \n" + testGoal.toString());
//        System.out.println("PART OF GROUPS: \n" + testPartOfGroups);
//          for (Goal g : testGoal) {
//              System.out.println("Desc: " + g.getDescription() + " Date: " + g.getTargetDate().getTime().toString());
//        }
        List<Mood> moods = new LinkedList<>();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2018, 4, 10);
        end.set(2018, 6, 1);
        moods = DatabaseController.getMoodsBetweenDates("john", start, end);
    }
}
