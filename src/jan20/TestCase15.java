
package jan20;

//********************************************************************************************
//*    Guru99 eCommerce Live Project    
//*    Participant : Krishna Rungta                   
//*                                                                                                                                                         *
//********************************************************************************************
/* Test Case requirements/descriptions:
*    Export all Orders in csv file and display these information in console and 
*    you are able to send this file to another email id as attachment 
* Note: Access to backend of the site. UserId "user01" and pw "user001"
*    
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Select 'CSV' in Export To dropdown and click Export button.
5. Read downloaded file and display all order information in console windows
6. Attach this exported file and email to another email id

Expected results:
1) Console displays all order information
2) Email is sent successfully
*/
import org.testng.annotations.AfterTest;
import org.apache.commons.mail.util.*;
import org.apache.commons.mail.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.mail.internet.MimeMessage;
import javax.swing.text.TableView.TableRow;

//import javax.mail.MessagingException;
import org.openqa.selenium.firefox.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.commons.mail.util.MimeMessageUtils;

class TestCase15 {
	  private static final String FinalXPath = null;
	private WebDriver driver;
	  private String baseUrl;
	  private String vUsername = "user01";
	  private String vPassword = "guru99com";
	  
	@BeforeTest
	public void setUp() throws Exception {
		//options = webdriver.FirefoxOptions()
				//options.binary_location = "C:\\library\\geckodriver.exe"
				//driver = webdriver.Firefox(executable_path=r'\geckodriver.exe full path here', firefox_options=options)
				//driver.get("https://www.montratec.com1")
		
		System.setProperty("webdriver.chrome.driver", "C:\\library\\Chromedriver.exe");
	    driver = new FirefoxDriver();
	    //driver = new FirefoxDriver();
	    baseUrl = "http://live.techpanda.org/index.php/backendlogin";
	    driver.get(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase10() throws Exception {
		  
		    //  1. Go to http://live.techpanda.org/index.php/backendlogin			
		    driver.get(baseUrl);
			
			
			//  2. Login the credentials provided
			
			driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(vUsername);	
			
			driver.findElement(By.xpath("//input[@id = 'login']")).sendKeys(vPassword);
			driver.findElement(By.xpath("//input[@value = 'Login']")).click();
			
			try {Thread.sleep(5000);}catch(Exception e){};
			
			for (String handle : driver.getWindowHandles()) {                                             
		    	driver.switchTo().window(handle);
		    	} 	    		
		    		   		    
		    //  3a. Go to Sales-> Orders menu                                                    // click the Sales tab
		    
		    // click the Sales tab 
		    driver.findElement(By.linkText("Sales")).click(); 
		    for (String handle : driver.getWindowHandles()) {                                             
		    	driver.switchTo().window(handle);
		    	} 
		    driver.findElement(By.linkText("Orders")).click(); 
		    for (String handle : driver.getWindowHandles()) {                                             
		    	driver.switchTo().window(handle);
		    	} 
	  
	  //http://live.techpanda.org/index.php/backendlogin/catalog_product_review/edit/ret/pending/id/4170/key/ae1757b3708d69296c283cf26bec5d86/
		    driver.findElement(By.xpath("//span[text()='Export']")).click();
			  for (String handle : driver.getWindowHandles()) {                                             
			    driver.switchTo().window(handle);
			    	}


	  }
	

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	  }
	}









