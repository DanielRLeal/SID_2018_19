package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bancoDeDados.BancoDeDados;
import bancoDeDados.Utilizador;

class UtilizadorTest {

	@Test
	void test() {
		/**
		 * Test:
		 * add users,
		 * verify they exist.
		 */

		int ID = 2;
		String nomeUtilizador = new String ("Investigador2");
		String categoriaProfissional = new String ("Investigador");
		String email = new String("investigador2@iscte.pt");
		boolean ativo = true;
		

		BancoDeDados db = new BancoDeDados();
		Utilizador userTest = new Utilizador(ID, nomeUtilizador, categoriaProfissional, email, ativo);

		db.inserirUtilizador(nomeUtilizador, "root", categoriaProfissional, email, ativo);
		
		boolean userEntry = db.listarUtilizador().contains(userTest);
		assertEquals (true, userEntry);
	}
}