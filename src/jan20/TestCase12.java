
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.mail.internet.MimeMessage;
//import javax.mail.MessagingException;
import org.openqa.selenium.firefox.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.mail.util.MimeMessageUtils;

public class TestCase12 {
	  private WebDriver driver;
	  private String baseUrl;
	  public String vUsername = "user01";
	  public String vPassword = "guru99com";
	  
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
		    driver.findElement(By.linkText("Catalog")).click(); 
		    for (String handle : driver.getWindowHandles()) {                                             
		    	driver.switchTo().window(handle);
		    	} 
		    driver.findElement(By.linkText("Reviews and Ratings")).click(); 
		    for (String handle : driver.getWindowHandles()) {                                             
		    	driver.switchTo().window(handle);
		    }
		    	driver.findElement(By.linkText("Customer Reviews")).click(); 
			    for (String handle1 : driver.getWindowHandles()) {                                             
			    	driver.switchTo().window(handle1);
			    	} 
			    driver.findElement(By.linkText("Pending Reviews")).click(); 
			    for (String handle1 : driver.getWindowHandles()) {                                             
			    	driver.switchTo().window(handle1);
			    	} 
		  driver.findElement(By.name("review_id")).click();
			    driver.findElement(By.name("//button[@title='asc']")).click(); 
			    
			    
			    
			   
			    	driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td[1]")).click();
			  //driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td[10]/a")).click();
			    //String innerText = driver.findElement(
			    	//	By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText(); 		
			          //  System.out.println(innerText);
			    
			    //driver.findElement(By.name("reviews")).sendKeys("4170");
	  //driver.findElement(By.xpath("//button[@title='ID']")).click();
	  //driver.findElement(By.cssSelector("//div[@id='div1']//span[contains(text(), 'spanText')] "));
	  //Select drpCountry = new Select(driver.findElement(By.linkText("ID")));
	  
		//drpCountry.selectByValue("");
		 //String drp=driver.findElement(By.xpath("span[@ class='massaction-checkbox']")).sendKeys("4170");
		 //driver.findElement(By.name("reviews")).click();
	  //driver.findElement(By.linkText("ID")).click();
	  for (String handle1 : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle1);
	    	}
	  List<String> ls = new ArrayList<String>();
	   List<WebElement> rowSize= 
	   driver.findElements(By.xpath("//td[@class='cb-srs-pnts- name']"));

	   for (int i = 0; i < rowSize.size(); i++) {
	        ls.add(rowSize.get(i).getText());
	        System.out.println(rowSize.get(i).getText());
	    }
	  
	  //http://live.techpanda.org/index.php/backendlogin/catalog_product_review/edit/ret/pending/id/4170/key/ae1757b3708d69296c283cf26bec5d86/
	  driver.get("http://live.techpanda.org/index.php/backendlogin/catalog_product_review/edit/ret/pending/id/4170/key/3a6bc9c12eab30eaf00f3ca6c09f9336/");
	  for (String handle1 : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle1);
	    	}
	  }
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	  }
	}






