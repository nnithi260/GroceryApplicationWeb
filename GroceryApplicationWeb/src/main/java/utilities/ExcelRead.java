package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
static FileInputStream f;
static XSSFWorkbook w;
static XSSFSheet sh;
public static String getStringData(int a, int b) throws IOException {
	f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\DETAILS.xlsx");
	w=new XSSFWorkbook(f);
	sh=w.getSheetAt(0);
	Row r= sh.getRow(a);
	Cell c=r.getCell(b);
	return c.getStringCellValue();
	
}

public static int getIntegerData(int a, int b) throws IOException {
	f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\DETAILS.xlsx");
	w=new XSSFWorkbook(f);
	sh=w.getSheetAt(0);
	Row r= sh.getRow(a);
	Cell c=r.getCell(b);
	return (int) c.getNumericCellValue();
	
}
}
