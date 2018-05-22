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
public class AssessmentTest {
    
    public AssessmentTest() {
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
     * Test of getScore method, of class Assessment.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06);
        Assessment instance = new Assessment(14, date);
        int expResult = 14;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScore method, of class Assessment.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 5;
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06);
        Assessment instance = new Assessment(14, date);
        instance.setScore(score);
        assertEquals(instance.getScore(), score);
    }

    /**
     * Test of getDate method, of class Assessment.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Assessment instance = new Assessment(14, date);
        Calendar date2 = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Calendar expResult = date;
        Calendar result = instance.getDate();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDate method, of class Assessment.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Calendar date = Calendar.getInstance();
        date.set(2018, 06, 06, 5, 15, 10);
        Assessment instance = new Assessment(14, date);
        Calendar date2 = Calendar.getInstance();
        date.set(2018, 06, 07, 10, 15, 10);
        instance.setDate(date2);
        assertEquals(instance.getDate(), date2);
    }
    
}
