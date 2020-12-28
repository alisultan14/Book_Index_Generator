

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class IndexTesterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HashIndexTest
{
     /**
     * Test Case to search from dictionary method
     * Normal
     */
    @Test 
    public void testdictionary(){
        ArrayList<String> wrds = new ArrayList<>();
        wrds.add("it");
        wrds.add("is");
        wrds.add("going");
        wrds.add("to");
        wrds.add("be");
        wrds.add("alright");
        Collections.sort(wrds);
        Index testid = new HashIndex();
        boolean actual = testid.searchDict(wrds,"is");
        boolean expected = true;
        assertEquals(expected,actual);

    }

    /**
     * Test Case to search from dictionary method
     * Boundary
     */
    @Test 
    public void testdictionary1(){
        ArrayList<String> wrds = new ArrayList<>();
        wrds.add("it");
        wrds.add("is");
        wrds.add("going");
        wrds.add("to");
        wrds.add("be");
        wrds.add("alright");
        Collections.sort(wrds);
        Index testid = new HashIndex();
        boolean actual = testid.searchDict(wrds,"also");
        boolean expected = false;
        assertEquals(expected,actual);

    }

    /**
     * Test Case to addIndex
     * Normal
     */
    @Test 
    public void testaddindex(){
        Index testid = new HashIndex();
        testid.addIndex("it",34);
        testid.addIndex("is",43);
        testid.addIndex("what",43);
        testid.addIndex("it",21);
        int actual = testid.SizeSort();
        int expected = 3;
        assertEquals(expected,actual);

    }

    /**
     * Test Case to addIndex
     * Normal
     */
    @Test 
    public void testsizeSort(){
        Index testid = new HashIndex();
        testid.addIndex("it",34);
        testid.addIndex("is",43);
        testid.addIndex("what",43);
        testid.addIndex("it",21);
        testid.addIndex("in",21);
        int actual = testid.SizeSort();
        int expected = 4;
        assertEquals(expected,actual);

    }

    /**
     * Test Case to addIndex
     * Boundary
     */
    @Test 
    public void testsizeSort1(){
        Index testid = new HashIndex();
        int actual = testid.SizeSort();
        int expected = 0;
        assertEquals(expected,actual);

    }
    
    /**
     * Test Case toString 
     * Normal
     */
    @Test 
    public void testtoString(){
        Index testid = new HashIndex();
        testid.addIndex("a",34);
        testid.addIndex("b",43);
        testid.addIndex("c",43);
        testid.addIndex("d",21);
        testid.addIndex("e",21);
        testid.SizeSort();
        String actual = testid.toString(3);
        String expected = "d [21]";
         assertEquals(expected,actual);
    }
   
}
