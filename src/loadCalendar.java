import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loadCalendar {
	
	public WebDriver getCargaCalendar(WebDriver driver) {
		int flag = 0;
		while (flag==0) {
			if(driver.findElements(By.id("appointments_consulate_appointment_date")).size() !=0) {
				driver.navigate().refresh();
			}
			else {	
				flag=1;
				driver.findElement(By.id("appointments_consulate_appointment_date")).click();
		    }

		}return driver;
		
	}

}
