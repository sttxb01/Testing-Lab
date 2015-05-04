import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class AverageTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testNewAverage() 
  {
    Average avg = new Average();

    assertEquals(0, avg.getCount());
    assertEquals(0, avg.getAverage(), 0.001);
  }

  public void testSingleValue()
  {
    Average avg = new Average();

    avg.addValue(5.5);

    assertEquals(5.5, avg.getAverage(), 0.001);
    assertEquals(1, avg.getCount());
  }

  public void testFiveDifferentValuesAverageNotZero()
  {
    Average avg = new Average();
    
    avg.addValue(-1.0);
    avg.addValue(-3.0);
    avg.addValue(3.0);
    avg.addValue(1.0);
    avg.addValue(10.0);
    
    assertEquals(2.0, avg.getAverage(), 0.001);
    assertEquals(5, avg.getCount());
  }
  
  public void testFiveDifferentValuesAverageZero()
  {
    Average avg = new Average();
    
    avg.addValue(-1.0);
    avg.addValue(-2.0);
    avg.addValue(-3.0);
    avg.addValue(2.0);
    avg.addValue(4.0);
    
    assertEquals(0.0, avg.getAverage(), 0.001);
    assertEquals(5, avg.getCount());
  }
  
  public void testFiveSameValuesAverage()
  {
    Average avg = new Average();
    
    avg.addValue(10.3);
    avg.addValue(10.3);
    avg.addValue(10.3);
    avg.addValue(10.3);
    avg.addValue(10.3);
    
    assertEquals(10.3, avg.getAverage(), 0.001);
    assertEquals(5, avg.getCount());
  }
    
}