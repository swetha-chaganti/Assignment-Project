package stepD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class legalAgeStep {
	public static WebDriver driver;
	String url="https://www.playtech.com/";
	@Given("user is on the Home Page {string}")
	public void user_is_on_the_home_page(String string) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("user should enter legal age before entering the site")
	public void user_should_enter_legal_age_before_entering_the_site() {
		WebElement dayDropDown= driver.findElement(By.name("day"));
		Select selectday= new Select(dayDropDown);
		selectday.selectByVisibleText("14");
		WebElement monthDropDown= driver.findElement(By.name("month"));
		Select selectMonth= new Select(monthDropDown);
		selectMonth.selectByVisibleText("08");	
		WebElement yearDropDown= driver.findElement(By.name("year"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText("1991");  
	}

	@Then("user should be able to successfully enter into the homepage")
	public void user_should_be_able_to_successfully_enter_into_the_homepage() {
		driver.findElement(By.cssSelector(".btn.btn-default.submit")).click();
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Playtech - the source of success";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
	}

	@When("user enters invalid age for entering the site")
	public void user_enters_invalid_age_for_entering_the_site() {
		WebElement dayDropDown= driver.findElement(By.name("day"));
		Select selectday= new Select(dayDropDown);
		selectday.selectByVisibleText("14");
		WebElement monthDropDown= driver.findElement(By.name("month"));
		Select selectMonth= new Select(monthDropDown);
		selectMonth.selectByVisibleText("03");	
		WebElement yearDropDown= driver.findElement(By.name("year"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText("2007");
	}

	@Then("user should throw an error message")
	public void user_should_throw_an_error_message() {
		driver.findElement(By.cssSelector(".btn.btn-default.submit")).click();
		String actual_msg=driver.findElement(By.className("age-error")).getText();
		String exp_msg="Sorry you must be over 18 to enter";
		Assert.assertEquals(actual_msg, exp_msg);
		System.out.println("Assertion Failed");
	   
	}

}
