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
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
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
            
            System.err.println("Picture Index: "+pictureIndex);
            
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
        if(excelColumnAddress == null){
            return null;
        }
        
        String letters [] = excelColumnAddress.toLowerCase().split(",");
        int [] indeces = new int[letters.length];
        
        for (int n = 0; n < indeces.length; n++) {
            indeces[n] = getLetterValue( String.valueOf(letters[n].charAt(0)) );
            System.err.println("Skipping column: "+letters[n]+"="+indeces[n]);
        }
        
        return indeces;
    }
    private int [] parseExcelAddress(String excelAddress){
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
    //</editor-fold>
}
