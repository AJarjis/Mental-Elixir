/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class ActivityTest {
    
    public ActivityTest() {
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
     * Test of getActivityType method, of class Activity.
     */
    @Test
    public void testGetActivityType() {
        System.out.println("getActivityType");
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        ActivityTypes expResult = ActivityTypes.Mind;
        ActivityTypes result = instance.getActivityType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivityType method, of class Activity.
     */
    @Test
    public void testSetActivityType() {
        System.out.println("setActivityType");
        ActivityTypes activityType = ActivityTypes.Body;
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        instance.setActivityType(activityType);
        assertEquals(instance.getActivityType(), ActivityTypes.Body);
    }

    /**
     * Test of getDescription method, of class Activity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        String expResult = "Testing";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Activity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "TestingNew";
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        instance.setDescription(description);
        assertEquals(instance.getDescription(), description);
    }

    /**
     * Test of isCompletionStatus method, of class Activity.
     */
    @Test
    public void testIsCompletionStatus() {
        System.out.println("isCompletionStatus");
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        boolean expResult = false;
        boolean result = instance.isCompletionStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompletionStatus method, of class Activity.
     */
    @Test
    public void testSetCompletionStatus() {
        System.out.println("setCompletionStatus");
        boolean completionStatus = true;
        Activity instance = new Activity(ActivityTypes.Mind, "Testing");
        instance.setCompletionStatus(completionStatus);
        assertEquals(instance.isCompletionStatus(), completionStatus);
    }
    
}
