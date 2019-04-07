package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/dbphp";
		String usuario = "root";
		String senha = "senai";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
		}
	}

	public boolean estaLigado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public void listar() {
		try {
			String query = "SELECT * FROM Utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				System.out.println("IDUtilizador: " + this.resultset.getString("IDUtilizador") + "Nome do Utilizador: "
						+ this.resultset.getString("NomeUtilizador") + "Categoria Profissional:"
						+ this.resultset.getString("CategoriaProfissional") + "Email: "
						+ this.resultset.getString("Email") + "Activo: " + this.resultset.getString("Activo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserirUtilizador(String nome, String categoria, String email, boolean activo) {
		try {
			String query = "INSERT INTO Utilizador (NomeUtilizador, CategoriaProfissional, Email, Activo) VALUES ("
					+ nome + ", " + categoria + ", " + email + ", " + activo + " ')";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
		}
	}

	public void actualizarUtilizador(int id, String nome, String categoria, String email, boolean activo) {
		try {
			String query = "UPDATE Utilizador set IDUtilizador = '" + id + "', NomeUtilizador = '" + nome
					+ "' , CategoriaProfissional = '" + categoria + "',Email = '" + email + "', Activo = '" + activo
					+ "' WHERE IDUtilizador = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
		}
	}

	public void apagarUtilizador(int id) {
		try {
			String query = "DELETE FROM Utilziador WHERE IDUtilizador = " + id + ";";
			this.statement.executeQuery(query);
		} catch (Exception e) {
		}
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
		}
	}

}