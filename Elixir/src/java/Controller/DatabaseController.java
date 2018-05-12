/*****************************************************************************

File        : DatabaseController.java

Date        : 5-May-2018

Description : A class that connects the views to the database class

Author      : Daniel Carey

******************************************************************************/

package Controller;

import Model.Activity;
import Model.ActivityTypes;
import Model.Assessment;
import Model.Goal;
import Model.Mood;
import Model.MoodTypes;
import Model.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class DatabaseController {
    private static final String URL = "jdbc:postgresql://elixir-ver2.postgres.database.azure.com:5432/postgres";
    private static final String USER = "elixir@elixir-ver2";
    private static final String PASS = "Softeng1221";
    private static Connection conn = null;
    private static Statement  stmt = null;
    
    /**********************BASIC DATABASE COMMANDS****************************/
    /**
     * Method used to close the connection to the database and commit 
     * changes
     */
    public static void closeConnection(){
        try{
            conn.close();
            System.out.println("CONNECTION CLOSED.");
        }
        catch(SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    /**
     * Method to connect to the database
     */
    public static void connectToDatabase(){
        try {
            System.out.println("CONNECTING TO DATABASE..........");
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("CONNECTION OPENED");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    
    /**
     * Method that allows sending of the SQL statement to the server
     * @param command 
     */
    public static void execute(String command){
        stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(command);
            System.out.println("COMMAND HAS BEEN EXECUTED.");
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    /**********************ACCOUNT DATABASE COMMANDS***************************/
    /**
     * Method used to add a user to the SQL server
     * @param user object
     */
    public static void addUserToDb(User user){
        String command = String.format("INSERT INTO account VALUES('%s','%s','%s','%s','%s');"
                , user.getUserName(), user.getFirstName(), user.getSurname(), 
                user.getEmail(), user.getPassword());
        execute(command);
    }
    
    /**
     * Method used to update records concerning the account table in 
     * SQL. Will be used as utility method
     * @param fieldName SQL field name for the table account
     * @param dataToUpdate new data to be used in SQL
     * @param username
     */
    public static void updateUser(String fieldName, String dataToUpdate, String username){
        String command = String.format("UPDATE account SET %s = '%s' WHERE username = '%s'"
        , fieldName, dataToUpdate, username);
        execute(command);
    }
    
    /**
     * 
     * Method that will allow retrieval of the user information. This will then 
     * go into a user object which will be returned for further processing
     * @param username unique string that allows to you to find the user details
     * on the SQL server
     * @return user object that is filled in
     */
    public static User selectUser(String username){
        User user = null;
        stmt = null;
        try {
            stmt = conn.createStatement();
            String command = String.format
        ("SELECT * FROM account WHERE username ='%s'", username);
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                String usrName = rs.getString("Username");
                String firstName = rs.getString("FirstName");
                String surname = rs.getString("Surname");
                String email = rs.getString("email");
                String password = rs.getString("password");
            user = new User(usrName, firstName, surname, email, password);
            } 
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return user;
    }
    
    /**
     * Method used to add User to the database
     * @param user object
     */
    public static void AddUser(User user){
        addUserToDb(user);
    }
    
    /**
     * Method that returns a user object from the database based 
     * on the username that was inserted
     * NEEDS MORE WORK ON ERROR DETECTION
     * @param username 
     * @return  USER object
     */
    public static User getUserByUsername(String username){
        return selectUser(username);
    }
    
    /**
     * Method used to update the username SHOULD NOT BE ACCESABLE TO USER!
     * @param username
     * @param newUsername 
     */
    public static void updateUsername(String username, String newUsername){
        updateUser("username", newUsername, username);
    }
    
    /**
     * Method used to update the user's firstname on database
     * @param username
     * @param newFirstName 
     */
    public static void updateFirstName(String username, String newFirstName){
        updateUser("firstname", newFirstName, username);
    }
    
    /**
     * Method to update the surname of a user on the database
     * @param username
     * @param newSurname 
     */
    public static void updateSurname(String username, String newSurname){
        updateUser("surname", newSurname, username);
    }
    
    /**
     * Method to update the email of a user on the database
     * @param username
     * @param newEmail 
     */
    public static void updateEmail(String username, String newEmail){
        updateUser("email", newEmail, username);
    }
    
    /**
     * Method used to update the password that belongs to the user
     * Use with caution MAYBE KEEP PASSWORD CHANGES TO ONE SPECIFIC CLASS
     * @param username
     * @param newPassword 
     */
    public static void updatePassword(String username, String newPassword){
        updateUser("password", newPassword, username);
    }
    
    /**
     * Method that returns hashed password that is stored in the database
     * for login verification
     * @param username
     * @return 
     */
    public static String getPasswordForLogin(String username){
        return getUserDetails("password", username);
    }
    
    /**
     * Get any of the user details that are present in the account table 
     * of SQL
     * @param field
     * @param username
     * @return 
     */
    public static String getUserDetails(String field ,String username){
        String userDetails = null;
        stmt = null;
        try {
            stmt = conn.createStatement();
            String command = String.format
                ("SELECT %s FROM account WHERE username ='%s'",field,username);
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                userDetails = rs.getString(field);
            }
        } catch (SQLException e) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return userDetails;
    }
    /**********************MOOD DATABASE COMMANDS****************************/
    /**
     * Method used to add new mood entries to the database
     * @param username
     * @param mood 
     */
    public static void addMoodEntry(String username, Mood mood){
        String command = String.format("INSERT INTO mood (mood_id, moodtype, notes, date, username)"
                + "VALUES (DEFAULT , '%s', '%s', DEFAULT , '%s');", 
                mood.getMoodType().convertToString(), mood.getNotes(), username);
        execute(command);
    }
    
    /**
     * Method that allows to get all the moods entries that are related 
     * to the username passed in
     * @param username String username
     * @return 
     */
    public static List<Mood> getUserMoodsAsList(String username){
        stmt = null;
        List<Mood> moodList = new LinkedList<>();
        try {
            stmt = conn.createStatement();
            String command = String.format("SELECT * FROM mood WHERE username ="
                    + "'%s';", username);
            ResultSet rs = stmt.executeQuery(command);
            while(rs.next()){
                MoodTypes mood = MoodTypes.convertToMoodType(rs.getString("moodtype"));
                String notes = rs.getString("notes");
                Date stamp = new Date(rs.getTimestamp("date").getTime());
                Mood temp = new Mood(mood, stamp, notes);
                moodList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return moodList;
    }
    
    /**
     * WIP MORE NEEDED AFTER FURTHER TESTING. SHOULD THE USER BE ABLE TO 
     * UPDATE THEIR MOODS?
     * General method used to update mood data on the database
     * @param username
     * @param fieldName
     * @param dataToUpdate 
     */
    public static void updateMoodTable(String username, String fieldName, String dataToUpdate){
        String command = String.format("UPDATE mood SET %s = '%s' WHERE %s = '%s'"
        , fieldName, dataToUpdate, fieldName, username);
        execute(command);
    }
    
    public static void updateMoodType(String username, String moodType){
        updateMoodTable(username, "moodtype", moodType);
    }
    
    public static void updateNotes(String username, String notes){
        updateMoodTable(username, "notes", notes);
    }
    
    /*********************ASSESSMENT DATABASE COMMANDS*************************/
    
    /**
     * Method to add new assessment entries to the database
     * @param entry 
     * @param username 
     */
    public static void addAssessmentEntry(Assessment entry, String username){
        String command = String.format("INSERT INTO assessment (assessment_id, score, date, username)"
                + "VALUES (DEFAULT , '%d', DEFAULT , '%s');", 
                entry.getScore(), username);
        execute(command);
    }
    public static List<Assessment> getAllAssessmentsForUser(String username){
        stmt = null;
        List<Assessment> assessmentList = new LinkedList<>();
        try {
            stmt = conn.createStatement();
            String command = String.format("SELECT * FROM assessment "
                    + "WHERE username = '%s';", username);
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                int score = rs.getInt("score");
                Date stamp = new Date(rs.getTimestamp("date").getTime());
                Assessment temp = new Assessment(score, stamp);
                assessmentList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return assessmentList;
    }
    
    /***********************ACTIVITY DATABASE COMMANDS*************************/
    
    /**
     * Method used to add a new activity entry to the databse using 
     * the username
     * @param entry 
     * @param goal_id 
     */
    public static void addActivityEntry(Activity entry, int goal_id){
        String command = String.format
        ("INSERT INTO activity (activity_id, activitytype, "
                + "description, completionstatus, goal_id)" 
                +"VALUES (DEFAULT, '%s', '%s', DEFAULT , %d);", 
                entry.getActivityType().convertToString(), 
                entry.getDescription(), goal_id);
        execute(command);
    }
    
    /**
     * Method used to retrieve all the activities for a goal
     * @param goal_id
     * @return 
     */
    public static List<Activity> getAllActivitiesForGoal(Integer goal_id){
        stmt = null;
        List<Activity> activityList = new LinkedList<>();
        try {
            stmt = conn.createStatement();
            String command = String.format("SELECT * FROM activity "
                    + "WHERE goal_id = '%d';", goal_id);
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
                ActivityTypes actType = ActivityTypes.convertToMoodType(rs.getString("activityType"));
                String description = rs.getString("description");
                boolean stat = rs.getBoolean("completionstatus");
                Activity temp = new Activity(actType, description, stat);
                activityList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return activityList;
    }
    
    /***********************GOAL DATABASE COMMANDS*************************/
    
    /**
     * Method used to add a goal entry to the database
     * @param entry
     * @param username 
     */
    public static void addGoalEntry(Goal entry, String username){
        String command = "";
        if (entry.getTargetDate() == null) {
            command = String.format
        ("INSERT INTO goal (completion_status, target_date, description, username)" +
"    VALUES  (DEFAULT , %s, '%s', '%s');", 
                "DEFAULT", entry.getDescription(), username);
        } else{
            command = String.format
        ("INSERT INTO goal (completion_status, target_date, description, username)" +
"    VALUES  (DEFAULT , %d, '%s', '%s');", 
                entry.getTargetDate().getTime(), entry.getDescription(), username);
        }
        execute(command);
    }
            
    public static List<Goal> getAllGoalsForUser(String username){
         stmt = null;
        List<Goal> goalList = new LinkedList<>();
        try {
            stmt = conn.createStatement();
            String command = String.format("SELECT * FROM goal "
                    + "WHERE username = '%s';", username);
            ResultSet rs = stmt.executeQuery(command);
            Date date;
            while (rs.next()) {
                boolean stat = rs.getBoolean("completion_status");
                if (rs.getTimestamp("target_date") == null) {
                    date = null;
                } else{
                    date = new Date(rs.getTimestamp("target_date").getTime());
                }
                String description = rs.getString("description");
                Goal temp = new Goal(stat, date, description);
                goalList.add(temp);
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return goalList;
    }
            
            
    public static void main(String[] args) {
        DatabaseController.connectToDatabase();
//        Assessment test = new Assessment(5);
//        DatabaseController.addAssessmentEntry(test, "SecondTest");
//        List<Mood> mood = DatabaseController.getUserMoodsAsList("FirstRec");
//        List<Assessment> assmt = DatabaseController.getAllAssessmentsForUser("SecondTest");
//        Activity test = new Activity(Love, "do good for others");
//        DatabaseController.addActivityEntry(test, 1);
//        List<Activity> act = DatabaseController.getAllActivitiesForGoal(1);
//        Goal goal = new Goal("Do well");
//        DatabaseController.addGoalEntry(goal, "FirstRec");
        List<Goal> testGoal = DatabaseController.getAllGoalsForUser("FirstRec");
        DatabaseController.closeConnection();
//        System.out.println("MOOD LIST:\n" + mood.toString());
//        System.out.println("ASSESSMENT LIST: " + assmt.toString());
//        System.out.println("ACT LIST:\n " + act.toString());
        System.out.println("GOAL LIST: \n" + testGoal.toString());
    }
}
