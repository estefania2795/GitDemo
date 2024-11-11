import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class maintenance {

	
	public WebDriver getCheckMaintenance (WebDriver driver) {
		int flag1=0;
		
		while(flag1 == 0) {
			if(driver.findElements(By.className("clouds-animated")).size() !=0) {
				driver.navigate().refresh();
			}
			else {	
				flag1=1;	
		    }
		}
		return driver;
   }
}