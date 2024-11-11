import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		openLogin m = new openLogin();
		findAppoi o = new findAppoi();
		String email = "cinhortahdez@gmail.com";
		String pwd = "AA00D8GIFF";
		String month1= "September";
		//String thisYear = "2024";
		String nextYear = "2025";
		
		m.getLogin(driver,email, pwd);
		o.findApt(driver, month1, nextYear);
			
	}

}
