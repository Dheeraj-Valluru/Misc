/**
 * Represents a simple fraction with a numerator and a denominator.
 */
public final class SimpleFraction implements Fraction {
  private final int numerator;
  private final int denominator;

  /**
   * Constructs a fraction in terms of its numerator and denominator.
   *
   * @param numerator   a numerator of a fraction
   * @param denominator a denominator of fraction
   * @throws IllegalArgumentException if a fraction is negative
   */
  public SimpleFraction(int numerator, int denominator) {
    if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
      throw new IllegalArgumentException("must be a non-negative fraction");
    } else if (denominator == 0) {
      throw new IllegalArgumentException("denominator must not be 0");
    }

    this.numerator = numerator;
    this.denominator = denominator;
  }

  @Override
  public Fraction add(Fraction other) {
    if (other.getDecimalValue(2) < 0) {
      throw new IllegalArgumentException("Fraction must be non-negative");
    }
    //Double dispatch
    return (other.add(this.numerator, this.denominator));
  }

  @Override
  public Fraction add(int numerator, int denominator) {
    if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
      throw new IllegalArgumentException("must be a non-negative fraction");
    }
    return new SimpleFraction(denominator * this.numerator + numerator * this.denominator,
            this.denominator * denominator);
  }

  @Override
  public double getDecimalValue(int places) {
    return Math.round((Math.pow(10, places) * this.numerator / this.denominator))
            / Math.pow(10, places);
  }

  /**
   * Function meant to put a franction in string form with a '/' in the middle.
   *
   * @return a string that puts a simple fraction in string form
   */
  @Override
  public String toString() {
    return Math.abs(this.numerator) + "/" + Math.abs(this.denominator);
  }
}
