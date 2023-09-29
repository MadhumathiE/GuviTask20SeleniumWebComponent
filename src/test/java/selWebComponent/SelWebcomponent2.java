package selWebComponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelWebcomponent2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("https://www.guvi.in/");
		driver.manage().window().maximize();
		Timeouts z = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//HomePage
		WebElement enter = driver.findElement(By.xpath("//li/a[text()=\"Sign up\"]"));
		enter.click();
		Thread.sleep(1000);
		//RegistrationPage
		WebElement fname = driver.findElement(By.id("firstName"));
		fname.sendKeys("Madhumathi");
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.sendKeys("E");
		WebElement mail = driver.findElement(By.id("emailInput"));
		mail.sendKeys("Madhu123456@gmail.com");
		WebElement pass = driver.findElement(By.id("passwordInput"));
		pass.sendKeys("Mad@123456");
		WebElement mob = driver.findElement(By.id("mobileNumberInput"));
		mob.sendKeys("1234567891");
		WebElement submit = driver.findElement(By.id("signup"));
		submit.click();
		Thread.sleep(1000);
		//GUVI
		String smsg = driver.findElement(By.xpath("//div/h2[@id='status_title']")).getText();
		if(smsg.contains("Successfully")) {
			System.out.println("Registration Success");
		}else {
			System.out.println("Registration Unsuccess");
		}
		WebElement proceed = driver.findElement(By.id("status_proceed"));
		proceed.click();

		//LoginPage
		WebElement user = driver.findElement(By.id("login_email"));
		user.sendKeys("Madhu123456@gmail.com");
		WebElement word = driver.findElement(By.id("login_password"));
		word.sendKeys("Mad@123456");
		WebElement suiii = driver.findElement(By.id("login_button"));
		suiii.click();

		String title = driver.getTitle();
		if(title.contains("courses")) {
			System.out.println("Login Successfull");
		}else {
			System.out.println("Login Unsuccessfull");
		}

		driver.close();

	}
}