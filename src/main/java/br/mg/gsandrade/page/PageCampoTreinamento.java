package br.mg.gsandrade.page;
import java.util.List;

import br.mg.gsandrade.core.BasePage;

public class PageCampoTreinamento extends BasePage {
	
		public void setNome(String nome) {
			dsl.escreve("elementosForm:nome", nome);
		}
		
		public void setSobrenome(String sobrenome) {
			dsl.escreve("elementosForm:sobrenome", sobrenome);
		}
		
		public void setSexoMasculino() {
			dsl.clica("elementosForm:sexo:0");
		}
		
		public void setSexoFeminino() {
			dsl.clica("elementosForm:sexo:1");
		}
		
		public void setComidaCarne() {
			dsl.clica("elementosForm:comidaFavorita:0");
		}
		
		public void setComidaFrango() {
			dsl.clica("elementosForm:comidaFavorita:1");
		}
		
		public void setComidaPizza() {
			dsl.clica("elementosForm:comidaFavorita:2");
		}
		
		public void setComidaVegetariano() {
			dsl.clica("elementosForm:comidaFavorita:3");
		}
		
		public void setEscolaridade(String valor) {
			dsl.selecionaComboPorTexto("elementosForm:escolaridade", valor);
		}
		
		public void setEsporte(String valor) {
			dsl.selecionaComboPorTexto("elementosForm:esportes", valor);
		}
		
		public void deselecionarEsporte(String valor) {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", valor);
		}
		
		public void setSugestao(String sugestao) {
			dsl.escreve("elementosForm:sugestoes", sugestao);
		}
		
		public void setBotaoCadastrar() {
			dsl.clica("elementosForm:cadastrar");
		}

		public void setBotaoSimples() {
			dsl.clica("buttonSimple");
		}
		
		public String obtemValorBotaoSimples() {
			return dsl.obtemValor("buttonSimple");
		}
		
		public String obtemValorNome() {
			return dsl.obtemValor("elementosForm:nome");
		}
		
		public String obtemValorSobreome() {
			return dsl.obtemValor("elementosForm:sobrenome");
		}

		public boolean isMasculinoSelected() {
			return dsl.isSelected("elementosForm:sexo:0");
		}
		
		public boolean isFemininoSelected() {
			return dsl.isSelected("elementosForm:sexo:1");
		}
		
		public boolean isCarneSelected() {
			return dsl.isSelected("elementosForm:comidaFavorita:0");
		}
		
		public boolean isFrangoSelected() {
			return dsl.isSelected("elementosForm:comidaFavorita:1");
		}
		
		public boolean isPizzaSelected() {
			return dsl.isSelected("elementosForm:comidaFavorita:2");
		}
		
		public boolean isVegetarianoSelected() {
			return dsl.isSelected("elementosForm:comidaFavorita:3");
		}
		
		public String obtemComboEscolaridade() {
			return dsl.obtemTextoCombo("elementosForm:escolaridade");
		}
		
		public boolean verificaExisteOpcaoEsporteNatacao() {
			return dsl.verificaOpcaoCombo("elementosForm:esportes", "Natacao");
		}
		
		public boolean verificaOpcaoEsporteNatacao() {
			return dsl.verificaOpcaoComboSelecionado("elementosForm:esportes", "Natacao");
		}
		
		public boolean verificaExisteOpcaoEsporteCorrida() {
			return dsl.verificaOpcaoCombo("elementosForm:esportes", "Corrida");
		}
		
		public boolean verificaOpcaoEsporteCorrida() {
			return dsl.verificaOpcaoComboSelecionado("elementosForm:esportes", "Corrida");
		}
		
		public boolean verificaExisteOpcaoEsporteFutebol() {
			return dsl.verificaOpcaoCombo("elementosForm:esportes", "Futebol");
		}
		
		public boolean verificaOpcaoEsporteFutebol() {
			return dsl.verificaOpcaoComboSelecionado("elementosForm:esportes", "Futebol");
		}
		
		public boolean verificaExisteOpcaoOQueEEsporte() {
			return dsl.verificaOpcaoCombo("elementosForm:esportes", "O que eh esporte?");
		}
		
		public boolean verificaOpcaoOQueEEsporte() {
			return dsl.verificaOpcaoComboSelecionado("elementosForm:esportes", "O que eh esporte?");
		}
				
		public int verificaQuantidadeEsportesSelecionados() {
			return dsl.quantidadeOpcoesComboSelecionadas("elementosForm:esportes");
		}
		
		public int verificaQuantidadeEsportesExistentes() {
			return dsl.quantidadeOpcoesCombo("elementosForm:esportes");
		}
		
		public String obtemValorSugestoes() {
			return dsl.obtemValor("elementosForm:sugestoes");
		}
		
		public int verificaQuantidadeOpcaoComboEscolaridade() {
			return dsl.quantidadeOpcoesCombo("elementosForm:escolaridade");
		}
		
		public List<String> obtemValoresComboEsportes() {
			return dsl.obtemValoresCombo("elementosForm:esportes");
		}
		
		public void clicaLinkVoltar() {
			dsl.clicaLink("Voltar");
		}
		
		public String obtemTextoLinkVoltar() {
			return dsl.obtemTexto("resultado");
		}
		
		public void clicaBotaoSimles() {
			dsl.clica("buttonSimple");
		}
		
		public String obtemTextobuttonSimple() {
			return dsl.obtemValor("buttonSimple");
		}
		
		public void clicaAlertaSimles() {
			dsl.clica("alert");
		}
		
		public String obtemTextoAlertaSimple() {
			return dsl.alertaObterTextoEAceita();
		}
		
		public String obtemResultado() {
			return dsl.validaTextoWebElement("resultado", "span");
		}
		
		public String obtemResultadoNome() {
			return dsl.validaTextoWebElement("descNome", "span");
		}
		
		public String obtemResultadoSobrenome() {
			return dsl.validaTextoWebElement("descSobrenome", "span");
		}
		
		public String obtemResultadoSexo() {
			return dsl.validaTextoWebElement("descSexo", "span");
		}
		
		public String obtemResultadoComida() {
			return dsl.validaTextoWebElement("descComida", "span");
		}
		
		public String obtemResultadoEscolaridade() {
			return dsl.validaTextoWebElement("descEscolaridade", "span");
		}
		
		public String obtemResultadoEsportes() {
			return dsl.validaTextoWebElement("descEsportes", "span");
		}
		
		public String obtemResultadoSugestoes() {
			return dsl.validaTextoWebElement("descSugestoes", "span");
		}
				
		
}
