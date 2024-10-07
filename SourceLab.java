package PawanSirAutomationConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SourceLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]")).click();
		String expectedItem="Sauce Labs Bike Light";
		WebElement text=driver.findElement(By.xpath("//div[text()=\"Sauce Labs Bike Light\"]"));	
		System.out.println(text.getText());
		if(expectedItem.equals(text))
		{
			System.out.println("proceed for checkout");
			
		}
		
		
		driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Jyoshna");
		driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Majhi");
		driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("412207");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
		
		
		//Verify Checkout message
		
		String expectedText="Thank you for your order!";
		WebElement actualtext=driver.findElement(By.xpath("//h2[text()=\"Thank you for your order!\"]"));
		actualtext.getText();
		if(expectedText.equals(actualtext))
		{
			System.out.println("Proceed for test pass");
		}
		
		driver.findElement(By.xpath("//button[@id=\"back-to-products\"]")).click();
	}

}
