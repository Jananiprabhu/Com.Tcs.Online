package Com.Tcs.Online.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.Tcs.Online.Utils.Testutil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase 
{
	File f;
	FileInputStream fis;
	Properties pro;
	public static WebDriver driver;
	
	public Testbase()
	{
		try
		{
		f=new File(".//src//main//java//Com//Tcs//Online//Config//Config.Properties");
		fis=new FileInputStream(f);
		pro=new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void Openbrowser()
	{
		String browser = pro.getProperty("browsername");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.get(pro.getProperty("url"));
		Testutil.Maximize();
		Testutil.Implicitwait();
		Testutil.Takesscreen();
		
	}

}
