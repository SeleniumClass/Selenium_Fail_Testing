package com.automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.LoginfunctionTest_1001;
import com.util.HighLighter;


public class ProductList_Selection extends LoginfunctionTest_1001 {

	static WebDriver driver;

	public static void main(String[] args) throws Throwable {


		ProductList_Selection obj = new ProductList_Selection();
		//driver = obj.login(driver);
		Thread.sleep(1500);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		WebElement catalog = driver.findElement(By.xpath("//*[contains(text(),'Catalog')]"));
		HighLighter.getDrawBlueColor(driver, catalog);
		catalog.click();

		Thread.sleep(1500);
		WebElement newProduct = driver.findElement(By.xpath("//*[contains(text(),'new products')]"));
		HighLighter.getDrawBlueColor(driver, newProduct);
		newProduct.click();
		Thread.sleep(1500);
		List<WebElement> allProduct = driver
				.findElements(By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"));

		Thread.sleep(1500);
		List<WebElement> pageNumber = driver.findElements(By.xpath("//*[contains(@class, 'pageResults')]"));
		
		System.out.println("Page number count::" + pageNumber.size());
		Actions ac = new Actions(driver);

	ArrayList<String> allproductName=new ArrayList<String> ();
		for (int i = 1; i < pageNumber.size(); i++) {
			pageNumber=driver.findElements(By.xpath("//*[contains(@class, 'pageResults')]"));
			ac.moveToElement(pageNumber.get(i)).click().perform();
		
			Thread.sleep(2000);
			System.out.println("");
			System.err.println("Total product on " + i + " page:::" + allProduct.size());
			System.out.println("========================================================");
			for (int j = 0; j < allProduct.size(); j++) {

				allProduct = driver
						.findElements(By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"));

				try {
			
					if (allProduct.get(j).getSize().getHeight() > 0) {

						new WebDriverWait(driver, 180).until(ExpectedConditions.numberOfElementsToBeMoreThan(
								By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"), 0));
						ac.moveToElement(allProduct.get(j)).build().perform();
						HighLighter.getDrawBlueColor(driver, allProduct.get(j));
						System.out.println("-----------------------------------------------------------");
						System.out.println("Product Name :::" + allProduct.get(j).getAttribute("title"));
						System.out.println("-----------------------------------------------------------");
						allproductName.add(allProduct.get(j).getAttribute("title"));
						

					}
				} catch (Exception e) {
					System.err.println(">>>not found product name");

				}
			}

			
			if (i==6) {
				break;
			}
		}
		System.out.println("");
		System.out.println("======================================================================");
		System.out.println("All products Name list::"+allproductName);
		System.out.println("======================================================================");
		System.out.println("");
		
		Map<String, Long> counts =
				allproductName.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println("=======================================================================");
		System.out.println("Products frequency count::"+counts);
		System.out.println("=======================================================================");
		
		List<String> matches = allproductName.stream().filter(it -> it.contains("Laptop")).collect(Collectors.toList());

		
		System.out.println(matches+"  got it and will buy");
		
		driver.quit();
		
	}

}
