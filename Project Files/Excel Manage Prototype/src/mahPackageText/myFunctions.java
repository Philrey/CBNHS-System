/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackageText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Phil Rey Paderogao
 */
public class myFunctions {
    //<editor-fold desc="Excel Management Functions">
    private static XSSFWorkbook workbook;
    private static final String letters [] = new String [] {
        "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
        "s","t","u","v","w","x","y","z"
    };

    public myFunctions() {
    }
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
    public void saveExcelFile(String fileName){
        try {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(new File(fileName));
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            System.err.println("Saving File Failed...");
        }
    }
    //</editor-fold>
    //<editor-fold desc="Write Functions">
    //#1 Write Single Data
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
    public void writeExcelLine(int sheetNumber, String line,int [] skipExcelColumns,String startAddress){
        //Note: excellAddress must have ',' to separate the address. E.G. ( A,1 )
        int [] location = parseExcelAddress(startAddress);
        writeExcelLine(sheetNumber, line, skipExcelColumns, location[0], location[1]);
    }
    private void writeExcelLine(int sheetNumber, String line,int [] skipExcelColumns,int rowStart,int columnStart){
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        
        if(sheet == null){
            sheet = workbook.createSheet("SHEET_"+(sheetNumber+1));
        }
        
        String [] values = line.split("@@");
        int columnCount = values.length;
        
        
        XSSFRow row = null;
        
        for(int n=0;n<columnCount;n++){
            row = sheet.getRow(rowStart);

            if(row != null){
                XSSFCell cell = row.getCell(columnStart+n);

                if(cell != null){
                    cell.setCellValue(values[n]);
                }else{
                    XSSFCell newCell = row.createCell(columnStart+n);
                    newCell.setCellValue(values[n]);
                }
            }else{
                row = sheet.createRow(rowStart);
                XSSFCell newCell = row.createCell(columnStart+n);
                newCell.setCellValue(values[n]);
            }
        }
    }
    
    //</editor-fold>
    
    
    
    public int [] parseExcelAddress(String excelAddress){
        String address [] = excelAddress.toLowerCase().split(",");
        
        int row = Integer.parseInt(address[1])-1;
        int column = 0;
        
        column = getLetterValue( String.valueOf(address[0].charAt(0)) );
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
    //</editor-fold>
}
