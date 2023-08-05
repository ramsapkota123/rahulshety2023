package rahul.page;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class StandAloneTest {


	public static void main(String[] args) throws InterruptedException {
		
		String productName="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rbsap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setBinary("C:\\Users\\version115chrome\\chrome\\chrome-win64\\chrome.exe");
		options.setBinary("C:\\Users\\rbsap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver= new ChromeDriver(options);
		
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo();
		driver.manage().window().maximize();
		landingpage.loginApplication("aryashsapkota99@gmail.com", "Pranam1985@");
		
	
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		
		List <WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
//		
//		
		WebElement prod=products.stream().filter(product->
//		
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		Thread.sleep(4000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//        
//		
//		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//
//		//ng-animating
//		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> cartProducts =driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertFalse(match);
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		Thread.sleep(3000);
		
		String text=driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
		System.out.println("hello i am ram");
		
		
		
		

	}

}