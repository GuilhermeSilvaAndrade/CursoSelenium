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

public class TesteFrame {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void testeValidaAlertSimples() {
		
		dsl.clica("alert");
		String valor = dsl.alertaObterTextoEAceita();

		Assert.assertEquals("Alert Simples", valor);
		dsl.escreve("elementosForm:nome", valor);

	}	
	
	@Test
	public void testeValidaAlertConfirm() {

		//Aceitar alert
		dsl.clica("confirm");
		String ok = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Confirm Simples", ok);
		String confirmado = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Confirmado", confirmado);
		
		//Negar alert
		dsl.clica("confirm");
		String nao = dsl.alertaObterTextoENega();
		Assert.assertEquals("Confirm Simples", nao);
		String negado = dsl.alertaObterTextoENega();
		Assert.assertEquals("Negado", negado);
	}

	@Test
	public void testeValidaPrompt() {

		dsl.clica("prompt");
		String prompt = dsl.alertaObterTextoEEscrever("12");
		Assert.assertEquals("Digite um numero", prompt);
		String resultado = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Era 12", resultado);
		String smile = dsl.alertaObterTextoEAceita();
		Assert.assertEquals(":D", smile);
	}
	
	@Test
	public void testeFrame() {
		
		dsl.entrarFrame("frame1");
		dsl.clica("frameButton");
		String alertText = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", alertText);
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", alertText);		
	}
	
	@Test
	public void testeFrameEscondido() {
		
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clica("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void testePopup() {
		
		dsl.clica("buttonPopUpEasy");
		
		dsl.trocarJanela("Popup");

		String textoPopup = dsl.windowEscreverEObter("Teste Janela");

		dsl.fecharJanela();
		
		dsl.trocarJanela("");

		dsl.escreve("elementosForm:sugestoes", textoPopup);
		Assert.assertEquals(textoPopup, dsl.obtemValor("elementosForm:sugestoes"));
		
	}
	
	@Test
	public void testeWindowHandle() {
		
		dsl.clica("buttonPopUpHard");
				
		dsl.trocarJanela((String)getDriver().getWindowHandles().toArray()[1]);
		
		String windowHandle = dsl.windowEscreverEObter("Teste WindowHandle");
		
		dsl.fecharJanela();

		dsl.trocarJanela((String)getDriver().getWindowHandles().toArray()[0]);
		
		dsl.escreve("elementosForm:sugestoes", windowHandle);
		
	}
	
	
	
}
