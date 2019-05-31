package br.mg.gsandrade.core;
import static br.mg.gsandrade.core.DriverFactory.getDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	public WebElement encontraElemento(By by) {
		return getDriver().findElement(by);
	}
	
	public WebElement encontraElemento(String id) {
		return encontraElemento(By.id(id));
	}
	
	public String obtemTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obtemTexto(String id_campo) {
		return obtemTexto(By.id(id_campo));
	}
	
	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		//getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
	}
	
	
	public String obtemValor(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
		//getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value")
	}
	
	public void clicaBy(By by) {
		getDriver().findElement(by).click();
		//getDriver().findElement(By.id("elementosForm:sexo:0")).click();
	}
	
	public void clica(String id) {
		clicaBy(By.id(id));
		//getDriver().findElement(By.id(id)).click();
		//getDriver().findElement(By.id("elementosForm:sexo:0")).click();
	}
	
	public void clicaLink(String linkText) {
		
		getDriver().findElement(By.linkText(linkText)).click();
		//getDriver().findElement(By.linkText("Voltar")).click();
	}
	
	public boolean isSelected(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
		//getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).isSelected()
	}
	
	public String validaTextoWebElement(String id, String tagName) {
		//String texto = getDriver().findElement(By.id("resultado")).findElement(By.tagName("span")).getText();
		String texto = getDriver().findElement(By.id(id)).findElement(By.tagName(tagName)).getText();
		return texto;
	}
	
	public boolean contemTexto(By by, String texto) {
		return getDriver().findElement(by).getText().contains(texto);
		//Assert.assertTrue(getDriver().findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
	}
	
	public void selecionaComboPorTexto(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionaComboPorTexto(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obtemTextoCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obtemValoresCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> todasOpcoesSelecionadas = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao: todasOpcoesSelecionadas) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int quantidadeOpcoesCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> todasOpcoesSelecionadas = combo.getOptions();
		return todasOpcoesSelecionadas.size();
	}
	
	public int quantidadeOpcoesComboSelecionadas(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> todasOpcoesSelecionadas = combo.getAllSelectedOptions();
		return todasOpcoesSelecionadas.size();
	}
	
	public boolean verificaOpcaoCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option: options) {
			if(option.getText().equals(opcao)) {
				return true;
			}				
		}
		return false;
	}
	
	public boolean verificaOpcaoComboSelecionado(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getAllSelectedOptions();
		for (WebElement option: options) {
			if(option.getText().equals(opcao)) {
				return true;
			}				
		}
		return false;
	}
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public boolean isAlertPresent() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(TimeoutException e) {
			return false;
		}
	}
	
	public String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;	
	}
	
	public String alertaObterTextoEEscrever(String valorEscrito) {
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.sendKeys(valorEscrito);
		alert.accept();
		return texto;
	}
	
	public String windowEscreverEObter(String valorEscrito) {
		WebElement textarea = getDriver().findElement(By.tagName("textarea"));
		textarea.sendKeys(valorEscrito);
		String texto = textarea.getAttribute("value");
		return texto;
	}
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	public void fecharJanela() {
		getDriver().close();
	}
	
	/*********************** JS *****************/
	
	public Object executarJS(String cmd, Object... param) {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
		//js.executeScript("alert('Testando js via selenium')");
		//js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		//js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		//WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		//js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		
	}
	
	/*********************** TABELA *****************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar a coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = 0;
		for(int i=0; i<linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = 0;
		for(int i=0; i<colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}

	/****************************** WAITS********************************************/
	
	public void esperaFixa() throws InterruptedException {

		Thread.sleep(5000);

	}
	
	public void esperaImplicita() throws InterruptedException {

		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	public void esperaExplicita(String id) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(id)));

	}
		
}
