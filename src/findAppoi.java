import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class findAppoi {
	
	ArrayList<Data> retorno = new ArrayList<Data>();
	int encontrado;
	String month;
	String year;
	String consul;
	
	
	
	public WebDriver findApt(WebDriver driver, String month1, String nextYear) throws InterruptedException {
	
		findAppoi o = new findAppoi();
		
		
		driver.findElement(By.className("fa-calendar-alt")).click();
		//driver.findElement(By.className("continue_actions")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("small-only-expanded")).click();
		
		Select drpState = new Select(driver.findElement(By.id("appointments_consulate_appointment_facility_id")));
		Select drpHour = new Select(driver.findElement(By.id("appointments_consulate_appointment_time")));
		loadCalendar f = new loadCalendar();
		
		int indexState = 1;
		int encontrado = 0;
		String consul ="";
		int count=0;
		
		
		while(indexState <= 10 && encontrado == 0) {
					drpState.selectByIndex(indexState);
					WebElement selected = drpState.getFirstSelectedOption();
		            consul=selected.getText();
		            
		            
		           // f.getCargaCalendar(driver);
					Thread.sleep(1000);
					
					//validar escenario negativo cuando no carga el calendario
					//estudiar los waits
					if(driver.findElements(By.cssSelector("label[for='appointments_consulate_appointment_date']")).size() !=0){	
						driver.findElement(By.id("appointments_consulate_appointment_date")).click();
					}
					else{
						driver.navigate().refresh();
					}
					String year= driver.findElement(By.className("ui-datepicker-year")).getText();
					String month= driver.findElement(By.xpath("//span[@class= 'ui-datepicker-month']")).getText();
					
					while( (encontrado == 0 && ( !month.equals(month1)) || !year.equals(nextYear) )) {	
							
							if(driver.findElements(By.cssSelector("td[data-handler='selectDay']")).size() !=0) {
								
								retorno=o.SiCitas(driver);
								month=retorno.get(count).getMonth();
								year=retorno.get(count).getYear();
								System.out.println("SI HAY CITAS EN "+month+" "+year+ " "+consul);	
								driver.findElement(By.cssSelector("td[data-handler='selectDay']")).click();
								drpHour.selectByIndex(1);
							}
							else {	
								System.out.println("No hay citas en "+month+" "+year+" "+consul);	
								retorno=o.Nocitas(driver);
								driver=retorno.get(count).getDriver();
								encontrado=retorno.get(count).getEncontrado();

								month=retorno.get(count).getMonth();
								year=retorno.get(count).getYear();
								
								count=count+1;
						     }
						  
							
						} 
					indexState=indexState+1;
					driver.findElement(By.id("appointments_consulate_appointment_time")).click();
		}	
		
		
		return driver;
		}		
		

	public  ArrayList<Data> SiCitas(WebDriver driver) {
		
		encontrado= 1;
		month= driver.findElement(By.xpath("//span[@class= 'ui-datepicker-month']")).getText();
		year= driver.findElement(By.className("ui-datepicker-year")).getText();
		retorno.add(new Data(driver,encontrado,month,year));
			
		return retorno;
	}
	
	public ArrayList<Data> Nocitas(WebDriver driver) {
		
		driver.findElement(By.className("ui-icon-circle-triangle-e")).click();
		month= driver.findElement(By.xpath("//span[@class= 'ui-datepicker-month']")).getText();
		year= driver.findElement(By.className("ui-datepicker-year")).getText();
		encontrado=0;
		
		retorno.add(new Data(driver,encontrado,month,year));
		return retorno;
	}
}
