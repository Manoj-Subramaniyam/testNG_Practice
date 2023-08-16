package week5;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
		
		XSSFRow rowNum= sheet.getRow(1);
		XSSFCell column=rowNum.getCell(1);
		System.out.println(column.getNumericCellValue());
		
		for(int i=1;i<=row;i++)
		{
			rowNum= sheet.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				column=rowNum.getCell(j);
				System.out.println(column.getNumericCellValue());
			}
		}
		book.close();
		
	}
}
