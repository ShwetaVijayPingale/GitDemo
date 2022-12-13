package testNG;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebtableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//sort veg name column using streams
		
		//1. click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//2.capture all the web elements in the list
		List<WebElement>elementList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//3. capturing text of all webelements into original list
		List<String>originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4. sort the original list and create new sorted list
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//5. Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		

		//get the price of beans 
		//scan the name column with getText --> Rice--> print the price of Rice 
		//using pagination printing rice price
		List<String>price;
		do
		{
			List<WebElement>rows=driver.findElements(By.xpath("//tr/td[1]"));
			price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s))
					.collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}while(price.size()<1);
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
