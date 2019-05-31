package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import static br.mg.gsandrade.core.DriverFactory.killDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.gsandrade.core.DSL;

public class PrimeDesafio {
	
	private DSL dsl;

	
	@Before
	public void inicializa() {

		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
		//driver.quit();
	}
	
	@Test
	public void desafioPrimeFaces() {
		//combo1
		dsl.clicaBy(By.xpath("//label[@id='j_idt698:j_idt701']/../..//span"));
		dsl.clicaBy(By.xpath("//*[@id='j_idt698:console_items']//li[.='PS4']"));
		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@id='j_idt698:console_label']"), "PS4"));
	
		//combo2
		dsl.clicaBy(By.xpath("//label[@id='j_idt698:j_idt706']/../..//span"));
		dsl.clicaBy(By.xpath("//li[@id='j_idt698:car_1']"));
		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@id='j_idt698:car_label']"), "BMW"));
		
		//combo3
		dsl.clicaBy(By.xpath("//*[@id='j_idt698:city_input']/../..//input[@name='j_idt698:city_editableInput']"));
		WebElement element = getDriver().findElement(By.xpath("//*[@id='j_idt698:city_input']/../..//input[@name='j_idt698:city_editableInput']"));
		element.sendKeys("Berlin");
		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@name='j_idt698:city_editableInput']"), "Berlin"));
		
		//outra opção para combo 3, porem tambem não funciona! :(		
//		dsl.clicaBy(By.xpath("//label[@id='j_idt698:j_idt709']/../..//span"));
//		WebDriverWait wait = new WebDriverWait(driver, 10); //here, wait time is 10 seconds
//		WebElement element = driver.findElement(By.xpath("//li[@id='j_idt698:city_3']"));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		dsl.clicaBy(By.xpath("//li[@id='j_idt698:city_3']"));
//		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@name='j_idt698:city_editableInput']"), "Berlin"));

		//combo4
		dsl.clicaBy(By.xpath("//label[@id='j_idt698:j_idt712']/../..//span"));
		dsl.clicaBy(By.xpath("//tr[@id='j_idt698:advanced_4']"));
		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@id='j_idt698:advanced_label']"), "Luna-Amber"));

		//combo5
		dsl.clicaBy(By.xpath("//label[@id='j_idt698:j_idt718']/../..//span"));
		dsl.clicaBy(By.xpath("//*[@id='j_idt698:lazy_items']//li[.='Option 2']"));
		Assert.assertTrue(dsl.contemTexto(By.xpath("//*[@id='j_idt698:lazy_label']"), "Option 2"));
		
	}

}
