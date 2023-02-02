
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;

import jxl.read.biff.BiffException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import javafx.application.Application;
import java.lang.*;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ThirdM{
	//String path = "C://library//DemoFile.xlsx";
	public static void write() throws IOException, InvalidFormatException{
	 //System.out.println("C:\\\\library\\\\DemoFile.xlsx");
	String path = "C:\\library\\DemoFile.xlsx";
//String path = "C://library//DemoFile.xlsx";
FileInputStream fs = new FileInputStream(path);
//System.out.println("after file fs");
Workbook wb = new XSSFWorkbook(fs);
Sheet sheet1 = wb.getSheetAt(0);
int lastRow = sheet1.getLastRowNum();
for(int i=0; i<=lastRow; i++){
Row row = sheet1.getRow(i);
Cell cell = row.createCell(2);

cell.setCellValue("WriteintoExcel");

}

FileOutputStream fos = new FileOutputStream(path);
wb.write(fos);
fos.close();
}

}