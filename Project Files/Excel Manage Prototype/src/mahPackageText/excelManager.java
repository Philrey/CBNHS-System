package mahPackageText;

/**
 *
 * @author Phil Rey Paderogao
 */
public class excelManager {
    private static myFunctions my;
    public static void main(String[] args) {
        my = new myFunctions();
        
        my.createExcelFile("jh_sf7.xlsx");
        //my.removeRow(0, 19);
        //my.removeRows(0, new int [] {1,4,6,7});
        my.removeRows(0, 166, 175);
        
        my.mergeRows(0, "A", 161, 166);
        my.mergeRows(0, "B", 161, 166);
        my.mergeRows(0, "C", 161, 166);
        my.mergeRows(0, "D", 161, 166);
        my.mergeRows(0, "E", 161, 166);
        my.mergeRows(0, "F", 161, 166);
        my.mergeRows(0, "G", 161, 166);
        my.mergeRows(0, "H", 161, 166);
        my.mergeRows(0, "I", 161, 166);
        my.mergeRows(0, "O", 161, 166);
        //my.mergeRows(0, "B", 1, 4);
        //my.mergeColumns(0, 2, "C", "E");
        //my.mergeRegion(0, "C,3", "E,4");
        my.saveExcelFile("Text.xlsx");
    }
}
