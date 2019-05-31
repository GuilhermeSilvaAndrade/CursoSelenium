package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.DSL;
import br.mg.gsandrade.page.PageValidacaoRegras;

public class TesteValidacaoRegras extends BaseTest {
	
	private DSL dsl;
	private PageValidacaoRegras page;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new PageValidacaoRegras();
	}

	
	@Test
	public void testeRegraNome() {
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Nome eh obrigatorio", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
	}
	
	@Test
	public void testeRegraSobrenome() {
		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Sobrenome eh obrigatorio", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
	}
	
	@Test
	public void testeRegraSexo() {
		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Sexo eh obrigatorio", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();		
	}
	
	@Test
	public void testeRegraComida() {
		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
		
		page.setComidaCarne();
		Assert.assertTrue(page.isCarneSelected());
		
		page.setComidaVegetariano();
		Assert.assertTrue(page.isVegetarianoSelected());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
		page.setComidaCarne();
		Assert.assertFalse(page.isCarneSelected());
		
		page.setComidaFrango();
		Assert.assertTrue(page.isFrangoSelected());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
	}
	
	@Test
	public void testeRegraSport() {
		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
		
		page.setComidaVegetariano();
		Assert.assertTrue(page.isVegetarianoSelected());
		
		page.setEsporte("Natacao");
		Assert.assertTrue(page.verificaOpcaoEsporteNatacao());
		page.setEsporte("O que eh esporte?");
		Assert.assertTrue(page.verificaOpcaoOQueEEsporte());
		
		Assert.assertEquals(2, page.verificaQuantidadeEsportesSelecionados());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Voce faz esporte ou nao?", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
	}
	
	@Test
	public void testeRegraCadastrado() {
		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
		
		page.setComidaVegetariano();
		Assert.assertTrue(page.isVegetarianoSelected());
		
		page.setEsporte("Natacao");
		Assert.assertTrue(page.verificaOpcaoEsporteNatacao());
		
		page.setBotaoCadastrar();

		WebElement resultado1 = dsl.encontraElemento(By.id("resultado"));
		WebElement resultado2 = resultado1.findElement(By.tagName("span"));
		String resultado3 = resultado2.getText();
		Assert.assertEquals("Cadastrado!", resultado3);	
		
	}
	
}
