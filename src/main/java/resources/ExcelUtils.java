package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
//	public static void main(String[] args) throws Exception {
//		String basepath = System.getProperty("user.dir");
//		String path = basepath.concat("\\src\\main\\java\\resources\\TestData.xlsx");
//		ExcelUtils.setExcelFile(path, "Sheet1");
//		getRowCount();
//		getColCount();
//		readExcel("Sheet1");
//	}

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName)
			throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

// Method for Rowcount
	
	public static int getRowCount(){
		int rowCount = 0; 
		try {
			rowCount = ExcelWSheet.getPhysicalNumberOfRows();
//			System.out.println(rowCount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowCount;
		
	}
	
	public static int getColCount(){
		int colCount = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
//		System.out.println(colCount);
		return colCount;
	}
	
	public static Object[][] readExcel(String sheetName) throws Exception {
		//String cellData = null;
		
		String cellValue = null;
		String basepath = System.getProperty("user.dir");
		String path = basepath.concat("\\src\\main\\java\\resources\\TestData.xlsx");
		setExcelFile(path, sheetName);
		Object[][] cellVal = new Object[getRowCount()-1][getColCount()-1];
		
		
		for (int i=1;i<getRowCount();i++){
			for (int j=1;j<getColCount();j++){
				getCellData(i, j);
				cellValue = getCellData(i, j);
				System.out.print(cellValue);
				cellVal[i-1][j-1] =cellValue; 
			}
//			System.out.println();
		}
		System.out.println(cellVal);
		return cellVal;
//		String userName = ExcelUtils.getCellData(1, 1);
//		String password = ExcelUtils.getCellData(1, 2);
		//return cellData;
		
	}

}
