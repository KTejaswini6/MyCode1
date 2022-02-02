package seleniumCodingChallenge;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class SeleniumCodingChallenge3 {
@Test

	public void Selenium() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String userId = driver.findElement(By.id("login_credentials")).getText().split("\n")[1];
		driver.findElement(By.id("user-name")).sendKeys(userId);
		String password = driver.findElement(By.className("login_password")).getText().split("\n")[1];
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		List<WebElement> price = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
		List<Double> priceList = new ArrayList<>();
		for (WebElement p : price) {
			String a = p.getText().substring(1);
			priceList.add(Double.parseDouble(a));
		}
		System.out.println("Price List :" + priceList);
		double maxPrice = 0;
		for (int i = 0; i < priceList.size(); i++) {
			if (priceList.get(i) > maxPrice) {
				maxPrice = priceList.get(i);
			}
		}
		System.out.println("Maximum Price :"+ maxPrice);
		int maxPriceIndexNum = priceList.indexOf(maxPrice);
		driver.findElements(By.xpath("//div[@class='pricebar']/button")).get(maxPriceIndexNum).click();
		driver.findElement(By.className("shopping_cart_link")).click();

	}

}
