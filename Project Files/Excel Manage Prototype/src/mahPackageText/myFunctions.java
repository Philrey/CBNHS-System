/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackageText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JTextField;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Phil Rey Paderogao
 */
public class myFunctions {
    public myFunctions() {
        
    }
    
    //<editor-fold desc="Excel Management Functions">
    /*  -----------------------------------
        | Important Dependencies For this |
        -----------------------------------
        poi-4.1.2.jar
        poi-ooxml-4.1.2.jar
        poi-ooxml-schemas-4.1.2.jar
        dom4j-1.6.jar
        commons-collections4-4.3.jar
        commons-compress-1.18.jar
        xmlbeans-3.1.0.jar
    */
    
    //<editor-fold desc="Variables That Matter">
    private static XSSFWorkbook workbook;
    private static final String letters [] = new String [] {
        "a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"
    };
    //</editor-fold>
    //<editor-fold desc="Open & Save File">
    public boolean createExcelFile(String fileName){
        if(fileName != null){
            try {
                FileInputStream file;
                file = new FileInputStream(new File(fileName));
                
                workbook = new XSSFWorkbook(file);
                
                file.close();
            } catch (Exception e) {
                System.err.println("Creating File Failed..."+fileName+"\n"+e.getLocalizedMessage());
                return false;
            }
        }else{
            workbook = new XSSFWorkbook();
        }
        System.out.println("Creating File Success..."+fileName);
        return true;
    }
    public boolean saveExcelFile(String fileName){
        try {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(new File(fileName));
            workbook.write(fileOut);
            fileOut.close();
            return true;
        } catch (Exception e) {
            System.err.println("Saving File Failed...");
            return false;
        }
    }
    //</editor-fold>
    //<editor-fold desc="Read Functions">
    public String readSingleValue(int sheetNumber,String excelAddress){
        int [] location = parseExcelAddress(excelAddress);
        return readSingleValue(sheetNumber, location[0], location[1]);
    }
    private String readSingleValue(int sheetNumber,int rowStart,int columnStart){
        DataFormatter df = new DataFormatter();
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        XSSFRow row = sheet.getRow(rowStart);
        XSSFCell cell = row.getCell(columnStart);
        
        if(cell!=null){
            return df.formatCellValue(cell);
        }
        return null;
    }
    public String readExcelLine(int sheetNumber,String skipMergedExcelColumns,String excelAddressStart,String lastColumnAddress){
        //readExcelLine(0,"A,B,D","A,1","Z");
        int startLocation [] = parseExcelAddress(excelAddressStart);
        int [] skippedColumns = parseExcelColumns(skipMergedExcelColumns);
        int lastColumn = lastColumnAddress==null || lastColumnAddress.length()<=0? -1 : getLetterValueAdvanced(lastColumnAddress.toLowerCase());
        return readExcelLine(sheetNumber, skippedColumns, startLocation[0], startLocation[1], lastColumn);
    }
    private String readExcelLine(int sheetNumber,int [] skipExcelColumns,int rowStart,int columnStart,int columnEnd){
        String cLine = "";
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        DataFormatter df = new DataFormatter();
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(rowStart);
        int lastColumn = columnEnd!=-1?columnEnd+1 : row.getLastCellNum();    //Put -1 on columnEnd if you want to get until the last column, else specify
        
        for (int n = columnStart; n < lastColumn; n++) {
            if(!isMergedCellIndex(n, skipExcelColumns)){
                cell = row.getCell(n);
                if(cell != null){
                    cLine+=df.formatCellValue(cell)+"@@";
                }else{
                    cLine+=" @@";
                }
            }
        }
        
        return cLine;
    }
    public String [] readRegion(int sheetNumber,String skipMergedExcelColumns,String excelAddressStart,String excelAddressEnd){
        int [] startLoc = parseExcelAddress(excelAddressStart);
        int [] endLoc = parseExcelAddress(excelAddressEnd);
        int [] columnsToSkip = parseExcelColumns(skipMergedExcelColumns);
        return readRegion(sheetNumber, columnsToSkip, startLoc[0], startLoc[1], endLoc[0], endLoc[1]);
    }
    private String [] readRegion(int sheetNumber,int [] skipExcelColumns,int row1,int column1,int row2,int column2){
        int rowCount = (row2-row1)+1;
        String [] values = new String [rowCount];
        String cLine;
        for (int n = 0; n < rowCount; n++) {
            cLine = readExcelLine(sheetNumber, skipExcelColumns, n+row1, column1, column2);
            //System.err.println("Line: "+cLine);
            values[n] = cLine;
        }
        return values;
    }
    //</editor-fold>
    //<editor-fold desc="Write Functions">
    //#1 Write Single Data
    public void writeExcelSingleData(int sheetNumber,JTextField textField,String excelAddress){
        writeExcelSingleData(sheetNumber, textField.getText(), excelAddress);
    }
    public void writeExcelSingleData(int sheetNumber,String value,String excelAddress){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(excelAddress);
        writeExcelSingleData(sheetNumber, value, location[0], location[1]);
    }
    private void writeExcelSingleData(int sheetNumber,String value,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        XSSFRow row = null;
        row = sheet.getRow(rowStart);
        
        if(row != null){
            XSSFCell cell = row.getCell(columnStart);
            if(cell != null){
                cell.setCellValue(value);
            }else{
                XSSFCell newCell = row.createCell(columnStart);
                newCell.setCellValue(value);
            }
        }else{
            row = sheet.createRow(rowStart);
            XSSFCell newCell = row.createCell(columnStart);
            newCell.setCellValue(value);
        }
    }
    //#2 Write One Whole Row
    public void writeExcelLine(int sheetNumber, String line,String skipMergedExcelColumns,String startAddress){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(startAddress);
        int [] skipExcelColumns = parseExcelColumns(skipMergedExcelColumns);
        writeExcelLine(sheetNumber, line, skipExcelColumns, location[0], location[1]);
    }
    private void writeExcelLine(int sheetNumber, String line,int [] skipExcelColumns,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        String [] values = line.split("@@");
        int dataCount = values.length;
        
        
        XSSFRow row = null;
        
        int currColumn = columnStart;
        for(int n=0;n<dataCount; ){
            row = sheet.getRow(rowStart);
            
            if(!isMergedCellIndex(currColumn, skipExcelColumns)){
                if(row != null){
                    XSSFCell cell = row.getCell(currColumn);

                    if(cell != null){
                        cell.setCellValue(values[n]);
                    }else{
                        XSSFCell newCell = row.createCell(currColumn);
                        newCell.setCellValue(values[n]);
                    }
                }else{
                    row = sheet.createRow(rowStart);
                    XSSFCell newCell = row.createCell(currColumn);
                    newCell.setCellValue(values[n]);
                }
                n++;
            }
            currColumn++;
        }
    }
    //#3 Draw an Image
    public void drawImageToCell(int sheetNumber,String imgUrl,String excelCellAddress,boolean resetSize){
        int location [] = parseExcelAddress(excelCellAddress);
        drawImageToCell(sheetNumber, imgUrl, new int [] {location[0],location[1],location[0]+1,location[1]+1}, resetSize);
    }
    public void drawImageToCell(int sheetNumber,String imgUrl,int [] anchors_X1Y1_X2Y2,boolean resetSize){
        try {
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            
            //Load File
            
            FileInputStream inpStream = new FileInputStream(new File(getClass().getResource(imgUrl).toURI()));
            byte[] bytes = IOUtils.toByteArray(inpStream);
            int pictureIndex = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            inpStream.close();
            
            //System.err.println("Picture Index: "+pictureIndex);
            
            if (bytes == null) {
                System.err.println("Bytes are null");
            }
            //Anchor Image
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            
            ClientAnchor anchor = helper.createClientAnchor();
            
            anchor.setRow1(anchors_X1Y1_X2Y2[0]);
            anchor.setCol1(anchors_X1Y1_X2Y2[1]);
            anchor.setRow2(anchors_X1Y1_X2Y2[2]);
            anchor.setCol2(anchors_X1Y1_X2Y2[3]);
            
            //Create Picture
            Picture picture = drawing.createPicture(anchor, pictureIndex);
            if(resetSize){
                picture.resize();
            }
        }catch(URISyntaxException x){
            System.err.println("Invalid URI");
            x.printStackTrace();
        }catch (IOException e) {
            System.err.println("File Not Found\n"+e.getMessage());
            e.printStackTrace();
        }
    }
    //</editor-fold>
    //<editor-fold desc="Merge Functions">
    public void mergeRegion(int sheetNumber,String addressFrom,String addressTo){
        int [] addr1 = parseExcelAddress(addressFrom);
        int [] addr2 = parseExcelAddress(addressTo);
        
        mergeRegion(sheetNumber, addr1[0], addr1[1], addr2[0], addr2[1]);
    }
    public void mergeRegion(int sheetNumber,int row1,int column1,int row2,int column2){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(row1, row2, column1, column2));
    }
    public void mergeColumns(int sheetNumber,int rowAddress,String columnAddressStart,String columnAddressEnd){
        int values [] = parseExcelColumns(columnAddressStart.toLowerCase()+","+columnAddressEnd.toLowerCase());
        
        mergeColumns(sheetNumber, rowAddress-1, values[0], values[1]);
    }
    public void mergeColumns(int sheetNumber,int rowAddress, int columnIndexStart, int columnIndexEnd){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(rowAddress, rowAddress, columnIndexStart, columnIndexEnd));
    }
    public void mergeRows(int sheetNumber,String columnAddress,int rowAddressStart,int rowAddressEnd){
        int column = getLetterValueAdvanced(columnAddress.toLowerCase());
        
        mergeRows(sheetNumber, column, rowAddressStart-1, rowAddressEnd-1);
    }
    public void mergeRows(int sheetNumber,int columnIndex, int rowIndexStart, int rowIndexEnd){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        sheet.addMergedRegion(new CellRangeAddress(rowIndexStart, rowIndexEnd, columnIndex, columnIndex));
    }
    //</editor-fold>
    //<editor-fold desc="Remove Row Functions">
    public void removeRows(int sheetNumber, int [] rowAddressesAscending){
        // Delete multiple rows with skipping in-between rows e.g {1,5,7,10}
        int rowCount = rowAddressesAscending.length;
        for (int n = rowCount-1; n >= 0; n--) {
            removeRow(sheetNumber, rowAddressesAscending[n]);
        }
    }
    public void removeRows(int sheetNumber, int rowStartAddress,int rowEndAddress){
        // Delete mupltiple rows in a straight order e.g {2,3,4,5,6}
        for (int n = rowEndAddress; n >= rowStartAddress; n--) {
            removeRow(sheetNumber, n);
        }
    }
    public void removeRow(int sheetNumber, int rowAddress){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        try {
            int lastIndex = sheet.getLastRowNum()<= rowAddress? sheet.getLastRowNum()+1 : sheet.getLastRowNum();
            
            //System.out.println("Last Row = "+sheet.getLastRowNum());
            sheet.shiftRows(rowAddress, lastIndex, -1);
        } catch (Exception e) {
            //e.printStackTrace();
            
        }
    }
    //</editor-fold>
    //<editor-fold desc="Other Useful Functions Hehe">
    private boolean isMergedCellIndex(int columnIndex, int [] mergedColumnsList){
        boolean result = false;
        if(mergedColumnsList != null){
            for(int n=0;n<mergedColumnsList.length;n++){
                if(columnIndex == mergedColumnsList[n]){
                    //System.err.println("Merged Column Found: "+mergedColumns[n]);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    private int [] parseExcelColumns(String excelColumnAddress){
        // Adresses must be in a format of E.G. ( A,B,D,E,G ) in ascending order
        if(excelColumnAddress == null || excelColumnAddress.length()<=0){
            return null;
        }
        
        String letters [] = excelColumnAddress.toLowerCase().split(",");
        int [] indeces = new int[letters.length];
        
        for (int n = 0; n < indeces.length; n++) {
            indeces[n] = getLetterValueAdvanced(String.valueOf(letters[n].charAt(0)) );
            //System.err.println("Skipping column: "+letters[n]+"="+indeces[n]);
        }
        
        return indeces;
    }
    private int [] parseExcelAddress(String excelAddress){
        String address [] = excelAddress.toLowerCase().split(",");
        
        int row = Integer.parseInt(address[1])-1;
        int column = 0;
        
        column = getLetterValueAdvanced(address[0]);
        return new int[]{row,column};
    }
    private int getLetterValue(String letter){
        String letterToSearch = "";
        for (int n = 0; n < letters.length; n++) {
            letterToSearch = String.valueOf(letter);
            
            if(letters[n].equals(letterToSearch)){
                return n;
            }
        }
        return 0;
    }
    private int getLetterValueAdvanced(String letters){
        // A = 0 Z = 25
        
        
        //Check if column address has multiple letters
        if(letters.length() <= 1){
            return getLetterValue(letters);
        }
        
        String letterToSearch = "";
        int currentValue = 0;
        
        int characterCount = letters.length();
        for (int n = 0; n < characterCount; n++) {
            letterToSearch = String.valueOf( letters.charAt(n) );
            //If Letter is not the last character, add values
            if(n != characterCount-1){  
                currentValue += (26 + (26*getLetterValue(letterToSearch)));
            }else{
                currentValue += getLetterValue(letterToSearch);
            }
        }
        //System.err.println("Advanced Value: "+currentValue);
        return currentValue;
    }
    private void removeSheetsAt(int sheetIndexInOrder []){
        int sheetCount = workbook.getNumberOfSheets();
        for (int n = sheetCount-1; n >= 0; n--) {
            try {
                workbook.removeSheetAt(n);
            } catch (Exception e) {
            }
        }
    }
    //</editor-fold>
    //</editor-fold>
}
