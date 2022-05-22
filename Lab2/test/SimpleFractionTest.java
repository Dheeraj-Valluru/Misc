import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class meant to test my simple fraction functions.
 */
public class SimpleFractionTest {

  private Fraction f1;
  private Fraction f2;
  private Fraction f4;
  private Fraction f5;
  private Fraction f6;

  @Before
  public void init() {
    f1 = new SimpleFraction(1, 2);
    f2 = new SimpleFraction(10, 12);
    f4 = new SimpleFraction(0, 1);
    f5 = new SimpleFraction(3, 8);
    f6 = new SimpleFraction(-3, -8);
    // f3 = new SimpleFraction(-1,3);
  }

  @Test
  public void initValidFractions() {
    f1 = new SimpleFraction(1, 2);
    assertEquals("1/2", f1.toString());
    f2 = new SimpleFraction(10, 12);
    assertEquals("10/12", f2.toString());
  }

  @Test
  public void initInvalidFractions() {
    Fraction f3;
    try {
      f3 = new SimpleFraction(-1, 3);
      fail("Constructor did not throw Illegal Argument Exception.");
    } catch (IllegalArgumentException e) {
      // exception was thrown correctly
    }
  }

  @Test
  public void testAdd() {
    assertEquals(new SimpleFraction(4, 4).getDecimalValue(1),
            f1.add(1, 2).getDecimalValue(1), 0.01);
    assertEquals(new SimpleFraction(240, 144).getDecimalValue(1),
            f2.add(10, 12).getDecimalValue(1), 0.01);
    assertEquals(new SimpleFraction(32, 24).getDecimalValue(1),
            f1.add(f2).getDecimalValue(1), 0.01);
    assertEquals(new SimpleFraction(1, 2).getDecimalValue(1),
            f1.add(f4).getDecimalValue(1), 0.01);
  }

  @Test
  public void testGetDecimalValue() {
    assertEquals(0.5, f1.getDecimalValue(1), 0.01);
    assertEquals(0.38, f5.getDecimalValue(2), 0.01);
    assertEquals(0.833, f2.getDecimalValue(3), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("1/2", f1.toString());
    assertEquals("10/12", f2.toString());
    assertEquals("0/1", f4.toString());
    assertEquals("3/8", f6.toString());
  }
}