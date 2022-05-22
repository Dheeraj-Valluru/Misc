/**
 * Interface meant to represent different types of fractions.
 */
public interface Fraction {

  /**
   * A method to add two fraction objects.
   *
   * @param other takes in another fraction
   * @return fraction
   */
  Fraction add(Fraction other);

  /**
   * A method to add two fraction objects when one is given in the form numerator and denominator.
   *
   * @param numerator a numerator of a fraction
   * @param denominator a denominator of a fraction
   * @return fraction
   * @throws IllegalArgumentException if the fraction provided to it is negative
   */
  Fraction add(int numerator, int denominator);

  /**
   * A method that returns the decimal value of a fraction rounded to the given number of places.
   *
   * @param places a value to round to
   * @return the decimal value of a fraction
   */
  double getDecimalValue(int places);
}
