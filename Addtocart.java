import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prasa\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] itemsAdded = {"Brocolli", "Cauliflower", "Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsAdded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		WebElement staticdropdown = driver.findElement(By.cssSelector("div[class='wrapperTwo'] div select"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("div[class='wrapperTwo'] button")).click();
		
	}

	public static void addItems(WebDriver driver, String[] itemsAdded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String updatedName = name[0].trim();

			List itemsaaddedIntoCart = Arrays.asList(itemsAdded);

			if (itemsaaddedIntoCart.contains(updatedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (j == itemsAdded.length) {
					break;
				}

			}

		}
	}
}
