package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.DSL;
import br.mg.gsandrade.page.PageCampoTreinamento;

public class TestePreencherFormulario extends BaseTest {

	private DSL dsl;
	private PageCampoTreinamento page;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new PageCampoTreinamento();
	}


	@Test
	public void testePreencheFormulario() {
		
		//Button click.
		page.setBotaoSimples();
		Assert.assertEquals("Obrigado!", page.obtemValorBotaoSimples());
	
		//Fill Name.
		page.setNome("Guilherme");
		Assert.assertEquals("Guilherme", page.obtemValorNome());
		
		//Fill last name.
		page.setSobrenome("Andrade");
		Assert.assertEquals("Andrade", page.obtemValorSobreome());
		
		//Choose sex.
		page.setSexoMasculino();
		Assert.assertTrue(page.isMasculinoSelected());
		
		//Select favorite food.
		page.setComidaPizza();
		Assert.assertTrue(page.isPizzaSelected());
		
		//Select schooling.
		page.setEscolaridade("Especializacao");
		Assert.assertEquals("Especializacao", page.obtemComboEscolaridade());
		
		//Select sport.
		page.setEsporte("Natacao");
		page.setEsporte("Corrida");
		
		boolean natacao = page.verificaOpcaoEsporteNatacao();
		Assert.assertTrue(natacao);
		
		boolean corrida = page.verificaOpcaoEsporteCorrida();
		Assert.assertTrue(corrida);
		
		int selecionados = page.verificaQuantidadeEsportesSelecionados();
		Assert.assertEquals(2, selecionados);

		
		//Fill suggestions.
		page.setSugestao("sugestoes");
		Assert.assertEquals("sugestoes", page.obtemValorSugestoes());
		
		//Link click.
		page.clicaLinkVoltar();
		Assert.assertEquals("Voltou!", page.obtemTextoLinkVoltar());
		
		//Text validate
		dsl.obtemTexto(By.tagName("body"));
		Assert.assertTrue(dsl.contemTexto(By.tagName("body"), "Campo de Treinamento"));
		
		dsl.obtemTexto(By.tagName("h3"));
		Assert.assertEquals("Campo de Treinamento", dsl.obtemTexto(By.tagName("h3")));
	
		dsl.obtemTexto(By.className("facilAchar"));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obtemTexto(By.className("facilAchar")));
		
		//Alert validate
		page.clicaAlertaSimles();
		String alertSimples = page.obtemTextoAlertaSimple();
		Assert.assertEquals("Alert Simples", alertSimples);
		
		//Register button
		page.setBotaoCadastrar();
	
		
		String cadastrado = page.obtemResultado();
		Assert.assertEquals("Cadastrado!", cadastrado);
		Assert.assertEquals("Cadastrado!", page.obtemResultado());

		
		//Using x-path
		//WebElement resposta = driver.findElement(By.xpath("//div[@id='resultado']/span"));
		//Assert.assertEquals("Cadastrado!", resposta.getText());
		
		//Validate answers
		//Name answer
		String resultadoNome = page.obtemResultadoNome();
		Assert.assertEquals("Guilherme", resultadoNome);
		Assert.assertEquals("Guilherme", page.obtemResultadoNome());
		
		//Last name answer
		String resultadoSobrenome = page.obtemResultadoSobrenome();
		Assert.assertEquals("Andrade", resultadoSobrenome);
		Assert.assertEquals("Andrade", page.obtemResultadoSobrenome());

		//Sex answer
		String resultadoSexo = page.obtemResultadoSexo();
		Assert.assertEquals("Masculino", resultadoSexo);
		Assert.assertEquals("Masculino", page.obtemResultadoSexo());
		
		//Food answer
		String resultadoComida = page.obtemResultadoComida();
		Assert.assertEquals("Pizza", resultadoComida);
		Assert.assertEquals("Pizza", page.obtemResultadoComida());
		
		//Schooling answer
		String resultadoEscolaridade = page.obtemResultadoEscolaridade();
		Assert.assertEquals("especializacao", resultadoEscolaridade);
		Assert.assertEquals("especializacao", page.obtemResultadoEscolaridade());
		
		//Sports answer
		String resultadoEsporte = page.obtemResultadoEsportes();
		Assert.assertEquals("Natacao Corrida", resultadoEsporte);
		Assert.assertEquals("Natacao Corrida", page.obtemResultadoEsportes());
		
		//Suggestions answer
		String resultadoSugestoes = page.obtemResultadoSugestoes();
		Assert.assertEquals("sugestoes", resultadoSugestoes);
		Assert.assertEquals("sugestoes", page.obtemResultadoSugestoes());

	}
	
	
}
