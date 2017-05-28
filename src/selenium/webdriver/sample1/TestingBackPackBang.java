package selenium.webdriver.sample1;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingBackPackBang {
	WebDriver driver;
	public void invokeBrowser(String url){
		try {
			
			 
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jar\\ChromeDriver\\chromedriver.exe"); 
			 driver = new ChromeDriver();			 
			 driver.manage().deleteAllCookies();     
			 driver.manage().window().maximize();	
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);														
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			 driver.get(url);
			} 
		catch (Exception e) {
			
			e.printStackTrace();
		} 	
		
		}
	public void ElementLocatorTechniqueUsingBackPack(){
		
		try {
			invokeBrowser("https://backpackbang.com/");
			 driver.findElement(By.linkText("Log In")).click();	//link text
			
			String originalHandle = driver.getWindowHandle();
			
			driver.findElement(By.xpath("//button[@class='facebook stretched icon']")).click();	 //xpath
			
			for(String handle : driver.getWindowHandles()) {		//closing all the tabs 
			        if (!handle.equals(originalHandle)) {
			            driver.switchTo().window(handle);
			            driver.close();
			        }
			    }
			
			driver.switchTo().window(originalHandle);
			
			driver.navigate().refresh();	
			//1st purchase 
			driver.findElement(By.id("search-home")).sendKeys("Bergamot Oil");
			driver.findElement(By.xpath("//button[@class='action xl animated']")).click();
			driver.findElement(By.partialLinkText("Beauty Aura Essential Oil")).click();
			driver.findElement(By.xpath("//button[@class='outline action icon']")).click();
			
			//2nd purchase
			driver.findElement(By.xpath("//li[@id='search-container']/form/input")).sendKeys("Headphone");
			driver.findElement(By.xpath("//li[@id='search-container']/form/input")).sendKeys(Keys.ENTER);
			driver.findElement(By.partialLinkText("Hamilton Buhl")).click();
			driver.findElement(By.xpath("//div[@id='item']/div/div[1]//aside/div/div[3]/button")).click(); //click add chart
			driver.navigate().refresh();			
			
			//The payment section and logout section will not work without cookie enabled and login
			//Shopping
			driver.findElement(By.xpath("//li[5]/ul/li/span")).click();	//shopping
			
			driver.findElement(By.xpath("//div[@id='cart-nav']/div/div[1]/a[1]")).click();		//chart
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='cart']/div/section/div[2]/div/button")).click();	//pay
			driver.findElement(By.xpath("//div[@id='checkout']/div//div/ul/li[1]/div[2]/div[2]/button")).click();	//bkash
			
			
			//logout
			driver.findElement(By.xpath("//li[6]/ul/li[4]/span")).click();
			driver.findElement(By.id("logoutLink"));
			
			//Close the browser
			Thread.sleep(5000);
			driver.quit();
			
			//WebElement.sendKeys(Keys.RETURN);
			
			
			} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		TestingBackPackBang bang = new TestingBackPackBang();
		bang.ElementLocatorTechniqueUsingBackPack();

	}

}
