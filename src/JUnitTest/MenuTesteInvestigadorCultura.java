package JUnitTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;

class MenuInvestigadorCulturaTest {

	@Test
	
	void test() {
		
		/**
		   * Test:
		   * frame is visible,
		   * opens with the correct width and height.
		  */
		
		BancoDeDados bd = new BancoDeDados();
        bd.conectar("root", "");
		
		menu_Investigador testeMenuCultura = new menu_Investigador(bd);
		
		boolean visible = testeMenuCultura.getFrame().isVisible();
		int width = testeMenuCultura.getFrame().getWidth();
		int height = testeMenuCultura.getFrame().getHeight();
		assertEquals(500, width);
		assertEquals(500, height);
		assertEquals(true, visible);
	}
}