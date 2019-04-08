package bancoDeDados;

import bancoDeDados.*;

public class mainForTest {
	public static void main(String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar(null, null);
		if (bancoDeDados.estaLigado()) {
			bancoDeDados.listarUtilizador();
//			bancoDeDados.actualizarUtilizador(id, nome, categoria, email, activo);
//			bancoDeDados.apagarUtilizador(id);
//			bancoDeDados.inserirUtilizador(nome, categoria, email, activo);
			bancoDeDados.desconectar();
		}
	}

}
