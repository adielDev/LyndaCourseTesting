package adiel.lyndacoursetesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import adiel.lyndacoursetesting.activities.Calculator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by recntrek7 on 06/02/17.
 */

public class CalculatorTest {


    @Rule
    public RuleExample ruleExample = new RuleExample();

    public  Calculator calculator;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    public static  void afterClass(){
        System.out.println("afterClass");
    }

    @Before
    public void setup(){
        calculator = new Calculator();
        System.out.println("setup");
    }
    @After
    public void cleanup(){
        calculator = new Calculator();
        System.out.println("cleanup");
    }

    @Test
    @Category(CategoryAddTests.class)
    public void testAdd(){
        System.out.printf("testAdd");
        int total =calculator.add(5,4);
        assertEquals(9,total);
        //assertEquals("9",total);  //BE AWARE ! simple assert is not type safe
    }
    @Test
    @Category(CategoryAddTests.class)
    public void testAddMathcer(){
        System.out.printf("testAddMathcer");
        int total =calculator.add(5,4);
        assertThat(9,equalTo(total)); // type safe !
    }
    @Test
    public void testDiv(){
        System.out.printf("testDiv");
        int total =calculator.div(9,3);
        assertEquals(3,total);
    }
    @Test(expected = ArithmeticException.class)
    public void testDivWithZero(){
        System.out.printf("testDivWithZero");
        int total =calculator.div(9,0);
        assertEquals(3,total);
    }

    @Ignore
    @Test
    public void ignoreMe(){
        System.out.println("ignore me ");
    }


}
