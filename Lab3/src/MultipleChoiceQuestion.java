/**
 * Represents a multiple choice question.
 * Consists of four multiple choice answers numbered one through four.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {

  /**
   * Constructs a MultipleChoiceQuestion with the user inputs.
   *
   * @param text the text of a question
   * @param options the possible answer choices a multiple choice question can take.
   * @throws IllegalArgumentException Defaults the options to the correct things specified by lab.
   */
  public MultipleChoiceQuestion(String text, String[] options) throws IllegalArgumentException {
    super(text, options);
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.questionText = text;
    this.enteredAnswer = "";
    this.options = new String[]{"1", "2", "3", "4"};
  }
}
