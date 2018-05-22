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
public class ProfileTest {

    public ProfileTest() {
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

    public Profile setUpProfile() {
        List<Goal> goals = new LinkedList<>();
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList1 = new LinkedList<>();
        actList1.add(act1);
        actList1.add(act2);
        Calendar date1 = Calendar.getInstance();
        date1.set(2018, 06, 06, 5, 15, 10);
        Goal g1 = new Goal(actList1, date1);
        Activity act11 = new Activity(ActivityTypes.Body, "other cool stuff");
        Activity act22 = new Activity(ActivityTypes.Love, "other cool with love");
        List<Activity> actList2 = new LinkedList<>();
        actList2.add(act11);
        actList2.add(act22);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, 06, 06, 5, 15, 10);
        Goal g2 = new Goal(actList2, date2);
        goals.add(g1);
        goals.add(g2);

        List<Mood> moods = new LinkedList<>();
        Calendar date11 = Calendar.getInstance();
        date11.set(2018, 6, 12, 12, 12, 12);
        Mood m1 = new Mood(5, date11, "was good");
        Mood m2 = new Mood(2, date11, "was ok");
        moods.add(m1);
        moods.add(m2);

        List<Assessment> asmts = new LinkedList<>();
        Calendar date22 = Calendar.getInstance();
        date22.set(2018, 06, 06);
        Assessment a1 = new Assessment(14, date22);
        Calendar date33 = Calendar.getInstance();
        date33.set(2018, 06, 06);
        Assessment a2 = new Assessment(14, date33);
        asmts.add(a1);
        asmts.add(a2);

        List<Group> ownedGroups = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group group = new Group("cool group", "cool users only", u3, uList);
        ownedGroups.add(group);

        List<Group> partGroups = new LinkedList<>();
        User u11 = new User("OkGS", "foo", "doo", "noo@noo.com", "www");
        User u22 = new User("JoHs", "fitch", "mitch", "noo@go.com", "ewq");
        User u33 = new User("Grosh", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList2 = new LinkedList<>();
        uList2.add(u11);
        uList2.add(u22);
        Group group2 = new Group(" other cool group", " other cool users only", u33, uList2);
        partGroups.add(group2);

        Profile p = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        return p;
    }

    @Test
    public void testGetGoal() {
        List<Goal> goals = new LinkedList<>();
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList1 = new LinkedList<>();
        actList1.add(act1);
        actList1.add(act2);
        Calendar date1 = Calendar.getInstance();
        date1.set(2018, 06, 06, 5, 15, 10);
        Goal g1 = new Goal(actList1, date1);
        Activity act11 = new Activity(ActivityTypes.Body, "other cool stuff");
        Activity act22 = new Activity(ActivityTypes.Love, "other cool with love");
        List<Activity> actList2 = new LinkedList<>();
        actList2.add(act11);
        actList2.add(act22);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, 06, 06, 5, 15, 10);
        Goal g2 = new Goal(actList2, date2);
        goals.add(g1);
        goals.add(g2);

        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        System.out.println("getGoal");
        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        List<Goal> expResult = goals;
        List<Goal> result = instance.getGoal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMood method, of class Profile.
     */
    @Test
    public void testGetMood() {
        System.out.println("getMood");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        Calendar date11 = Calendar.getInstance();
        date11.set(2018, 6, 12, 12, 12, 12);
        Mood m1 = new Mood(5, date11, "was good");
        Mood m2 = new Mood(2, date11, "was ok");
        moods.add(m1);
        moods.add(m2);
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        List<Mood> expResult = moods;
        List<Mood> result = instance.getMood();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssessment method, of class Profile.
     */
    @Test
    public void testGetAssessment() {
        System.out.println("getAssessment");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        Calendar date22 = Calendar.getInstance();
        date22.set(2018, 06, 06);
        Assessment a1 = new Assessment(14, date22);
        Calendar date33 = Calendar.getInstance();
        date33.set(2018, 06, 06);
        Assessment a2 = new Assessment(14, date33);
        asmts.add(a1);
        asmts.add(a2);
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        List<Assessment> expResult = asmts;
        List<Assessment> result = instance.getAssessment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOwnedGroups method, of class Profile.
     */
    @Test
    public void testGetOwnedGroups() {
        System.out.println("getOwnedGroups");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group group = new Group("cool group", "cool users only", u3, uList);
        ownedGroups.add(group);
        List<Group> partGroups = new LinkedList<>();
        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        List<Group> expResult = ownedGroups;
        List<Group> result = instance.getOwnedGroups();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPartOfGroups method, of class Profile.
     */
    @Test
    public void testGetPartOfGroups() {
        System.out.println("getPartOfGroups");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();
        User u11 = new User("OkGS", "foo", "doo", "noo@noo.com", "www");
        User u22 = new User("JoHs", "fitch", "mitch", "noo@go.com", "ewq");
        User u33 = new User("Grosh", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList2 = new LinkedList<>();
        uList2.add(u11);
        uList2.add(u22);
        Group group2 = new Group(" other cool group", " other cool users only", u33, uList2);
        partGroups.add(group2);
        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        List<Group> expResult = partGroups;
        List<Group> result = instance.getPartOfGroups();
        assertEquals(expResult, result);

    }

    /**
     * Test of addGoal method, of class Profile.
     */
    @Test
    public void testAddGoal() {
        System.out.println("addGoal");
        Activity testAct = new Activity(ActivityTypes.Body, "cool stuff");
        Activity testAct2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actListTest = new LinkedList<>();
        actListTest.add(testAct);
        actListTest.add(testAct2);
        Calendar datetest = Calendar.getInstance();
        datetest.set(2018, 06, 06, 5, 15, 10);
        Goal goal = new Goal(actListTest, datetest);

        List<Goal> goals = new LinkedList<>();
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList1 = new LinkedList<>();
        actList1.add(act1);
        actList1.add(act2);
        Calendar date1 = Calendar.getInstance();
        date1.set(2018, 06, 06, 5, 15, 10);
        Goal g2 = new Goal(actList1, date1);
        Activity act11 = new Activity(ActivityTypes.Body, "other cool stuff");
        Activity act22 = new Activity(ActivityTypes.Love, "other cool with love");
        List<Activity> actList2 = new LinkedList<>();
        actList2.add(act11);
        actList2.add(act22);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, 06, 06, 5, 15, 10);
        Goal g3 = new Goal(actList2, date2);
        goals.add(g1);
        goals.add(g2);
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.addGoal(goal);

        assertTrue(instance.getGoal().contains(goal));
    }

    /**
     * Test of setGoal method, of class Profile.
     */
    @Test
    public void testSetGoal() {
        System.out.println("setGoal");
        List<Goal> goals2 = new LinkedList<>();
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList1 = new LinkedList<>();
        actList1.add(act1);
        actList1.add(act2);
        Calendar date1 = Calendar.getInstance();
        date1.set(2018, 06, 06, 5, 15, 10);
        Goal g1 = new Goal(actList1, date1);
        Activity act11 = new Activity(ActivityTypes.Body, "other cool stuff");
        Activity act22 = new Activity(ActivityTypes.Love, "other cool with love");
        List<Activity> actList2 = new LinkedList<>();
        actList2.add(act11);
        actList2.add(act22);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, 06, 06, 5, 15, 10);
        Goal g2 = new Goal(actList2, date2);
        goals2.add(g1);
        goals2.add(g2);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();
        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.setGoal(goals2);

        assertTrue(instance.getGoal().containsAll(goals2));
    }

    /**
     * Test of removeGoal method, of class Profile.
     */
    @Test
    public void testRemoveGoal() {
        System.out.println("removeGoal");
        List<Goal> goals = new LinkedList<>();
        Activity act1 = new Activity(ActivityTypes.Body, "cool stuff");
        Activity act2 = new Activity(ActivityTypes.Love, "cool with love");
        List<Activity> actList1 = new LinkedList<>();
        actList1.add(act1);
        actList1.add(act2);
        Calendar date1 = Calendar.getInstance();
        date1.set(2018, 06, 06, 5, 15, 10);
        Goal g1 = new Goal(actList1, date1);
        Activity act11 = new Activity(ActivityTypes.Body, "other cool stuff");
        Activity act22 = new Activity(ActivityTypes.Love, "other cool with love");
        List<Activity> actList2 = new LinkedList<>();
        actList2.add(act11);
        actList2.add(act22);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018, 06, 06, 5, 15, 10);
        Goal g2 = new Goal(actList2, date2);
        goals.add(g1);
        goals.add(g2);
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);

        boolean expResult = true;
        boolean result = instance.removeGoal(g1);
        assertEquals(expResult, result);

    }

    /**
     * Test of addMood method, of class Profile.
     */
    @Test
    public void testAddMood() {
        System.out.println("addMood");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        Calendar date11 = Calendar.getInstance();
        date11.set(2018, 6, 12, 12, 12, 12);
        Mood mood = new Mood(5, date11, "was good");
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.addMood(mood);

        assertTrue(instance.getMood().contains(mood));
    }

    /**
     * Test of setMood method, of class Profile.
     */
    @Test
    public void testSetMood() {
        System.out.println("setMood");
        List<Mood> moodTest = new LinkedList<>();
        Calendar date11 = Calendar.getInstance();
        date11.set(2018, 6, 12, 12, 12, 12);
        Mood m1 = new Mood(5, date11, "was good");
        Mood m2 = new Mood(2, date11, "was ok");
        moodTest.add(m1);
        moodTest.add(m2);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.setMood(moodTest);

        assertEquals(instance.getMood(), moodTest);
    }

    /**
     * Test of removeMood method, of class Profile.
     */
    @Test
    public void testRemoveMood() {
        System.out.println("removeMood");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        Calendar date11 = Calendar.getInstance();
        date11.set(2018, 6, 12, 12, 12, 12);
        Mood m1 = new Mood(5, date11, "was good");
        Mood m2 = new Mood(2, date11, "was ok");
        moods.add(m1);
        moods.add(m2);
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        boolean expResult = true;
        boolean result = instance.removeMood(m1);
        assertEquals(expResult, result);

    }

    /**
     * Test of addAssessment method, of class Profile.
     */
    @Test
    public void testAddAssessment() {
        System.out.println("addAssessment");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Calendar date22 = Calendar.getInstance();
        date22.set(2018, 06, 06);
        Assessment a1 = new Assessment(14, date22);

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.addAssessment(a1);
        assertTrue(instance.getAssessment().contains(a1));
    }

    /**
     * Test of setAssessment method, of class Profile.
     */
    @Test
    public void testSetAssessment() {
        System.out.println("setAssessment");
        List<Assessment> assessment = new LinkedList<>();
        Calendar date22 = Calendar.getInstance();
        date22.set(2018, 06, 06);
        Assessment a1 = new Assessment(14, date22);
        assessment.add(a1);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.setAssessment(assessment);

        assertEquals(instance.getAssessment(), assessment);
    }

    /**
     * Test of removeAssessment method, of class Profile.
     */
    @Test
    public void testRemoveAssessment() {
        System.out.println("removeAssessment");

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Calendar date22 = Calendar.getInstance();
        date22.set(2018, 06, 06);
        Assessment a1 = new Assessment(14, date22);
        asmts.add(a1);

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        boolean expResult = true;
        boolean result = instance.removeAssessment(a1);
        assertEquals(expResult, result);

    }

    /**
     * Test of addOwnedGroup method, of class Profile.
     */
    @Test
    public void testAddOwnedGroup() {
        System.out.println("addOwnedGroup");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group group = new Group("cool group", "cool users only", u3, uList);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.addOwnedGroup(group);

        assertTrue(instance.getOwnedGroups().contains(group));

    }

    /**
     * Test of setOwnedGroups method, of class Profile.
     */
    @Test
    public void testSetOwnedGroups() {
        System.out.println("setOwnedGroups");
        List<Group> group = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group g = new Group("cool group", "cool users only", u3, uList);
        group.add(g);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.setOwnedGroups(group);

        assertEquals(instance.getOwnedGroups(), group);
    }

    /**
     * Test of removeOwnedGroup method, of class Profile.
     */
    @Test
    public void testRemoveOwnedGroup() {
        System.out.println("removeOwnedGroup");

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group g = new Group("cool group", "cool users only", u3, uList);
        ownedGroups.add(g);
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        boolean expResult = true;
        boolean result = instance.removeOwnedGroup(g);
        assertEquals(expResult, result);

    }

    /**
     * Test of addPartOfGroup method, of class Profile.
     */
    @Test
    public void testAddPartOfGroup() {
        System.out.println("addPartOfGroup");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group group = new Group("cool group", "cool users only", u3, uList);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.addPartOfGroup(group);

        assertTrue(instance.getPartOfGroups().contains(group));
    }

    /**
     * Test of setPartOfGroup method, of class Profile.
     */
    @Test
    public void testSetPartOfGroup() {
        System.out.println("setPartOfGroup");
        List<Group> group = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group g = new Group("cool group", "cool users only", u3, uList);
        group.add(g);

        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        instance.setPartOfGroup(group);
        assertEquals(instance.getPartOfGroups(), group);
    }

    /**
     * Test of removePartOfGroup method, of class Profile.
     */
    @Test
    public void testRemovePartOfGroup() {
        System.out.println("removePartOfGroup");
        List<Goal> goals = new LinkedList<>();
        List<Mood> moods = new LinkedList<>();
        List<Assessment> asmts = new LinkedList<>();
        List<Group> ownedGroups = new LinkedList<>();
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group g = new Group("cool group", "cool users only", u3, uList);
        ownedGroups.add(g);
        List<Group> partGroups = new LinkedList<>();

        Profile instance = new Profile(goals, moods, asmts, ownedGroups, partGroups);
        boolean expResult = false;
        boolean result = instance.removePartOfGroup(g);
        assertEquals(expResult, result);

    }

}
