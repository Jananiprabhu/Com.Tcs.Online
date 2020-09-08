package Com.Tcs.Online.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Tcs.Online.Base.Testbase;

public class LoginPage extends Testbase
{
	@FindBy(id="email")
	public WebElement Emailorphone;
	
	@FindBy(name="pass")
	public WebElement Password;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//span[text()='Create an account']")
	WebElement Createanaccount;
	
	@FindBy(xpath="//label[text()='Female']")
	WebElement FemaleRadiobutton;
	
	@FindBy(id="day")
	public WebElement DayDropdown;
	
	@FindBy(id="month")
	public WebElement MonthDropdown;
	
	@FindBy(id="year")
	public WebElement YearDropdown;
	
	@FindBy(xpath="//input[@value='Sign in']")
	public WebElement AlertSignin;
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String VerifyTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	
	public String VerifyUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void VerifyFirstname(String name)
	{
		Firstname.sendKeys(name);
	}
	
	public String VerifyCreate()
	{
		String str=Createanaccount.getText();
		return str;
	}
	
    
	public boolean VerifyRadio()
	{
		 return FemaleRadiobutton.isDisplayed();
	}
	
	public void Verifyemail(String username)
	{
		Emailorphone.sendKeys(username);
	}
	
	public void Verifypass(String password)
	{
		 Password.sendKeys(password);
	}
	
	public void VerifyTest(String username, String password) throws InterruptedException
	{
		Emailorphone.clear();
		Emailorphone.sendKeys(username);
		Thread.sleep(2000);
		Password.clear();
		Password.sendKeys(password);
		Thread.sleep(2000);
	}
	
	
	
	
	
	
}
