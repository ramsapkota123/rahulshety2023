package rahul.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.abstractt.AbstractComponets;

public class LandingPage extends AbstractComponets {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement btn;
	
	public void loginApplication(String email,String paswrd) {
		userEmail.sendKeys(email);
		password.sendKeys(paswrd);
		btn.click();
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	
		
	}
	
  

}
