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
        //System.err.println(my.readSingleValue(0, "P,5"));
        //System.out.println(my.readExcelLine(0, null, "A,6", ""));
        String [] result = my.readRegion(0, null, "A,1", "Q,10");
        for (String n : result) {
            System.err.println(n);
        }
        my.saveExcelFile("Text.xlsx");
    }
}
