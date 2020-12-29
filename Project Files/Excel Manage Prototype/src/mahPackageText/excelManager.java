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
        my.writeExcelSingleData(0, "Hello World2", "BA,5");
        my.drawImageToCell(0, "icons/Among Us Bois.png", new int []{2,3,3,4}, false);
        my.drawImageToCell(0, myVariables.getLateCommerIcon(), "D,4", false);
        my.drawImageToCell(0, myVariables.getCuttingClassesIcon(), "E,4", false);
        my.saveExcelFile("Text.xlsx");
    }
}
