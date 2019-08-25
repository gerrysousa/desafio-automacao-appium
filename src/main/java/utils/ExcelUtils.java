package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName){
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int startCol = 1;
            int ci,cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            // you can write a function as well to get Column count
            //int test1 = ExcelWSheet.getRow();

            int totalCols = (ExcelWSheet.getRow(0).getLastCellNum())-1;
            tabArray=new String[totalRows][totalCols];
            ci=0;
            for (int i=startRow;i<=totalRows;i++, ci++) {
                cj=0;
                for (int j=startCol;j<=totalCols;j++, cj++){
                    tabArray[ci][cj]=getCellData(i,j);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Vish! Não conseguiu ler o excel!");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("Vish! Não conseguiu ler o excel!");
            e.printStackTrace();
        }
        return(tabArray);
    }
    public static String getCellData(int RowNum, int ColNum){
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int dataType = Cell.getCellType();
            if (dataType == 3) {
                return "";
            } else {
                String CellData = Cell.getStringCellValue();
                return CellData;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}