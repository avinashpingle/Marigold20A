package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtilities {
	private static final Logger LOG = Logger.getLogger(FileUtilities.class);
	public static String readProperty(String filePath, String key) {
		String value="";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
			
		} catch (FileNotFoundException e) {
			LOG.info("Unable to load properties file: "+filePath);
		}catch (Exception e) {
			LOG.info("Unable to read properties file: "+filePath);
		}
		return value;
	}
	
	public static String getBrowserName() {
		String baseDir = System.getProperty("user.dir");
		return readProperty(baseDir+"/src/main/resources/application.properties", "browserName");
	}
	
	public static String getAppUrl() {
		String baseDir = System.getProperty("user.dir");
		return readProperty(baseDir+"/src/main/resources/application.properties", "beta.appUrl");
	}
	
	/**
	 * This method will return List of data fetched from specific row
	 * @param rowNum
	 * @param filePath
	 * @param sheetName
	 */
	public List getRowData(int rowNum, String filePath, String sheetName) {
		FileInputStream fis=null;
		XSSFWorkbook book=null;
		List al = new ArrayList();
		try {
			fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			LOG.info("Unable to read file: "+filePath);
			e.printStackTrace();
		}catch (IOException e) {
			LOG.info("Unable to load file");
		}
		
		XSSFSheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		int lastCell = row.getLastCellNum();
		for(int i=0; i< lastCell; i++) {
			Cell cell = row.getCell(i);
			switch (cell.getCellTypeEnum()) {
			case STRING:
				al.add(cell.getStringCellValue());
				break;
			case NUMERIC:
				al.add(cell.getNumericCellValue());
				break;
			case BLANK:
				al.add("");
				break;
			default:
				LOG.error("Invalid cell type: "+cell.getCellTypeEnum());
				break;
			}
		}
		
		return al;
		
	}
}
