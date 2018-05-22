/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class GroupTest {
    
    public GroupTest() {
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
     * Test of getGroupName method, of class Group.
     */
    @Test
    public void testGetGroupName() {
        System.out.println("getGroupName");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        String expResult = "cool group";
        String result = instance.getGroupName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGroupName method, of class Group.
     */
    @Test
    public void testSetGroupName() {
        System.out.println("setGroupName");
        String groupName = "Not so cool anymore";
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        instance.setGroupName(groupName);
        assertEquals(instance.getGroupName(), groupName);
    }

    /**
     * Test of getDescription method, of class Group.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        String expResult = "cool users only";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Group.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "maybe not only cool people";
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        instance.setDescription(description);
        assertEquals(instance.getDescription(), description);
    }

    /**
     * Test of getCreator method, of class Group.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        User expResult = u3;
        User result = instance.getCreator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreator method, of class Group.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        User creator = new User("Mume", "foo", "doo", "goo@mo.com", "qwe");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        instance.setCreator(creator);
        assertEquals(creator, instance.getCreator());
    }

    /**
     * Test of setMembers method, of class Group.
     */
    @Test
    public void testSetMembers() {
        System.out.println("setMembers");
        User u11 = new User("nono", "foo", "doo", "noo@noo.com", "www");
        User u22 = new User("fufu", "fitch", "mitch", "noo@go.com", "ewq");
        User u33 = new User("dodo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> members = new LinkedList<>();
        members.add(u11);
        members.add(u22);
        members.add(u33);
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        instance.setMembers(members);
        assertEquals(instance.getMembers(), members);
    }

    /**
     * Test of getMembers method, of class Group.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        List<User> expResult = uList;
        List<User> result = instance.getMembers();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMember method, of class Group.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        User user = new User("nono", "foo", "doo", "noo@noo.com", "www");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        instance.addMember(user);
        assertTrue(instance.getMembers().remove(user));
    }

    /**
     * Test of removeMember method, of class Group.
     */
    @Test
    public void testRemoveMember() {
        System.out.println("removeMember");
        User u1 = new User("moo", "foo", "doo", "noo@noo.com", "www");
        User u2 = new User("okok", "fitch", "mitch", "noo@go.com", "ewq");
        User u3 = new User("moo", "foo", "doo", "goo@mo.com", "qwe");
        List<User> uList = new LinkedList<>();
        uList.add(u1);
        uList.add(u2);
        Group instance = new Group("cool group", "cool users only", u3, uList);
        boolean expResult = true;
        boolean result = instance.removeMember(u1);
        assertEquals(expResult, result);
    }
}
