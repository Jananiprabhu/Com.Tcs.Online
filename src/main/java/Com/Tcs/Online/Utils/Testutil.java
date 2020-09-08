package Com.Tcs.Online.Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Com.Tcs.Online.Base.Testbase;

public class Testutil extends Testbase
{
      public static void Maximize()
      {
    	  driver.manage().window().maximize();
      }
      
      public static void Implicitwait()
      {
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
      
      public static void DayDropdown(WebElement day,int r)
      {
    	  Select sel = new Select(day);
    	  sel.selectByIndex(r);
    			 
      }
      
      public static void MonthDropdown(WebElement mon, String s)
      {
    	  Select sel = new Select(mon);
    	  sel.selectByVisibleText(s);
       }
      
      public static void YearDropdown(WebElement year, String str)
      {
    	  Select sel = new Select(year);
    	  sel.selectByValue(str);
       }
      
      public static void Takesscreen()
      {
    	  try
    	  {
    		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		  FileHandler.copy(src, new File(".//src//main//java//Com//Tcs//Online//Screenshot//fb"+System.currentTimeMillis()+".jpg"));
    	  }
    	  catch(Exception e)
    	  {
    		  System.out.println(e.getMessage());
    	  }
      }
      
      public static void AlertOKbutton()
      {
    	  Alert alt=driver.switchTo().alert();
    	  alt.accept();
      }
      
     
}
