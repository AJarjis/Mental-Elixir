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
public class UserTest {
    
    public UserTest() {
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

    /**
     * Test of getProfile method, of class User.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        Profile expResult = setUpProfile();
        instance.setProfile(expResult);
        Profile result = instance.getProfile();
        assertEquals(expResult, result);

    }

    /**
     * Test of setProfile method, of class User.
     */
    @Test
    public void testSetProfile() {
        System.out.println("setProfile");
        Profile profile = setUpProfile();
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setProfile(profile);
        assertEquals(instance.getProfile(), profile);
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        String expResult = "okok";
        String result = instance.getUserName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "nono";
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setUserName(userName);
        assertEquals(userName, instance.getUserName());
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        String expResult = "fitch";
        String result = instance.getFirstName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "gorge";
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of getSurname method, of class User.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        String expResult = "mitch";
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSurname method, of class User.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "lolo";
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setSurname(surname);
        assertEquals(surname, instance.getSurname());
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        String expResult = "noo@go.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "ok@ook.com";
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        String expResult = "ewq";
        String result = instance.getPassword();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "qwe";
        User instance = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }
    
}
