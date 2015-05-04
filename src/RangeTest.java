import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class RangeTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testNewRange() {
    Range rng = new Range(0.0, 0.0);
  }
  
  public void testGetMin() {
    Range rng = new Range (0.0, 1.0);
    assertEquals(0.0, rng.getMin(), 0.001);
    
    
    
  }
  
}
