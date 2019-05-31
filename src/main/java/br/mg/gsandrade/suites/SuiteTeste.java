package br.mg.gsandrade.suites;
import static br.mg.gsandrade.core.DriverFactory.killDriver;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.gsandrade.test.TesteCampoTreinamento;
import br.mg.gsandrade.test.TesteFrame;
import br.mg.gsandrade.test.TesteGoogle;
import br.mg.gsandrade.test.TesteParametrizadoRegrasCadastro;
import br.mg.gsandrade.test.TestePreencherFormulario;
import br.mg.gsandrade.test.TesteRegras;
import br.mg.gsandrade.test.TesteValidacaoRegras;


@RunWith(Suite.class)
@SuiteClasses({
		TesteCampoTreinamento.class,
		TesteFrame.class,
		TesteGoogle.class,
		TestePreencherFormulario.class,
		TesteRegras.class,
		TesteParametrizadoRegrasCadastro.class,
		TesteValidacaoRegras.class
})

public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		killDriver();
	}
}
