/**
 * Class that creates an abstract question, used to abstract the other question classes.
 */
public abstract class AbstractQuestion implements Question {
  protected String questionText;
  protected String[] options;
  protected String enteredAnswer;

  /**
   * Constructs Abstract question.
   *
   * @param text question text
   * @param options returns an abstract question with the user inputs
   */
  protected AbstractQuestion(String text, String[] options) {
    this.questionText = text;
    this.options = options;
    this.enteredAnswer = "";

  }

  @Override
  public String getQuestionText() {
    return questionText;
  }

  @Override
  public String getType() {
    String className = this.getClass().getSimpleName();
    return className.substring(0, className.length() - 8);
  }

  @Override
  public String getEnteredAnswer() {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.Question not attempted yet!");
    } else {
      return enteredAnswer;
    }
  }

  @Override
  public void answer(String enteredAnswer) {
    String[] options = this.options;

    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }

    throw new IllegalArgumentException("Invalid answer");
  }

  @Override
  public boolean hasBeenAnswered() {
    String[] options = this.options;
    return find(options);
  }

  /**
   * Function that finds the answer from the option list.
   * Uses a for each loop.
   *
   * @param options the list of possible options it has to look through
   * @return a boolean value indicating if it has been found.
   */
  private boolean find(String[] options) {
    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        return true;
      }
    }
    return false;
  }
}
