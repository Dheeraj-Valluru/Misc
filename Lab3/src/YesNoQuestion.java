/**
 * This class represents a yes/no question.
 */
public class YesNoQuestion extends AbstractQuestion {

  //a question must be non empty and should end with a question mark

  /**
   * Determines the format of a yas no question by constructing it.
   *
   * @param text represents the text of a question
   * @param options represents the options of a question answer
   * @throws IllegalArgumentException Uses the user inputs and creates the yes no question
   */
  public YesNoQuestion(String text, String[] options) throws IllegalArgumentException {
    super(text, options);
    if ((text.length() == 0) || (text.charAt(text.length() - 1) != '?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.questionText = text;
    this.enteredAnswer = "";
    this.options = new String[]{"Yes", "No"};
  }

}
