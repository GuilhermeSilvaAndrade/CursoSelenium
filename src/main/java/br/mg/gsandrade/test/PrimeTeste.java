package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import static br.mg.gsandrade.core.DriverFactory.killDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import br.mg.gsandrade.core.DSL;


public class PrimeTeste {

	private DSL dsl;
	
	@Before
	public void inicializa() {

		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		

		dsl.clicaBy(By.xpath("//input[@id='j_idt698:console:0']/../..//span"));
		Assert.assertTrue(dsl.isSelected("j_idt698:console:0"));
		
		dsl.clicaBy(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isSelected("j_idt698:console:1"));

	}
	
}
