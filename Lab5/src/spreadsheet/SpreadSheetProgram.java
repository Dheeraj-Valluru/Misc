package spreadsheet;

import java.io.InputStreamReader;

/**
 * The sheet program class.
 */
public class SpreadSheetProgram {
  /**
   * The method that constrcuts the entire.
   * @param args the arguments.
   */
  public static void main(String[] args) {
    SpreadSheet model = new SparseSpreadSheet();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    SpreadSheetController controller = new SpreadSheetController(model, rd, ap);
    controller.goes();
  }
}
