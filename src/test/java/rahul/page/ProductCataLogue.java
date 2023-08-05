package rahul.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahul.abstractt.AbstractComponets;

public class ProductCataLogue extends AbstractComponets {
	WebDriver driver;
	public ProductCataLogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	By productsBy =By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToApper(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductTOCart(String productName) {
		WebElement prod= getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastMessage);
	}
	
	
	
	
	
	
		
	
	
  

}
