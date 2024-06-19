package lesson9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	WebDriver driver = new ChromeDriver();
	String myUrl = "https://www.saucedemo.com/";
	
	String userName= "standard_user";
	String password = "secret_sauce";
	
	@BeforeTest ()
	public void mySetUp () {
		driver.manage().window().maximize();
		driver.get(myUrl);
	}
	
	@Test (priority = 1)
	public void logIn () {
		WebElement userNameInput = driver.findElement(By.id("user-name"));
		userNameInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		WebElement logIN = driver.findElement(By.id("login-button"));
		logIN.click();
		
	}
	// هون بنضيف كل العناصر
	@Test(priority = 2, enabled =  false)
	public void addAllItems() {
		List<WebElement> myAddToCartButtons = driver.findElements(By.className("btn"));
		for(int i =0 ; i<myAddToCartButtons.size(); i++) {
			myAddToCartButtons.get(i).click();
		}
	}
	
	// هون بعد ما ضفنا كل العناصر 
	// بدي امسح العنصر رقم 1/3/5 
	@Test (priority = 3, enabled =  false)
	public void deletSomeItems()throws InterruptedException {
		Thread.sleep(3);
		List<WebElement> deleteItems = driver.findElements(By.className("btn"));
		for(int i = 1 ; i<deleteItems.size(); i=i+2) {
			deleteItems.get(i).click();
		}
	}
	// هون بدي اضيف اول اربعة عناصر 
	@Test(priority = 4 , enabled = false)
	public void addsomeItems () {
		List<WebElement> addSomeItems = driver.findElements(By.className("btn"));
		for (int i = 0 ; i<addSomeItems.size(); i ++) {
			addSomeItems.get(i).click();
			if (i==3) {
				break;
			}
		}
	}
	//هون بدنا نضيف كل العناصر باستثناء العنصر رقم 3
	@Test(priority = 5, enabled = false)
	public void addAllItemsExeptForTheNumber3 () {
		List<WebElement> addSomeItemsExeptForTheNumber = driver.findElements(By.className("btn"));
		for (int i = 0 ; i<addSomeItemsExeptForTheNumber.size(); i ++) {
			
			if (i==2) {
				continue;
				}
			addSomeItemsExeptForTheNumber.get(i).click();

		}
	}
	
	// هون راح نضيف كل العناصر التي  تحتوي على كلمة 
	// "labs"
	@Test (priority = 6 , enabled = false)
	public void addAllItemsExeptForTheWordsLabs() {
		List<WebElement> itemsName = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> addItems = driver.findElements(By.className("btn"));
		
		for(int i = 0; i<itemsName.size(); i++) {
			String itemName = itemsName.get(i).getText();
			
			if(itemName.contains("Labs")) {
				addItems.get(i).click();
			}
		}
	}
	
	@Test (priority = 7)
	public void addAllItemsAPriceBiggerThan15() {
		List<WebElement> priceItems = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> addBiggerPrice = driver.findElements(By.className("btn"));
		
		for(int i = 0; i<priceItems.size(); i++) {
			
			String price = priceItems.get(i).getText().replace("$", "");
			double prices = Double.parseDouble(price);
			if(prices<15) {
				addBiggerPrice.get(i).click();
			}
		}
	}
	
}
