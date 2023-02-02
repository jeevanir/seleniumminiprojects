package jan20;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import jxl.Workbook;
	import jxl.Sheet;
	import jxl.read.*;
	import jxl.Cell;
	import jxl.read.biff.*;

	import org.openqa.selenium.By;
	//import org.openqa.timeout;
	import jxl.read.biff.BiffException;

	public class SecondM {

		public static void main(String[] args) throws BiffException, IOException, InterruptedException {
			// TODO Auto-generated method stub

			System.setProperty("webdriver.gecko	.driver", "C://library//geckodriver.exe");
			WebDriver driver =new ChromeDriver();
			driver.get
			("https://login.salesforce.com");
			
			FileInputStream fi = new FileInputStream
					("C://library//data2.xls");

					//Open Workbook
			System.out.println("after file fi");

					Workbook w = Workbook.getWorkbook(fi);
					
					Sheet s = w.getSheet(0);

					for(int row =1; row < s.getRows(); row = row+1 )

					{

					int aa = s.getRows();

					System.out.println("Row Limit :"+aa);

					//Log in as an employee

					//driver.get
					//("https://login.salesforce.com");

					driver.manage().window().maximize();

					//Read username from excel file

					String username = s.getCell(1, row).getContents();

					System.out.println("username :"+username); driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("//library//data2.xls");

					Thread.sleep(5000);

					//Read password from the Excel file

					String password = s.getCell(2, row).getContents();
					
					System.out.println("password: "+password);

					driver.findElement(By.linkText("Password")).sendKeys("admin");

					Thread.sleep(5000);

					driver.findElement(By.xpath(".//*[@id='Login']")).click();

					//driver.manage().timeouts().
					//implicitlyWait(90, TimeUnit.SECONDS);

					String e = driver.findElement(By.id("tsidButton")).getText();

					Thread.sleep(1000);

					System.out.println("Current Application: " +e);

					}
	}
	}
		

