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
        //my.removeRow(0, 9);
        my.removeRows(0, 19, 31);
        //my.removeRows(0, new int [] {1,4,6,7});
        my.saveExcelFile("Text.xlsx");
    }
}
