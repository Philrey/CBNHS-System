/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author pader
 */
public class searchClass {
    public static searchClass sc;
    public static myFunctions my;

    private searchClass() {
        my = new myFunctions(true);
    }
    
    public static searchClass getInstance(){
        if(sc == null){
            sc = new searchClass();
        }
        return sc;
    }
    //<editor-fold desc="Seach variations">
    //Simple Search
    public void searchItem(String toSearch,JTable jTableName) {
        
    }
    //Full Search
    public void searchItem(String toSearch,String from,String where,JTable jTableName,JTextField tfResults,int resultsShown,int pageNumber){
        //resultsShown: -1 = show all, else show specified number
        //Query: SELECT * FROM {from} WHERE {where includes ORDER BY} LIMIT {pageNumber-1},{resultsShown}
        
        
    }
    //</editor-fold>
}
