import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class openLogin {
	
	
	
	public WebDriver getLogin(WebDriver driver, String email, String pwd) throws InterruptedException {
		maintenance m = new maintenance();
		driver.manage().deleteAllCookies();
		driver.get("https://ais.usvisa-info.com/es-mx/niv/users/sign_in");
		driver.manage().window().maximize();
		m.getCheckMaintenance(driver);
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.className("icheckbox")).click();
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Continuar")).click();
		
		m.getCheckMaintenance(driver);
		return driver;
		
		
	}
	
	

}
