package tests;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtility {

   /*public static void main(String[] args) throws IOException {
    	
       String filePath = "D:\\guru99Sheet.xlsx";

         FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis) ;
             XSSFSheet sheet=workbook.getSheet("Sheet1");
             
             //using for loop
             
            int rows= sheet.getLastRowNum();
            int cols=sheet.getRow(1).getLastCellNum();
            
            //to read row cells
            for(int r=0;r<=rows;r++) {
            	
            	XSSFRow row = sheet.getRow(r);
            	for(int c=0;c<cols;c++) {
            		XSSFCell cell= row.getCell(c);
            		switch(cell.getCellType()) {
            		case STRING: System.out.println(cell.getStringCellValue()); break;
            		case NUMERIC: System.out.println(cell.getNumericCellValue());break;
            		case BOOLEAN: 	System.out.println(cell.getBooleanCellValue());break;
            		}
            	}
            	System.out.println();
            }
            
             
             

         
    }
}
   */ 
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet  sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle  style;
	String path="D:\\guru99Sheet.xlsx";
	
	XLUtility(String path){
		this.path=path;
	}
	
	public int getRowCount(String SheetName) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(SheetName);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
		
	}
	
	public int getCellCount(String SheetName,int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(SheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
		
	}
	
	public String cellData(String SheetName,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(SheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter df=new DataFormatter();
		String data;
		try {
			
			data= df.formatCellValue(cell);
			
		}
		catch(Exception e) {
			data="";
			
		}
		wb.close();
		fi.close();
		         
		return data;
		
	}
	
	
	public void setCellData(String SheetName,int rownum,int colnum,String data) throws IOException {
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(SheetName);
	
	row=sheet.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
	}
	
   
    }

