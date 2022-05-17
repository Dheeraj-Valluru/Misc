/**
 * this class represents a 5-scale likert question.
 * the scales are strongly agree, agree, neither agree nor disagree, disagree and strongly disagree.
 */
public class LikertQuestion extends AbstractQuestion {

  //a valid question must have text

  /**
   * Constructs a LikertQuestion with the user inputs.
   *
   * @param text represents the question text
   * @param options represents the possible answer choices
   * @throws IllegalArgumentException Defaults the options to the correct things specified by lab.
   */
  public LikertQuestion(String text, String[] options) throws IllegalArgumentException {
    super(text, options);
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    String[] possible = new String[]{"Strongly agree", "Agree", "Neither agree nor disagree",
        "Disagree", "Strongly disagree"};
    this.questionText = text;
    this.enteredAnswer = "";
    this.options = possible;
  }

}
