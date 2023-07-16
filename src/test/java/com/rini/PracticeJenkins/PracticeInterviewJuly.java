package com.rini.PracticeJenkins;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeInterviewJuly {

	WebDriver wd;
	WebDriverWait wait;
	Actions action;

	@BeforeMethod
	public void setup()
	// Basic setup for Selenium
	{
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\Chrome\\chromedriver.exe");

		wd = new ChromeDriver();
		action = new Actions(wd);
		// wd.get("http://www.calculator.net/");
		wd.get("https://www.browserstack.com");
		wd.manage().window().maximize();
		wait = new WebDriverWait(wd, 10);
	}

	@Test(enabled = true)
	public void validateLoginWithCorrectDetails() {

		// find the element in the DOM
		WebElement mathCalculator = wd
				.findElement(By.cssSelector("div#homelistwrap div:nth-of-type(3) div:nth-of-type(2) a"));
		mathCalculator.click();
		WebElement percent = wd.findElement(By.linkText("Percentage Calculator"));
		percent.click();
		WebElement input1 = wd.findElement(By.cssSelector("input#cpar1"));
		input1.sendKeys("10");
		WebElement input2 = wd.findElement(By.cssSelector("input#cpar2"));
		input2.sendKeys("50");

		WebElement calculate = wd
				.findElement(By.cssSelector(
						"#content > table:nth-child(8) > tbody > tr:nth-child(2) > td > input[type=image]:nth-child(2))"));
		calculate.click();

		WebElement result = wd.findElement(By.cssSelector("p.verybigtext font b"));
		result.getText();
		System.out.println(result);

	}

	@Test(enabled = true)
	public void testframe() {
		wd.get("https://www.browserstack.com");
		wd.navigate().to("https://www.browserstack.com/selenium");
		wd.navigate().forward();
		wd.navigate().back();
		wd.navigate().refresh();
		// wd.get("https://demo.guru99.com/test/guru99home/");
		// wd.switchTo().frame("a077aa5e");

		wd.navigate().to("https://jqueryui.com/droppable/");

		int size = wd.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		// wd.switchTo().frame(wd.findElement(By.cssSelector("iframe.demo-frame")));
		wd.switchTo().frame(0);
		WebElement source = wd.findElement(By.cssSelector("div#draggable"));
		source.click();
		WebElement target = wd.findElement(By.cssSelector("div#droppable"));
		action.dragAndDrop(source, target).build().perform();

	}

	@Test
	public void testwindowhandle() {
		wd.get("https://rahulshettyacademy.com/loginpagePractise/");
		wd.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> windows = wd.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		wd.switchTo().window(childid);
		System.out.println(wd.findElement(By.cssSelector("p.im-para.red")).getText());
		String email = wd.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);

		wd.switchTo().window(parentid);

	}


	@AfterMethod
	public void tearDown() {
		// wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// wd.close();
	}
}
