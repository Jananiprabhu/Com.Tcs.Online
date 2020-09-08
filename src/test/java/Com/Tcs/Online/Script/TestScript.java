package Com.Tcs.Online.Script;





import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Tcs.Online.Base.Testbase;
import Com.Tcs.Online.Pages.LoginPage;
import Com.Tcs.Online.Utils.Testutil;

public class TestScript extends Testbase
{
     LoginPage log;
	
	@BeforeTest(alwaysRun=true)
	public void Setup()
	{
		Openbrowser();
		log = new LoginPage();
	}
	
	@Test(priority=1) 
	public void ValidateTitle()
	{
		String t = log.VerifyTitle();
		Assert.assertEquals(t, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void ValidateUrl()
	{
		String u = log.VerifyUrl();
		Assert.assertEquals(u, "https://www.facebook.com/");
	}
	
	@Test(priority=3)
	public void Validatename()
	{
		log.VerifyFirstname("Gandhi");
	}
	
	@Test(priority=4)
	public void Validatecreate()
	{
		String str = log.VerifyCreate();
		Assert.assertEquals(str, "Create an account");
	}
	
	@Test(priority=5)
	public void ValidateRadiobutton()
	{
		boolean d = log.VerifyRadio();
		Assert.assertTrue(d);
	}
	
	@Test(priority=6)
	public void ValidateEmail()
	{
		log.Verifyemail("Admin@gmail.com");
	}
	
	@Test(priority=7)
	public void ValidatePass()
	{
		log.Verifypass("pass123434");
	}
	
	@Test(priority=8)
	public void ValidateTest() throws InterruptedException
	{
		log.VerifyTest("Selenium", "Password");
	}
	
	@Test(priority=9)
	public void ValidateDropdown()
	{
		Testutil.DayDropdown(log.DayDropdown, 4);
	}
	
	
	@Test(priority=10)
	public void ValidateDropdownMonth()
	{
		Testutil.MonthDropdown(log.MonthDropdown, "Apr");
	}
	
	@Test(priority=11)
	public void ValidateDropdownYear()
	{
		Testutil.YearDropdown(log.YearDropdown, "2020");;
	}
	
	@Test(enabled=false)
	public void ValidateAlertOKbutton()
	{
		log.AlertSignin.click();
		Testutil.AlertOKbutton();
	}
	
	
	
	@AfterTest
	public void Teardown()
	{
		driver.close();
	}
	
	

}
