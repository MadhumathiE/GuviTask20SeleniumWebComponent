package selWebComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelWebComponent1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");

		 // Switch to the iframe that contains the datepicker
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate the date input field and click on it to open the datepicker
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        dateInput.click();
        driver.findElement(By.xpath("//a[@title='Next']")).click();
        // Locate and click the "22" date element
        WebElement dateElement = driver.findElement(By.xpath("//a[text()='22']"));
        dateElement.click();

        // Get the selected date text
        String selectedDate = dateInput.getAttribute("value");

        // Print the selected date on the console
        System.out.println("Selected Date: " + selectedDate);

        // Close the browser window and quit the WebDriver instance
        driver.quit();
    }
	}

	


