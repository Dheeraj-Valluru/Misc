import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class tests the likert question.
 */
public class LikertQuestionTest extends AbstractQuestionTest {
  private String longRandom;


  @Test
  public void testCreateValidLikertQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      String[] answers = new String[]{"Strongly agree", "Agree", "Neither agree nor disagree",
        "Disagree", "Strongly disagree"};
      Question q = new LikertQuestion(questionText + "?", answers);
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals("Likert", q.getType());
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateLikertQuestionNoText() {
    String[] answers =
        new String[]{"Strongly agree", "Agree", "Neither agree nor disagree",
            "Disagree", "Strongly disagree"};
    new LikertQuestion("", answers);
  }


  @Test
  public void testAnswerCorrectly() {
    String[] answers =
        new String[]{"Strongly agree", "Agree", "Neither agree nor disagree",
            "Disagree", "Strongly disagree"};
    for (String answer : answers) {
      Question q = new LikertQuestion("Is this a trick question?", answers);
      assertFalse(q.hasBeenAnswered());

      q.answer(answer);
      assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    String[] possible =
        new String[]{"Strongly agree", "Agree", "Neither agree nor disagree",
            "Disagree", "Strongly disagree"};
    String[] answers = {"weakly disagree", ""};
    for (String answer : answers) {
      Question q = new LikertQuestion("Is this a trick question?", possible);
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail("Likert question accepted an invalid answer");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }


}