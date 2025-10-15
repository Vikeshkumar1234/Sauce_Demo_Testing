package Selenium_Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading_Values_POM {
	
public ExcelReading_Values_POM() {
		super();
	}

public ArrayList<String> read_the_values() throws Exception
{
	ArrayList<String> cred=new ArrayList<String>();
	String file_name="Credentials.xlsx";
	String sheetname="Sheet1";
	FileInputStream input_file=new FileInputStream(file_name);
	XSSFWorkbook workBook=new XSSFWorkbook(input_file);
	XSSFSheet sheet=workBook.getSheet(sheetname);
	XSSFRow row=sheet.getRow(1);
	XSSFCell firstColumn=row.getCell(0);
	String uname=firstColumn.getStringCellValue();
	XSSFCell secondColumn=row.getCell(1);
	String pwd=secondColumn.getStringCellValue();
	cred.add(uname);
	cred.add(pwd);
	return cred;
}
}
