package spreadsheet;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;


/**
 * Test class from the spreadsheet controller.
 */
public class SpreadSheetControllerTest {


  @Test
  public void testGo() throws IllegalStateException {
    Reader in = new StringReader("q");
    StringBuilder out = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(new SparseSpreadSheet(), in, out);
    controller.goes();
    String[] split = out.toString().split(System.lineSeparator());
    assertEquals("Welcome to the spreadsheet program!", split[0]);
    assertEquals("Supported user instructions are: ", split[1]);
    assertEquals("assign-value row-num col-num value (set a cell to a value)", split[2]);
    assertEquals("print-value row-num col-num (print the value at a given cell)", split[3]);
    assertEquals("menu (Print supported instruction list)", split[4]);
    assertEquals("q or quit (quit the program) ", split[5]);
  }

  @Test
  public void testGoQuit() throws IllegalStateException {
    Reader in = new StringReader("q");
    StringBuilder out = new StringBuilder();
    SpreadSheetController controller = new SpreadSheetController(new SparseSpreadSheet(), in, out);
    controller.goes();
    String[] split = out.toString().split(System.lineSeparator());
    String farewell = (split[6].replace("Type instruction: ", ""));
    assertEquals("Thank you for using this program!", farewell);
  }


}