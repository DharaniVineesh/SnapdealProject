package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Projectbase {
	public static WebDriver d;

	@BeforeTest
	public void setUp()
	{
		d = new ChromeDriver();
		d.get("https://www.snapdeal.com");
		d.manage().window().maximize();
		// Thread.sleep(3000);
	}
}
