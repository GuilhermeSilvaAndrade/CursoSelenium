package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.DSL;
import br.mg.gsandrade.page.PageCampoTreinamento;


public class TesteCampoTreinamento extends BaseTest {
	
	private DSL dsl;
	private PageCampoTreinamento page;
	
	@Before
	public void inicializa() {
		
		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new PageCampoTreinamento();
	}
	
	@Test
	public void testeTextFieldNome() {
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
	}
	
	@Test
	public void testeTextFieldSobrenome() {
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
	}
	
	@Test
	public void testeRadioButtonMasculino() {
		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
	}
	
	@Test
	public void testeCheckBox() {
		page.setComidaPizza();
		Assert.assertTrue(page.isPizzaSelected());
	}
	
	@Test
	public void testeComboBox() {
		page.setEscolaridade("Superior");
		Assert.assertEquals("Superior", page.obtemComboEscolaridade());
	}
	
	@Test
	public void testeVerificaListaComboBox() {
		
		page.setEscolaridade("Superior");
		Assert.assertEquals("Superior", page.obtemComboEscolaridade());

		//Verifies the size of the list.
		int numero = page.verificaQuantidadeOpcaoComboEscolaridade();
		System.out.println(numero);
	}
	
	@Test
	public void testeComboMultiplaEscolha() {
		
		page.setEsporte("Natacao");
		page.setEsporte("Futebol");
		page.setEsporte("Corrida");
		
		System.out.println(page.obtemValoresComboEsportes());
		
		//deselecionar opcao
		Assert.assertTrue(page.verificaExisteOpcaoEsporteFutebol());
		Assert.assertTrue(page.verificaOpcaoEsporteFutebol());

		page.deselecionarEsporte("Futebol");

		page.verificaQuantidadeEsportesSelecionados();

		Assert.assertTrue(page.verificaExisteOpcaoEsporteFutebol());
		Assert.assertFalse(page.verificaOpcaoEsporteFutebol());

		System.out.println(page.verificaQuantidadeEsportesExistentes());
		System.out.println(page.verificaQuantidadeEsportesSelecionados());

	}
	
	@Test
	public void testeTextArea() {
		page.setSugestao("sugestoes");
		Assert.assertEquals("sugestoes", page.obtemValorSugestoes());
	}
	
	@Test
	public void testeBotao() {
		page.clicaBotaoSimles();
		Assert.assertEquals("Obrigado!", page.obtemTextobuttonSimple());
	}
	
	@Test
	public void testeLink() {
		page.clicaLinkVoltar();
		Assert.assertEquals("Voltou!", page.obtemTextoLinkVoltar());
	}
	
	@Test
	public void testeValidaTexto() {

		
		Assert.assertTrue(dsl.contemTexto(By.tagName("body"), "Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", dsl.obtemTexto(By.tagName("h3")));

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obtemTexto(By.className("facilAchar")));
		
		System.out.println(dsl.obtemTexto(By.tagName("body")));

	}
	
	@Test
	public void testJavaScript() {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("alert('Testando js via selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
	}
	
	@Test
	public void deveInteragirEsperaFixa() throws InterruptedException {
		dsl.clica("buttonDelay");
		dsl.esperaFixa();
		dsl.escreve("novoCampo", "teste");
	}
	
	@Test
	public void deveInteragirEsperaImplicita() throws InterruptedException {
		dsl.clica("buttonDelay");
		dsl.esperaImplicita();
		dsl.escreve("novoCampo", "teste");
	}
	
	@Test
	public void deveInteragirEsperaExplicita() throws InterruptedException {
		dsl.clica("buttonDelay");
		dsl.esperaExplicita("novoCampo");
		dsl.escreve("novoCampo", "teste");
	}
		
}	
