package mahPackageText;

/**
 *
 * @author Phil Rey Paderogao
 */
public class excelManager {
    private static myFunctions my;
    public static void main(String[] args) {
        my = new myFunctions();
        
        my.createExcelFile("Test.xlsx");
        //my.removeRow(0, 19);
        //my.removeRows(0, new int [] {1,4,6,7});
        my.mergeRows(0, "B", 1, 4);
        my.mergeColumns(0, 2, "C", "E");
        my.mergeRegion(0, "C,3", "E,4");
        my.saveExcelFile("Text.xlsx");
    }
}
