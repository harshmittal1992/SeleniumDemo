package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static LinkedHashMap<String, String> getExcelDataAsMap(String excelFileName, String sheetName) throws IOException {
		String dataFile = "src/test/resources/"+excelFileName+".xlsx";
	    File file = new File(dataFile);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet s = workbook.getSheet(sheetName);
		
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		// total row count
		int rowCount = s.getPhysicalNumberOfRows();
		// as first row contains headers
		for (int i = 1; i < rowCount; i++) {
			// Getting the row
			Row r = s.getRow(i);
			// every row has first is field name and another is value.
			String fieldName = r.getCell(0).getStringCellValue();
			String fieldValue = r.getCell(1).getStringCellValue();
			
			data.put(fieldName, fieldValue);
		}
		//System.out.println(data);
		return data;
	}
	
}
