package bancoDeDados;

import bancoDeDados.*;

public class dbphp {
	public static void main(String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if (bancoDeDados.estaLigado()) {
			bancoDeDados.listar();
//			bancoDeDados.actualizarUtilizador(id, nome, categoria, email, activo);
//			bancoDeDados.apagarUtilizador(id);
//			bancoDeDados.inserirUtilizador(nome, categoria, email, activo);
			bancoDeDados.desconectar();
		}
	}
}
