package bancoDeDados;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
	ArrayList<Utilizador> users = new ArrayList<>();

	public void conectar(String utilizador, String pass) {
		String servidor = "jdbc:mysql://localhost:3306/sid_bd_php";
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
			if (utilizador.equals("root")) {
				utilizadorLogado = new Utilizador(0, "UserRoot", "root", "root@iscte-iul.pt", true);
				return;
			}

			String query = "SELECT * FROM utilizador WHERE IDUtilizador = " + utilizador;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			utilizadorLogado = new Utilizador(Integer.parseInt(this.resultset.getString("IDUtilizador")),
					this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
					this.resultset.getString("Email"), Boolean.parseBoolean(this.resultset.getString("Activo")));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a pesquisar o Utilizador");
		}
	}

	public ArrayList<Utilizador> listarUtilizador() {
		ArrayList<Utilizador> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Utilizador user = new Utilizador(Integer.parseInt(this.resultset.getString("IDUtilizador")),
						this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
						this.resultset.getString("Email"), Boolean.parseBoolean(this.resultset.getString("Activo")));
				temp.add(user);
				users = removeDuplicates(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Utilizador");
		}
		return users;
	}

	public void inserirUtilizador(String nome, String password, String categoria, String email, boolean activo) {
		try {
			String query = "INSERT INTO Utilizador (NomeUtilizador, CategoriaProfissional, Email, Activo) VALUES ('"
					+ nome + "', '" + categoria + "', '" + email + "', " + activo + ");";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			// Cria utilizador insere no programa enquanto nao fechado
			// Mas não adiciona correctamente na GUI
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador - mas ");
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

	public void apagarUtilizador(int id, boolean bool) {
		try {
			String query = "UPDATE Utilizador set Activo = " + bool + " WHERE IDUtilizador = " + id + ";";
			System.out.println(query + "\n" + "Vou desativar o utilizador com id " + id);
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar utilizador");
		}
	}

	public ArrayList<Cultura> listaCultura() {
		try {
			String query = "SELECT c.IDCultura, c.NomeCultura, c.DescricaoCultura, c.IDUtilizador_fk, u.NomeUtilizador "
					+ "FROM cultura c " + "INNER JOIN utilizador u ON u.IDUtilizador = c.IDUtilizador_fk;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Cultura> listCulturas = new ArrayList<Cultura>();
			while (this.resultset.next()) {
				Cultura cultura = new Cultura(Integer.parseInt(this.resultset.getString("IDCultura")),
						this.resultset.getString("NomeCultura"), this.resultset.getString("DescricaoCultura"),
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
			String query = "INSERT INTO Cultura (NomeCultura, DescricaoCultura, IDUtilizador_fk) VALUES ('" + nome
					+ "', '" + descricao + "', '" + IDUtilizador_fk + "');";

			this.statement.executeUpdate(query);
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
			String query = "DELETE FROM Cultura WHERE IDCultura = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar cultura");
		}
	}

	// Listar(..) Medicoes

	public ArrayList<Medicoes> listaMedicoes() {
		try {
			String query = "SELECT * FROM Medicoes";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Medicoes> listMedicoes = new ArrayList<Medicoes>();
			while (this.resultset.next()) {

				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		        Date date = dateFormat.parse(this.resultset.getString("DataHoraMedicao"));
				
		        Medicoes medicao = new Medicoes(Integer.parseInt(this.resultset.getString("IDMedicoes")),
						Integer.parseInt(this.resultset.getString("IDCultura_fk")),
						Integer.parseInt(this.resultset.getString("IDVariavel_fk")),
						date,
						Double.parseDouble(this.resultset.getString("valorMedicao")));
				listMedicoes.add(medicao);
			}
			return listMedicoes;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Medicoes");
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Falha a listar Medicoes");
			return null;
		}
	}

	public void inserirMedicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, Time DataHoraMedicao,
			int ValorMedicao) {
		try {
			String query = "INSERT INTO Medicoes (IDMedicoes, IDCultura_fk, IDVariavel_fk, DataHoraMedicao, ValorMedicao) VALUES ('"
					+ IDMedicoes + "', '" + IDCultura_fk + "', '" + IDVariavel_fk + DataHoraMedicao + "', '"
					+ ValorMedicao + "');";

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Medicoes adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir Medicoes");
		}
	}

	public void actualizarMedicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, Time DataHoraMedicao,
			int ValorMedicao) {
		try {
			String query = "UPDATE Medicoes set IDCultura_fk = '" + IDCultura_fk + "' , DataHoraMedicao = '"
					+ DataHoraMedicao + "', valorMedicao = '" + ValorMedicao + "' WHERE IDMedicoes = " + IDMedicoes
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar Medicoes");
		}
	}

	public void apagarMedicoes(int id) {
		try {
			String query = "DELETE FROM Medicoes WHERE IDMedicoes = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Medicoes");
		}
	}

	// Listar(..) Variaveis

	public ArrayList<Variaveis> listarVariaveis() {
		ArrayList<Variaveis> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM Variaveis";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Variaveis variavel = new Variaveis(Integer.parseInt(this.resultset.getString("IDVariaveis")),
						this.resultset.getString("NomeVariaveis"),
						Integer.parseInt(this.resultset.getString("IDCultura_fk")));
				temp.add(variavel);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Variaveis");
		}
		return temp;
	}

	public void inserirVariaveis(int IDVariaveis, String NomeVariaveis, int IDCultura_fk) {
		try {
			String query = "INSERT INTO Variaveis (IDVariaveis, NomeVariaveis, IDCultura_fk) VALUES ('" + IDVariaveis
					+ "', '" + NomeVariaveis + "', '" + IDCultura_fk + ");";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			// Cria Variaveis insere no programa enquanto nao fechado
			// Mas não adiciona correctamente na GUI
			JOptionPane.showMessageDialog(null, "Falha a inserir Variaveis");
		}
	}

	public void actualizarVariaveis(int IDVariaveis, String NomeVariaveis, int IDCultura_fk) {
		try {
			String query = "UPDATE Variaveis set IDVariaveis = '" + IDVariaveis + "' , NomeVariaveis = '"
					+ NomeVariaveis + "', IDCultura_fk = '" + IDCultura_fk + "' WHERE IDVariaveis = " + IDVariaveis
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar Variaveis");
		}
	}

	public void apagarVariaveis(int id) {
		try {
			String query = "DELETE FROM Medicoes WHERE IDMedicoes = '" + id + "';";
			System.out.println(query + "\n" + "Vou apagar Variaveis com id " + id);
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Variaveis");
		}
	}

	// Listar(..) VariaveisMedidas
	// Listar(..) MedicoesLuminiosidade
	// Listar(..) MedicoesTemperatura
	// Listar(..) Sistema

	public static ArrayList<Utilizador> removeDuplicates(ArrayList<Utilizador> list) {
		ArrayList<Utilizador> newList = new ArrayList<>();
		for (Utilizador element : list) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}
		return newList;
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
		}
	}
}