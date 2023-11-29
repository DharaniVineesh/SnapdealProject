package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.Projectbase;

public class Projectpage extends Projectbase {
	@FindBy (id="inputValEnter")
	WebElement search;
	@FindBy (xpath="//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[2]/button")
	WebElement clksearch;
	@FindBy (xpath="//*[@class=\"dp-widget-link noUdLine hashAdded\"]")
	WebElement clkproduct;
	@FindBy (xpath="//*[@id=\"add-cart-button-id\"]/span")
	WebElement addtocart;
	@FindBy (xpath="//*[@id=\"cartProductContainer\"]/div/div[2]/div[2]/div/div[2]/div")
	WebElement viewcart;
	@FindBy (xpath="//*[@class=\"btn btn-xl rippleWhite cart-button\"]")
	WebElement Proceedtopay;
	@FindBy (id="username")
	WebElement mobnumber;
	@FindBy (xpath="//*[@id=\"login-continue\"]")
	WebElement paycntnue;
	@FindBy (xpath="//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/span[1]")
	WebElement hoversignup;
	@FindBy (xpath="//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]")
	WebElement login;
	
	public Projectpage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	@Test
	public void enterproduct(String sch, Keys enter)
	{
		search.sendKeys(sch);
	}
	public void searchbar()
	{
		search.click();
		clksearch.click();
		clkproduct.click();
	}
	public void addtocart()
	{
		addtocart.click();
	}
	public void gotocart()
	{
		viewcart.click();
		Proceedtopay.click();
	}
	public void paymentlogin()
	{
		mobnumber.click();	
		paycntnue.click();
	}

	public void setValues(String mobnum) 
	{
		mobnumber.sendKeys(mobnum);
	}
	public void Signup()
	{
		Actions act=new Actions(d);
		act.moveToElement(hoversignup).perform();
		login.click();
	}

}
