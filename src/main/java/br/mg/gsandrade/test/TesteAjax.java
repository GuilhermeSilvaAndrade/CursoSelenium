package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import static br.mg.gsandrade.core.DriverFactory.killDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.mg.gsandrade.core.DSL;

public class TesteAjax {

	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void testeAjax() throws InterruptedException {
		 dsl.escreve("j_idt697:name", "texto");
		 dsl.clica("j_idt697:j_idt700");
		 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		 wait.until(ExpectedConditions.textToBe(By.id("j_idt697:display"), "texto"));
		 Assert.assertTrue(dsl.contemTexto(By.id("j_idt697:display"), "texto"));
	}
	
	@Test
	public void testeAjaxDois() throws InterruptedException {
		 dsl.escreve("j_idt697:name", "texto");
		 dsl.clica("j_idt697:j_idt700");
		 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='j_idt712_start']/i")));
		 Assert.assertTrue(dsl.contemTexto(By.id("j_idt697:display"), "texto"));
	}
	
}
