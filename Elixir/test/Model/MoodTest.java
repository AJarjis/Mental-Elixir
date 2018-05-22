/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;
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
public class MoodTest {
    
    public MoodTest() {
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
     * Test of getMoodType method, of class Mood.
     */
    @Test
    public void testGetMoodType() {
        System.out.println("getMoodType");
        Calendar date = Calendar.getInstance();
        date.set(2018, 6, 12, 12, 12, 12);
        Mood instance = Mood(5, date, "was good");
        int expResult = 0;
        int result = instance.getMoodType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoodType method, of class Mood.
     */
    @Test
    public void testSetMoodType() {
        System.out.println("setMoodType");
        int moodType = 0;
        Mood instance = null;
        instance.setMoodType(moodType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotes method, of class Mood.
     */
    @Test
    public void testGetNotes() {
        System.out.println("getNotes");
        Mood instance = null;
        String expResult = "";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotes method, of class Mood.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String notes = "";
        Mood instance = null;
        instance.setNotes(notes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Mood.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Mood instance = null;
        Calendar expResult = null;
        Calendar result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Mood.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Calendar date = null;
        Mood instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
