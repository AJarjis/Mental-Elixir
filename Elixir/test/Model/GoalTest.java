/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;
import java.util.LinkedList;
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
public class GoalTest {
    
    public GoalTest() {
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
     * Test of getActivities method, of class Goal.
     */
    @Test
    public void testGetActivities() {
        System.out.println("getActivities");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Goal instance = new Goal(actList, "some stuff");
        List<Activity> expResult = actList;
        List<Activity> result = instance.getActivities();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTargetDate method, of class Goal.
     */
    @Test
    public void testGetTargetDate() {
        System.out.println("getTargetDate");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        Calendar expResult = date;
        Calendar result = instance.getTargetDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTargetDate method, of class Goal.
     */
    @Test
    public void testSetTargetDate() {
        System.out.println("setTargetDate");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        Calendar date2 = Calendar.getInstance();
        date.set(2022, 06, 06, 5, 15, 10);
        instance.setTargetDate(date2);
        assertEquals(instance.getTargetDate(), date2);
    }

    /**
     * Test of setDescription method, of class Goal.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String desc = "Test desc";
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        instance.setDescription(desc);
        assertEquals(instance.getDescription(), desc);
    }

    /**
     * Test of getCompletionStatus method, of class Goal.
     */
    @Test
    public void testGetCompletionStatus() {
        System.out.println("getCompletionStatus");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        boolean expResult = false;
        boolean result = instance.getCompletionStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Goal.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        String expResult = "No description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of completeGoal method, of class Goal.
     */
    @Test
    public void testCompleteGoal() {
        System.out.println("completeGoal");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        instance.completeGoal();
        assertEquals(instance.getCompletionStatus(), true);
    }

    /**
     * Test of setCompletionStatus method, of class Goal.
     */
    @Test
    public void testSetCompletionStatus() {
        System.out.println("setCompletionStatus");
        boolean completionStatus = true;
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        instance.setCompletionStatus(completionStatus);
        assertEquals(instance.getCompletionStatus(), completionStatus);
    }

    /**
     * Test of addActivity method, of class Goal.
     */
    @Test
    public void testAddActivity() {
        System.out.println("addActivity");
        Activity activity = new Activity(ActivityTypes.Mind, "cool relaxed stuff");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        instance.addActivity(activity);
        assertTrue(actList.contains(activity));
    }

    /**
     * Test of removeTargetDate method, of class Goal.
     */
    @Test
    public void testRemoveTargetDate() {
        System.out.println("removeTargetDate");
        Activity activity = new Activity(ActivityTypes.Mind, "cool relaxed stuff");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        instance.removeTargetDate();
        assertNull(instance.getTargetDate());
    }

    /**
     * Test of removeActivity method, of class Goal.
     */
    @Test
    public void testRemoveActivity() {
        System.out.println("removeActivity");
        Activity activity = new Activity(ActivityTypes.Mind, "cool relaxed stuff");
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList = new LinkedList<>();
        actList.add(act1);
        actList.add(act2);
        actList.add(activity);
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Goal instance = new Goal(actList, date);
        boolean expResult = true;
        boolean result = instance.removeActivity(activity);
        assertEquals(expResult, result);
    }  
}
