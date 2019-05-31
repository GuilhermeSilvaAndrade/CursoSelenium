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

public class TesteRegras extends BaseTest {

	private DSL dsl;
	private PageValidacaoRegras page;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new PageValidacaoRegras();
	}
	
	@Test
	public void testeRegras() {
		
		//validate required name
		
		page.setBotaoCadastrar();

		Assert.assertEquals("Nome eh obrigatorio", page.obtemTextoAlertaSimples());

		page.setFocoFramePrincipal();

		
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());

		
		//validate required surname
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Sobrenome eh obrigatorio", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		//validate required sex
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Sexo eh obrigatorio", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();

		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
		
		//validate carnivore X vegetarian
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
		
		page.setComidaFrango();
		Assert.assertFalse(page.isFrangoSelected());
		
		//validate sports
		page.setEsporte("Natacao");
		Assert.assertTrue(page.verificaOpcaoEsporteNatacao());
		page.setEsporte("O que eh esporte?");
		Assert.assertTrue(page.verificaOpcaoOQueEEsporte());
		
		page.setBotaoCadastrar();
		
		Assert.assertEquals("Voce faz esporte ou nao?", page.obtemTextoAlertaSimples());
		
		page.setFocoFramePrincipal();
		
		page.deselecionaOQueEEsporte();
		Assert.assertFalse(page.verificaOpcaoOQueEEsporte());
		
		page.setBotaoCadastrar();
		
		WebElement resultado1 = dsl.encontraElemento(By.id("resultado"));
		WebElement resultado2 = resultado1.findElement(By.tagName("span"));
		String resultado3 = resultado2.getText();
		Assert.assertEquals("Cadastrado!", resultado3);	
		
		
	}

}
