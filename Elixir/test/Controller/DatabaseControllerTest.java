/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Activity;
import Model.Assessment;
import Model.Goal;
import Model.Group;
import Model.Mood;
import Model.MoodTypes;
import Model.Profile;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyklos
 */
public class DatabaseControllerTest {
    
    public DatabaseControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of attemptClose method, of class DatabaseController.
     */
    @Test
    public void testAttemptClose_ResultSet() {
        System.out.println("attemptClose");
        ResultSet o = null;
        DatabaseController.attemptClose(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attemptClose method, of class DatabaseController.
     */
    @Test
    public void testAttemptClose_Statement() {
        System.out.println("attemptClose");
        Statement o = null;
        DatabaseController.attemptClose(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attemptClose method, of class DatabaseController.
     */
    @Test
    public void testAttemptClose_Connection() {
        System.out.println("attemptClose");
        Connection o = null;
        DatabaseController.attemptClose(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserToDb method, of class DatabaseController.
     */
    @Test
    public void testAddUserToDb() {
        System.out.println("addUserToDb");
        User user = null;
        DatabaseController.addUserToDb(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class DatabaseController.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "";
        boolean expResult = false;
        boolean result = DatabaseController.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class DatabaseController.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String fieldName = "";
        String dataToUpdate = "";
        String username = "";
        DatabaseController.updateUser(fieldName, dataToUpdate, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectUser method, of class DatabaseController.
     */
    @Test
    public void testSelectUser() {
        System.out.println("selectUser");
        String username = "";
        User expResult = null;
        User result = DatabaseController.selectUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddUser method, of class DatabaseController.
     */
    @Test
    public void testAddUser() {
        System.out.println("AddUser");
        User user = null;
        DatabaseController.AddUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUsername method, of class DatabaseController.
     */
    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "";
        User expResult = null;
        User result = DatabaseController.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUsername method, of class DatabaseController.
     */
    @Test
    public void testUpdateUsername() {
        System.out.println("updateUsername");
        String username = "";
        String newUsername = "";
        DatabaseController.updateUsername(username, newUsername);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFirstName method, of class DatabaseController.
     */
    @Test
    public void testUpdateFirstName() {
        System.out.println("updateFirstName");
        String username = "";
        String newFirstName = "";
        DatabaseController.updateFirstName(username, newFirstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSurname method, of class DatabaseController.
     */
    @Test
    public void testUpdateSurname() {
        System.out.println("updateSurname");
        String username = "";
        String newSurname = "";
        DatabaseController.updateSurname(username, newSurname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmail method, of class DatabaseController.
     */
    @Test
    public void testUpdateEmail() {
        System.out.println("updateEmail");
        String username = "";
        String newEmail = "";
        DatabaseController.updateEmail(username, newEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class DatabaseController.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        String username = "";
        String newPassword = "";
        DatabaseController.updatePassword(username, newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasswordForLogin method, of class DatabaseController.
     */
    @Test
    public void testGetPasswordForLogin() {
        System.out.println("getPasswordForLogin");
        String username = "";
        String expResult = "";
        String result = DatabaseController.getPasswordForLogin(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserDetails method, of class DatabaseController.
     */
    @Test
    public void testGetUserDetails() {
        System.out.println("getUserDetails");
        String field = "";
        String username = "";
        String expResult = "";
        String result = DatabaseController.getUserDetails(field, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class DatabaseController.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String username = "";
        DatabaseController.deleteUser(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMoodEntry method, of class DatabaseController.
     */
    @Test
    public void testAddMoodEntry() {
        System.out.println("addMoodEntry");
        String username = "";
        Mood mood = null;
        DatabaseController.addMoodEntry(username, mood);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserMoodsAsList method, of class DatabaseController.
     */
    @Test
    public void testGetUserMoodsAsList() {
        System.out.println("getUserMoodsAsList");
        String username = "";
        List<Mood> expResult = null;
        List<Mood> result = DatabaseController.getUserMoodsAsList(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoodsBetweenDates method, of class DatabaseController.
     */
    @Test
    public void testGetMoodsBetweenDates() {
        System.out.println("getMoodsBetweenDates");
        String username = "";
        Calendar start = null;
        Calendar end = null;
        List<Mood> expResult = null;
        List<Mood> result = DatabaseController.getMoodsBetweenDates(username, start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMoodTable method, of class DatabaseController.
     */
    @Test
    public void testUpdateMoodTable() {
        System.out.println("updateMoodTable");
        String username = "";
        Calendar date = null;
        String fieldName = "";
        String dataToUpdate = "";
        DatabaseController.updateMoodTable(username, date, fieldName, dataToUpdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMoodType method, of class DatabaseController.
     */
    @Test
    public void testUpdateMoodType() {
        System.out.println("updateMoodType");
        String username = "";
        MoodTypes moodType = null;
        Calendar date = null;
        DatabaseController.updateMoodType(username, moodType, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateNotes method, of class DatabaseController.
     */
    @Test
    public void testUpdateNotes() {
        System.out.println("updateNotes");
        String username = "";
        String notes = "";
        Calendar date = null;
        DatabaseController.updateNotes(username, notes, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllMoods method, of class DatabaseController.
     */
    @Test
    public void testDeleteAllMoods() {
        System.out.println("deleteAllMoods");
        String username = "";
        DatabaseController.deleteAllMoods(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAssessmentEntry method, of class DatabaseController.
     */
    @Test
    public void testAddAssessmentEntry() {
        System.out.println("addAssessmentEntry");
        Assessment entry = null;
        String username = "";
        DatabaseController.addAssessmentEntry(entry, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAssessmentsForUser method, of class DatabaseController.
     */
    @Test
    public void testGetAllAssessmentsForUser() {
        System.out.println("getAllAssessmentsForUser");
        String username = "";
        List<Assessment> expResult = null;
        List<Assessment> result = DatabaseController.getAllAssessmentsForUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addActivityEntry method, of class DatabaseController.
     */
    @Test
    public void testAddActivityEntry() {
        System.out.println("addActivityEntry");
        Activity entry = null;
        int goal_id = 0;
        DatabaseController.addActivityEntry(entry, goal_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllActivitiesForGoal method, of class DatabaseController.
     */
    @Test
    public void testGetAllActivitiesForGoal() {
        System.out.println("getAllActivitiesForGoal");
        int goal_id = 0;
        List<Activity> expResult = null;
        List<Activity> result = DatabaseController.getAllActivitiesForGoal(goal_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGoalEntry method, of class DatabaseController.
     */
    @Test
    public void testAddGoalEntry() {
        System.out.println("addGoalEntry");
        Goal entry = null;
        String username = "";
        DatabaseController.addGoalEntry(entry, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGoalsForUser method, of class DatabaseController.
     */
    @Test
    public void testGetAllGoalsForUser() {
        System.out.println("getAllGoalsForUser");
        String username = "";
        List<Goal> expResult = null;
        List<Goal> result = DatabaseController.getAllGoalsForUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalID method, of class DatabaseController.
     */
    @Test
    public void testGetGoalID() {
        System.out.println("getGoalID");
        String descritpion = "";
        String username = "";
        int expResult = 0;
        int result = DatabaseController.getGoalID(descritpion, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGoal method, of class DatabaseController.
     */
    @Test
    public void testDeleteGoal() {
        System.out.println("deleteGoal");
        Goal entry = null;
        String username = "";
        DatabaseController.deleteGoal(entry, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGroup method, of class DatabaseController.
     */
    @Test
    public void testAddGroup() {
        System.out.println("addGroup");
        Group group = null;
        DatabaseController.addGroup(group);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGroups method, of class DatabaseController.
     */
    @Test
    public void testGetAllGroups() {
        System.out.println("getAllGroups");
        List<Group> expResult = null;
        List<Group> result = DatabaseController.getAllGroups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGroupsThatBelongToUser method, of class DatabaseController.
     */
    @Test
    public void testGetAllGroupsThatBelongToUser() {
        System.out.println("getAllGroupsThatBelongToUser");
        String username = "";
        List<Group> expResult = null;
        List<Group> result = DatabaseController.getAllGroupsThatBelongToUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alreadyGroup method, of class DatabaseController.
     */
    @Test
    public void testAlreadyGroup() {
        System.out.println("alreadyGroup");
        String groupName = "";
        boolean expResult = false;
        boolean result = DatabaseController.alreadyGroup(groupName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserToGroup method, of class DatabaseController.
     */
    @Test
    public void testAddUserToGroup() {
        System.out.println("addUserToGroup");
        String username = "";
        String groupName = "";
        DatabaseController.addUserToGroup(username, groupName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGroupsThatTheUserIsPartOf method, of class DatabaseController.
     */
    @Test
    public void testGetAllGroupsThatTheUserIsPartOf() {
        System.out.println("getAllGroupsThatTheUserIsPartOf");
        String username = "";
        List<Group> expResult = null;
        List<Group> result = DatabaseController.getAllGroupsThatTheUserIsPartOf(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOwnGroup method, of class DatabaseController.
     */
    @Test
    public void testDeleteOwnGroup() {
        System.out.println("deleteOwnGroup");
        Group entry = null;
        DatabaseController.deleteOwnGroup(entry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePartOfGroup method, of class DatabaseController.
     */
    @Test
    public void testDeletePartOfGroup() {
        System.out.println("deletePartOfGroup");
        Group entry = null;
        String username = "";
        DatabaseController.deletePartOfGroup(entry, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserProfile method, of class DatabaseController.
     */
    @Test
    public void testGetUserProfile() {
        System.out.println("getUserProfile");
        String username = "";
        Profile expResult = null;
        Profile result = DatabaseController.getUserProfile(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DatabaseController.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DatabaseController.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
