package week5;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public void getReadExcel() throws IOException
	{
		XSSFWorkbook book= new XSSFWorkbook("path");
		XSSFSheet sheet= book.getSheetAt(0);
		int row=sheet.getLastRowNum();
		short columnCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows in the Excel:"+row);
		System.out.println("Number of columns in the Excel:"+columnCount);
	}
}
