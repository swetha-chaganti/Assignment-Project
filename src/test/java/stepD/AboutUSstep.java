package stepD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUSstep {
	public static WebDriver driver;
	@Given("I enter into Playtech homepage")
	public void i_enter_into_playtech_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.playtech.com/");
		 String actualURL = driver.getCurrentUrl();
		 System.out.println(actualURL);
		 Assert.assertEquals("https://www.playtech.com/",actualURL);
	        System.out.println("Test Passed");
	}

	@When("once legal is confirmed")
	public void once_legal_is_confirmed() {
		WebElement dayDropDown= driver.findElement(By.name("day"));
		Select selectday= new Select(dayDropDown);
		selectday.selectByVisibleText("25");
		WebElement monthDropDown= driver.findElement(By.name("month"));
		Select selectMonth= new Select(monthDropDown);
		selectMonth.selectByVisibleText("05");	
		WebElement yearDropDown= driver.findElement(By.name("year"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText("1994"); 
		driver.findElement(By.cssSelector(".btn.btn-default.submit")).click();
	}

	@Then("click on {string} page")
	public void click_on_page(String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.linkText("About Us")).click();
	}

	@Then("user should display Number of Employees as {int}")
	public void user_should_display_number_of_employees_as(Integer int1) {
		WebElement Element = driver.findElement(By.linkText("Read More"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container-fluid flex-target']/div[1]/div[1]")));
		WebElement juridictions = driver.findElement(By.xpath("//div[@class='container-fluid flex-target']/div[1]/div[1]"));
		String expV="7000";
		Assert.assertEquals(expV, juridictions.getText());
		
		
	}

	@Then("user should display Number of countries Playtech has offices as {int}")
	public void user_should_display_number_of_countries_playtech_has_offices_as(Integer int1) {
		WebElement playtechOffices = driver.findElement(By.xpath("//div[@class='container-fluid flex-target']/div[2]/div[1]"));
		String officeCount =  playtechOffices.getAttribute("data-odometer-count");
		System.out.println(officeCount);
	}

	@Then("user should display Global licenses as {int}")
	public void user_should_display_global_licenses_as(Integer int1) {
		WebElement licenses = driver.findElement(By.xpath("//div[@class='container-fluid flex-target']/div[3]/div[1]"));
		String expVal="140";
		Assert.assertEquals(expVal, licenses.getText());
	}
	


}
