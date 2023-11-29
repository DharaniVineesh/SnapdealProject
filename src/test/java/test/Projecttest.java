package test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.Projectbase;
import page.Projectpage;

public class Projecttest extends Projectbase {

	@Test
	public void test() throws Exception
	{
		Projectpage ob = new Projectpage(d);
		
		ob.enterproduct("Shoes",Keys.ENTER);
		ob.searchbar();
		
		Thread.sleep(3000);
		String parentWindow = d.getWindowHandle();
		Set<String> allWindow = d.getWindowHandles();
		for (String handle : allWindow) 
		{
			if (!handle.equalsIgnoreCase(parentWindow)) 
			{
				d.switchTo().window(handle);
				
				ob.addtocart();
				d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				ob.gotocart();
				//d.quit();
				
				FileInputStream ob1=new FileInputStream("C:\\Users\\dhaar\\OneDrive\\Desktop\\project1.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook(ob1);
				XSSFSheet sh=wb.getSheet("sheet1");
				int row= sh.getLastRowNum();
				for(int i=1;i<=row;i++)
				{
					String mobnum=sh.getRow(i).getCell(0).getRawValue();
					System.out.println("phonenumber = "+mobnum);
					ob.paymentlogin();
					
					ob.setValues(mobnum);
					d.navigate().refresh();
				}
					
					d.navigate().back();
					d.switchTo().window(parentWindow);
					
					ob.Signup();
					d.quit();
			}		
		
		}
	}

}
