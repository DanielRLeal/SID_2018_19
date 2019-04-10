package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public DefaultListModel<String> listaUtilizadores = new DefaultListModel<String>();

	public void conectar(String usuario, String senha) {
		String servidor = "jdbc:mysql://localhost:3306/dbphp";
		String driver = "com.mysql.cj.jdbc.Driver";
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

	public void listarUtilizador() {
		try {
			String query = "SELECT * FROM Utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				System.out.println("IDUtilizador: " + this.resultset.getString("IDUtilizador") + "Nome do Utilizador: "
						+ this.resultset.getString("NomeUtilizador") + "Categoria Profissional:"
						+ this.resultset.getString("CategoriaProfissional") + "Email: "
						+ this.resultset.getString("Email") + "Activo: " + this.resultset.getString("Activo"));
				listaUtilizadores.addElement(this.resultset.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Utilizador");
		}
	}

	public void inserirUtilizador(String nome, String password, String categoria, String email, boolean activo) {
		try {
			String query = "INSERT INTO Utilizador (NomeUtilizador, CategoriaProfissional, Email, Activo) VALUES ("
					+ nome + ", " + categoria + ", " + email + ", " + activo + " ')";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador");
		}
	}

	public void actualizarUtilizador(int id, String nome, String categoria, String email, boolean activo) {
		try {
			String query = "UPDATE Utilizador set IDUtilizador = '" + id + "', NomeUtilizador = '" + nome
					+ "' , CategoriaProfissional = '" + categoria + "',Email = '" + email + "', Activo = '" + activo
					+ "' WHERE IDUtilizador = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar utilizador");
		}
	}

	public void apagarUtilizador(int id) {
		try {
			String query = "DELETE FROM Utilizador WHERE IDUtilizador = " + id + ";";
			this.statement.executeQuery(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar utilizador");
		}
	}

	public void listaCultura() {
		try {
			String query = "SELECT * FROM Cultura";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				System.out.println("IDCultura: " + this.resultset.getString("IDUtilizador") + "Nome da Cultura: "
						+ this.resultset.getString("NomeCultura") + "Descrição da Cultura:"
						+ this.resultset.getString("DescricaoCultura") + "Utilizador associado: "
						+ this.resultset.getString("Utilizador_fk"));
				listaUtilizadores.addElement(this.resultset.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Cultura");
		}
	}

	public void inserirCultura(String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "INSERT INTO Cultura (NomeCultura, DescricaoCultura, IDUtilizador_fk) VALUES (" + nome + ", "
					+ descricao + ", " + IDUtilizador_fk + " ')";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador");
		}
	}

	public void actualizarCulura(int id, String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "UPDATE Cultura set NomeCultura = '" + nome + "' , DescricaoCultura = '" + descricao
					+ "', IDUtilizador_fk = '" + IDUtilizador_fk + "' WHERE IDCultura = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar cultura");
		}
	}

	public void apagarCultura(int id) {
		try {
			String query = "DELETE FROM Cultura WHERE IDCultura = " + id + ";";
			this.statement.executeQuery(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar cultura");
		}
	}

	// Listar(..) Medicoes
	// Listar(..) Variaveis
	// Listar(..) VariaveisMedidas
	// Listar(..) MedicoesLuminiosidade
	// Listar(..) MedicoesTemperatura
	// Listar(..) Sistema

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
		}
	}
}