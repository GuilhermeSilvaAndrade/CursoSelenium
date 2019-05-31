package br.mg.gsandrade.page;
import org.openqa.selenium.By;

import br.mg.gsandrade.core.BasePage;

public class PageValidacaoRegras extends BasePage {
		
		public void setBotaoCadastrar() {
			dsl.clica("elementosForm:cadastrar");
		}
		
		public String obtemTextoAlertaSimples() {
			return dsl.alertaObterTextoEAceita();
		}
		
		public void setFocoFramePrincipal() {
			dsl.sairFrame();
		}
		
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
		
		public void deselecionaOQueEEsporte() {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", "O que eh esporte?");
		}
		
		public void deselecionaEsporteNatacao() {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", "Natacao");
		}
		
		public void deselecionaEsporteFutebol() {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", "Futebol");
		}
		
		public void deselecionaEsporteCorrida() {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", "Corrida");
		}
		
		public void deselecionaEsporteKarate() {
			dsl.deselecionaComboPorTexto("elementosForm:esportes", "Karate");
		}
		
		public boolean verificaSeExistePopup() {
			return dsl.isAlertPresent();
		}
		
		public String verificaSeTextoCadastradoExiste() {
			String cadastrado = "Cadastrado!";
			String naoCadastrado = "Nao Cadastrado!";
			if (dsl.contemTexto(By.id("resultado"), cadastrado)==true)
				return cadastrado;
			else
				return naoCadastrado;
		}
}
