


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ParameterazationTest {
	
	WebDriver oBrowser;
	
	@Test
	public void eBayInChromeDataDrivenScenario() throws InterruptedException
	{
				
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Deepali\\Documents\\Selenium\\eBayTestData.xls","Search");
		
		//1.Open chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepali\\Documents\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		oBrowser = new ChromeDriver();
		
				 
		for(int i=1; i<oExcel.rowCount(); i++)
		{
			
			//2.Launch==> www.ebay.com
			oBrowser.get("http://www.ebay.com");
			
			//3.Enter "laptop" in search text box
			
		oBrowser.findElement(By.id("gh-ac")).clear();	
	oBrowser.findElement(By.id("gh-ac")).sendKeys(oExcel.getCellData("SearchFor", i));
	
	//4.Click on "search" button
	
	oBrowser.findElement(By.id("gh-btn")).click();
	
	//5.Click on Advanced link
	
	oBrowser.findElement(By.linkText("Advanced")).click();
	
	Thread.sleep(4000);
			
		}
	
	}

}
