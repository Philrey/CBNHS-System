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
        my.writeExcelLine(0, "Meow@@Meow2@@Meow3@@", "B,C,D,F","A,1");
        my.writeExcelSingleData(0, "Hello World2", "G,5");
        my.saveExcelFile("Text.xlsx");
    }
}
