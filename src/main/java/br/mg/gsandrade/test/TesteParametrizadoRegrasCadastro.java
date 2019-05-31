package br.mg.gsandrade.test;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.page.PageValidacaoRegras;


@RunWith(Parameterized.class)
public class TesteParametrizadoRegrasCadastro extends BaseTest {
	
	private PageValidacaoRegras page;
	
	@Parameter(value=0)
	public String nome;
	
	@Parameter(value=1)
	public String sobreNome;
	
	@Parameter(value=2)
	public String sexo;
	
	@Parameter(value=3)
	public List<String> comidas;
	
	@Parameter(value=4)
	public String[] esportes;
	
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {

		getDriver().get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		page = new PageValidacaoRegras();
	}
	
	@Parameters 
	public static Collection<Object[]> getCollection(){
		
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Guilherme", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"Guilherme", "Andrade", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"Guilherme", "Andrade", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {}, 
				"Tem certeza que voce eh vegetariano?"},
			{"Guilherme", "Andrade", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, 
				"Voce faz esporte ou nao?"},
			{"Guilherme", "Andrade", "Masculino", Arrays.asList("Carne"), new String[]{"Karate"}, "Cadastrado!"}
		});
	}
	
	@Test
	public void deveValidarRegras() throws InterruptedException {
		
		page.setNome(nome);	
		
		page.setSobrenome(sobreNome);	
		
		
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}
		
		if(sexo.equals("Feminino"))  {
			page.setSexoFeminino();
		}
		
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Frango")) page.setComidaFrango();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
		
		for(int i=0; i<esportes.length; i++) {
			page.setEsporte(esportes[i]);
		}
		
		page.setBotaoCadastrar();
		Thread.sleep(3000);
		
		if (page.verificaSeExistePopup()==true)
			Assert.assertEquals(msg, page.obtemTextoAlertaSimples());
		else 
			Assert.assertEquals(msg, page.verificaSeTextoCadastradoExiste());
		
		System.out.println(msg);
		System.out.println(page.verificaSeTextoCadastradoExiste());
		
		page.setFocoFramePrincipal();

	}
	

}
