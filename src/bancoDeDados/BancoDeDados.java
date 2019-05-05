package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public DefaultListModel<String> listaUtilizadores = new DefaultListModel<String>();
	public Utilizador utilizadorLogado;
	
	public void conectar(String utilizador, String pass) {
		String servidor = "jdbc:mysql://localhost:3306/bd_mongo";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, utilizador, pass);
			this.statement = this.connection.createStatement();
			getUtilizador(utilizador);
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
	
	public void getUtilizador(String utilizador) {
		try {
			if(utilizador.equals("root"))
			{
				utilizadorLogado = new Utilizador(0,"UserRoot","root","root@iscte-iul.pt",true);
				return;
			}
				
			String query = "SELECT * FROM utilizador WHERE IDUtilizador = " + utilizador;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			utilizadorLogado = new Utilizador(Integer.parseInt(this.resultset.getString("IDUtilizador")),
					this.resultset.getString("NomeUtilizador"),
					this.resultset.getString("CategoriaProfissional"),
					this.resultset.getString("Email"),
					Boolean.parseBoolean(this.resultset.getString("Activo")));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a pesquisar o Utilizador");
		}
	}
	
	public void listarUtilizador() {
		try {
			String query = "SELECT * FROM utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Utilizador user = new Utilizador(Integer.parseInt(this.resultset.getString("IDUtilizador")),
						this.resultset.getString("NomeUtilizador"),
						this.resultset.getString("CategoriaProfissional"),
						this.resultset.getString("Email"),
						Boolean.parseBoolean(this.resultset.getString("Activo")));
				listaUtilizadores.addElement(user.toString());
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

	public ArrayList<Cultura> listaCultura() {
		try {
			String query = "SELECT c.IDCultura, c.NomeCultura, c.DescricaoCultura, c.IDUtilizador_fk, u.NomeUtilizador "
					+ "FROM cultura c "
					+ "INNER JOIN utilizador u ON u.IDUtilizador = c.IDUtilizador_fk;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			
			ArrayList<Cultura> listCulturas = new ArrayList<Cultura>();
			while (this.resultset.next()) {
				Cultura cultura = new Cultura(
						Integer.parseInt(this.resultset.getString("IDCultura")),
						this.resultset.getString("NomeCultura"),
						this.resultset.getString("DescricaoCultura"),
						Integer.parseInt(this.resultset.getString("IDUtilizador_fk")),
						this.resultset.getString("NomeUtilizador"));
				listCulturas.add(cultura);
			}
			
			return listCulturas;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Cultura");
			return null;
		}
	}

	public void inserirCultura(String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "INSERT INTO cultura (NomeCultura, DescricaoCultura, IDUtilizador_fk) VALUES ('" + nome + "', '"
					+ descricao + "', " + IDUtilizador_fk + ")";
			this.statement.executeUpdate(query);
			this.statement = this.connection.createStatement();
			
			JOptionPane.showMessageDialog(null, "Cultura adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir cultura");
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