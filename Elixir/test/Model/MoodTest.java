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
        Mood instance = new Mood(5, date, "was good");
        int expResult = 5;
        int result = instance.getMoodType();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMoodType method, of class Mood.
     */
    @Test
    public void testSetMoodType() {
        System.out.println("setMoodType");
        int moodType = 2;
        Calendar date = Calendar.getInstance();
        date.set(2018, 6, 12, 12, 12, 12);
        Mood instance = new Mood(5, date, "was good");
        instance.setMoodType(moodType);
        assertEquals(instance.getMoodType(), moodType);
    }

    /**
     * Test of getNotes method, of class Mood.
     */
    @Test
    public void testGetNotes() {
        System.out.println("getNotes");
        Calendar date = Calendar.getInstance();
        date.set(2018, 6, 12, 12, 12, 12);
        Mood instance = new Mood(5, date, "was good");
        String expResult = "was good";
        String result = instance.getNotes();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNotes method, of class Mood.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String notes = "okok";
        Calendar date = Calendar.getInstance();
        date.set(2018, 6, 12, 12, 12, 12);
        Mood instance = new Mood(5, date, "was good");
        instance.setNotes(notes);
        assertEquals(instance.getNotes(), notes);
    }

    /**
     * Test of getDate method, of class Mood.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Calendar date = Calendar.getInstance();
        date.set(2018, 6, 12, 12, 12, 12);
        Mood instance = new Mood(5, date, "was good");
        Calendar expResult = date;
        Calendar result = instance.getDate();
        assertEquals(expResult, result);
    }
}
