package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MenuInvestigador.menu_Investigador;
import bancoDeDados.BancoDeDados;

class GUItest {

	@Test
	void test() {

		/**
		 * Test:
		 * frame is visible,
		 * opens with correct width and height.
		 */

		BancoDeDados db = new BancoDeDados();
		db.conectar("root", "root");

		menu_Investigador gui = new menu_Investigador (db);
		boolean visibleGUI = gui.getFrame().isVisible();
		int width = gui.getFrame().getWidth();
		int height = gui.getFrame().getHeight();
		
		assertEquals(500, width);
		assertEquals(500, height);
		assertEquals(true, visibleGUI);
	}
}
