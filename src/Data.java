import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Data {
	
	private WebDriver driver;
	private int encontrado;
	private String month;
	private String year;
	private String consul;
	
	
	
	public Data(WebDriver driver, int encontrado, String month, String year) {
		this.driver=driver;
		this.encontrado=encontrado;
		this.month = month;
		this.year=year;
		
	}
	
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public int getEncontrado() {
		return encontrado;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	
	

}
