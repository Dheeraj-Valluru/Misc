import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * This class tests the yes no question.
 */
public class YesNoQuestionTest extends AbstractQuestionTest {


  @Test
  public void testCreateValidYesNoQuestion() {
    String longRandom;
    Random r = new Random(200);
    longRandom = "aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn";
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = new YesNoQuestion(questionText + "?", new String[]{"Yes", "No"});
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals("YesNo", q.getType());
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoText() {
    new YesNoQuestion("",
            new String[]{"Yes", "No"});
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun", new String[]{"Yes", "No"});
  }

  @Test
  public void testAnswerCorrectly() {
    String[] answers =
        {"yes", "Yes", "YEs", "YeS", "YES", "yEs", "yES", "yeS", "no", "No", "nO", "NO"};
    for (String answer : answers) {
      Question q = new YesNoQuestion("Is this a trick question?", new String[]{"Yes", "No"});
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
      } catch (IllegalArgumentException e) {
        // exception caught
      }

      try {

      } catch (IllegalArgumentException e) {
        assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      }
      assertEquals(q.hasBeenAnswered(), false);
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    String[] answers = {"yess", ""};
    for (String answer : answers) {
      Question q = new YesNoQuestion("Is this a trick question?", new String[]{"Yes", "No"});
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail("Yes No question accepted an invalid answer");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }


}