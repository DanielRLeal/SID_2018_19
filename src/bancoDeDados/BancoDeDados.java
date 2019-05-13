package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
//			if (utilizador.equals("pedroalmeida")) {
//				utilizadorLogado = new Utilizador(1, "UserRoot", "root", "root@iscte-iul.pt", true);
//				return;
//			}

			String query = "SELECT * FROM utilizador WHERE IDUtilizador = " + utilizador;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			utilizadorLogado = new Utilizador(this.resultset.getInt("IDUtilizador"),
					this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
					this.resultset.getString("Email"), this.resultset.getBoolean("Activo"));
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

				Utilizador user = new Utilizador(this.resultset.getInt("IDUtilizador"),
						this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
						this.resultset.getString("Email"), this.resultset.getBoolean("Activo"));
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
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador");
		}
	}

	public void actualizarUtilizador(int id, String nome, String categoria, String email, boolean activo) {
		try {
			String query = "UPDATE Utilizador SET NomeUtilizador = '" + nome + "', CategoriaProfissional = '"
					+ categoria + "',Email = '" + email + "', Activo = " + activo + " WHERE IDUtilizador = " + id + ";";
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

	/**
	 * 
	 * faz o select e coloca num arraylist de culturas
	 * 
	 * @return arraylist com culturas
	 */
	public ArrayList<Cultura> listaCultura() {
		try {
			String query = "SELECT c.IDCultura, c.NomeCultura, c.DescricaoCultura, c.IDUtilizador_fk, u.NomeUtilizador "
					+ "FROM cultura c " + "INNER JOIN utilizador u ON u.IDUtilizador = c.IDUtilizador_fk;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Cultura> listCulturas = new ArrayList<Cultura>();
			while (this.resultset.next()) {
				Cultura cultura = new Cultura(this.resultset.getInt("IDCultura"),
						this.resultset.getString("NomeCultura"), this.resultset.getString("DescricaoCultura"),
						this.resultset.getInt("IDUtilizador_fk"), this.resultset.getString("NomeUtilizador"));
				listCulturas.add(cultura);
			}
			return listCulturas;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Cultura");
			return null;
		}
	}

	/**
	 * recebe nome, descriçao e IDUtilizador e cria uma cultura na db
	 * 
	 */
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

	/**
	 * 
	 * @param id
	 * 
	 *           apaga uma cultura da db com o id=id
	 */
	public void apagarCultura(int id) {
		try {
			String query = "DELETE FROM Cultura WHERE IDCultura = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar cultura");
		}
	}

	/**
	 * faz o select e coloca todas as medicoes na db num arraylist
	 * 
	 * @return lista de medicoes
	 */

	public ArrayList<Medicoes> listaMedicoes() {
		try {
			String query = "SELECT m.*, c.NomeCultura, v.NomeVariaveis FROM Medicoes m "
					+ "INNER JOIN Cultura c ON m.IDCultura_fk = c.IDCultura "
					+ "INNER JOIN Variaveis v ON m.IDVariavel_fk = v.IDVariaveis";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Medicoes> listMedicoes = new ArrayList<Medicoes>();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				sdf.format(date);

				Medicoes medicao = new Medicoes(this.resultset.getInt("IDMedicoes"),
						this.resultset.getInt("IDCultura_fk"), this.resultset.getString("NomeCultura"),
						this.resultset.getInt("IDVariavel_fk"), this.resultset.getString("NomeVariaveis"), date,
						this.resultset.getDouble("valorMedicao"));
				listMedicoes.add(medicao);
			}
			return listMedicoes;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Medicoes");
			return null;
		}
	}

	/**
	 * 
	 * @param IDCultura_fk
	 * @param iDVariavel_fk
	 * @param dataHoraMedicao
	 * @param ValorMedicao
	 */
	public void inserirMedicoes(String IDCultura_fk, String iDVariavel_fk, String dataHoraMedicao,
			double ValorMedicao) {
		try {
			String query = "INSERT INTO Medicoes (IDCultura_fk, IDVariavel_fk, DataHoraMedicao, ValorMedicao) VALUES ('"
					+ IDCultura_fk + "', '" + iDVariavel_fk + "', '" + dataHoraMedicao + "', '" + ValorMedicao + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Medicoes adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir Medicoes");
		}
	}

	public void actualizarMedicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, String dataHoraMedicao,
			double ValorMedicao) {
		try {
			String query = "UPDATE Medicoes set IDCultura_fk = " + IDCultura_fk + ", IDVariavel_fk = " + IDVariavel_fk
					+ ", " + "DataHoraMedicao = " + dataHoraMedicao + ",ValorMedicao = " + ValorMedicao
					+ " WHERE IDMedicoes = " + IDMedicoes + ";";
			System.out.println(query);
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
			String query = "SELECT v.*, c.NomeCultura FROM variaveis v INNER JOIN cultura c ON v.IDCultura_fk = c.IDCultura;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Variaveis var = new Variaveis(this.resultset.getInt("IDVariaveis"),
						this.resultset.getString("NomeVariaveis"), this.resultset.getInt("IDCultura_fk"),
						this.resultset.getString("NomeCultura"));
				temp.add(var);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Variaveis");
		}
		return temp;
	}

	public void inserirVariaveis(String NomeVariaveis, String IDCultura_fk) {
		try {
			String query = "INSERT INTO Variaveis (NomeVariaveis, IDCultura_fk) VALUES ('" + NomeVariaveis + "', '"
					+ IDCultura_fk + "');";
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
			String query = "DELETE FROM variaveis WHERE IDVariaveis = " + id + ";";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Variavel apagada com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Variaveis");
		}
	}

	// Listar(..) VariaveisMedidas

	public ArrayList<VariaveisMedidas> listaVariaveisMedidas() {
		try {
			String query = "SELECT vm.*, c.NomeCultura, v.NomeVariaveis FROM variaveismedidas vm "
					+ "INNER JOIN cultura c ON vm.IDCultura_fk = c.IDCultura "
					+ "INNER JOIN variaveis v ON vm.IDVariavel_fk = v.IDVariaveis;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<VariaveisMedidas> listVariaveisMedidas = new ArrayList<VariaveisMedidas>();
			while (this.resultset.next()) {
				VariaveisMedidas vm = new VariaveisMedidas(this.resultset.getInt("IDCultura_fk"),
						this.resultset.getString("NomeCultura"), this.resultset.getInt("IDVariavel_fk"),
						this.resultset.getString("NomeVariaveis"), this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("LimiteInferior"));
				listVariaveisMedidas.add(vm);
			}

			return listVariaveisMedidas;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar VariaveisMedidas");
			return null;
		}
	}

	public void inserirVariaveisMedidas(String iDCultura_fk, String iDVariavel_fk, double limSuperior,
			double limInferior) {

		try {
			String query = "INSERT INTO VariaveisMedidas (IDCultura_fk,IDVariavel_fk,LimiteSuperior,LimiteInferior) VALUES ('"
					+ iDCultura_fk + "', '" + iDVariavel_fk + "', '" + limSuperior + "', '" + limInferior + "');";
			System.out.println(query);

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "VariaveisMedidas adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir VariaveisMedidas");
		}
	}

	public void actualizarVariaveisMedidas(int id, String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "UPDATE Cultura set NomeCultura = '" + nome + "' , DescricaoCultura = '" + descricao
					+ "', IDUtilizador_fk = '" + IDUtilizador_fk + "' WHERE IDCultura = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar VariaveisMedidas");
		}
	}

	public void apagarVariaveisMedidas(int idCultura, int idVariavel) {
		try {
			String query = "DELETE FROM variaveismedidas WHERE IDCultura_fk = '" + idCultura + "' AND IDVariavel_fk = '"
					+ idVariavel + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar VariaveisMedidas");
		}
	}

	// Listar(..) MedicoesLuminiosidade

	public ArrayList<MedicaoLuminosidade> listaMedicoesLuminosidade() {
		try {
			String query = "SELECT * FROM medicoesluminosidade";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<MedicaoLuminosidade> listMedicoesLumin = new ArrayList<>();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
				Date date = new Date(timestamp.getTime());
				MedicaoLuminosidade medLum = new MedicaoLuminosidade(this.resultset.getInt("IDMedicao"), date,
						this.resultset.getDouble("ValorMedicaoLuminosidade"));

				listMedicoesLumin.add(medLum);
			}

			return listMedicoesLumin;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar medicoesluminosidade");
			return null;
		}
	}

	public void inserirMedicoesLuminosidade(String dataHoraMedicao, double ValorMedicaoLuminosidade) {
		try {
			String query = "INSERT INTO medicoesluminosidade (DataHoraMedicao, ValorMedicaoLuminosidade) VALUES ('"
					+ dataHoraMedicao + "', '" + ValorMedicaoLuminosidade + "');";
			System.out.println(query);

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "medicoesluminosidade adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir medicoesluminosidade");
		}
	}

	public void actualizarMedicoesLuminosidade(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoLuminosidade) {
		try {
			String query = "UPDATE medicoesluminosidade set DataHoraMedicao = '" + DataHoraMedicao
					+ "', ValorMedicaoLuminosidade = '" + ValorMedicaoLuminosidade + "' WHERE IDMedicao = " + IDMedicao
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar medicoesluminosidade");
		}
	}

	public void apagarMedicoesLuminosidade(int IDMedicao) {
		try {
			String query = "DELETE FROM medicoesluminosidade WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoesluminosidade");
		}
	}

	// Listar(..) MedicoesTemperatura

	public ArrayList<MedicaoTemperatura> listaMedicoesTemperatura() {
		try {
			String query = "SELECT * FROM medicoestemperatura";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<MedicaoTemperatura> listMedicoesTemp = new ArrayList<>();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
				Date date = new Date(timestamp.getTime());
				MedicaoTemperatura medTemp = new MedicaoTemperatura(this.resultset.getInt("IDMedicao"), date,
						this.resultset.getDouble("ValorMedicaoTemperatura"));

				listMedicoesTemp.add(medTemp);
			}

			return listMedicoesTemp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar medicoestemperatura");
			return null;
		}
	}

	public void inserirMedicoesTemperatura(String dataHoraMedicao, double ValorMedicaoTemperatura) {
		try {
			String query = "INSERT INTO medicoesluminosidade (IDMedicao, DataHoraMedicao, ValorMedicaoTemperatura) VALUES ('"
					+ dataHoraMedicao + "', '" + ValorMedicaoTemperatura + "');";

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "medicoestemperatura adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir medicoestemperatura");
		}
	}

	public void actualizarMedicoesTemperatura(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoTemperatura) {
		try {
			String query = "UPDATE medicoestemperatura set DataHoraMedicao = '" + DataHoraMedicao
					+ "', ValorMedicaoLuminosidade = '" + ValorMedicaoTemperatura + "' WHERE IDMedicao = " + IDMedicao
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar medicoestemperatura");
		}
	}

	public void apagarMedicoesTemperatura(int IDMedicao) {
		try {
			String query = "DELETE FROM medicoestemperatura WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoestemperatura");
		}
	}

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

	public ArrayList<Utilizador_Log> listarUtilizador_Log() {
		ArrayList<Utilizador_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM utilizador_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Utilizador_Log user = new Utilizador_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"), this.resultset.getInt("IDUtilizador"),
						this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
						this.resultset.getString("Email"), this.resultset.getBoolean("Activo"),
						this.resultset.getString("Operacao"), this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Utilizador_Log");
		}
		return temp;
	}

	public ArrayList<Alertas_Log> listarAlertas_Log() {
		ArrayList<Alertas_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM alertas_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Alertas_Log user = new Alertas_Log(this.resultset.getInt("IDLog"), this.resultset.getInt("IDAlerta"),
						this.resultset.getInt("IDUtilizador"), this.resultset.getString("DataHora"),
						this.resultset.getString("NomeVariavel"), this.resultset.getDouble("LimiteInferior"),
						this.resultset.getDouble("LimiteSuperior"), this.resultset.getDouble("ValorMedicao"),
						this.resultset.getString("Descricao"), this.resultset.getBoolean("Visto"),
						this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Alertas_Log");
		}
		return temp;
	}

	public ArrayList<Medicoes_Log> listarMedicoes_Log() {
		ArrayList<Medicoes_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM medicoes_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				// passar para double ValorMEDICAO
				Medicoes_Log user = new Medicoes_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"), this.resultset.getInt("IDMedicoes"),
						this.resultset.getInt("IDCultura"), this.resultset.getInt("IDVariavel"),
						this.resultset.getString("DataHoraMedicao"), this.resultset.getDouble("ValorMedicao"),
						this.resultset.getString("Operacao"), this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Medicoes_Log");
		}
		return temp;
	}

	public ArrayList<Cultura_Log> listarCultura_Log() {
		ArrayList<Cultura_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM cultura_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Cultura_Log user = new Cultura_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"), this.resultset.getInt("IDCultura"),
						this.resultset.getString("NomeCultura"), this.resultset.getString("DescricaoCultura"),
						this.resultset.getInt("IDUtilizador"), this.resultset.getString("Operacao"),
						this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Cultura_Log");
		}
		return temp;
	}

	public ArrayList<VariaveisMedidas_Log> listarVariaveisMedidas_Log() {
		ArrayList<VariaveisMedidas_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM variaveismedidas_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				VariaveisMedidas_Log user = new VariaveisMedidas_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"), this.resultset.getInt("IDCultura"),
						this.resultset.getInt("IDVariavel"), this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("LimiteInferior"), this.resultset.getString("Operacao"),
						this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar VariaveisMedidas_Log");
		}
		return temp;
	}

	public ArrayList<Variaveis_Log> listarVariaveis_Log() {
		ArrayList<Variaveis_Log> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM variaveis_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Variaveis_Log user = new Variaveis_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"), this.resultset.getInt("IDVariaveis"),
						this.resultset.getString("NomeVariaveis"), this.resultset.getInt("IDCultura"),
						this.resultset.getString("Operacao"), this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Variaveis_Log");
		}
		return temp;
	}

	/**
	 * Faz o select de alertas e coloca num array
	 * 
	 * @return ArrayList de Alertas
	 */
	public ArrayList<Alerta> verificarAlertas() {
		ArrayList<Alerta> temp = new ArrayList<>();
		try {
			String query = "SELECT a.*, u.Email FROM alertas a "
					+ "LEFT OUTER JOIN utilizador u ON a.IDUtilizador = u.IDUtilizador " + "WHERE a.Visto = 0 "
					// + "AND a.DataHora > DATE_SUB(NOW(), INTERVAL 1 MINUTE) "
					+ "AND (a.IDUtilizador IS NULL OR a.IDUtilizador = " + this.utilizadorLogado.ID + ");";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHora");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				sdf.format(date);

				int IDUtilizador = IDUtilizador();
				Alerta alerta = new Alerta(Integer.parseInt(this.resultset.getString("IDAlerta")), IDUtilizador,
						this.resultset.getString("Email"), date, this.resultset.getString("NomeVariavel"),
						this.resultset.getDouble("LimiteInferior"), this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("ValorMedicao"), this.resultset.getString("Descricao"),
						this.resultset.getBoolean("Visto"));
				temp.add(alerta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar alertas");
		}
		return temp;
	}

	/**
	 * 
	 * @return inteiro com o ID do utilizador
	 * @throws java.sql.SQLException
	 */
	private int IDUtilizador() throws java.sql.SQLException {
		int IDUtilizador = 0;
		if (this.resultset.findColumn("IDUtilizador") > 0)
			IDUtilizador = this.resultset.getInt("IDUtilizador");
		return IDUtilizador;
	}

	/**
	 * altera o alerta para lido/visto
	 * 
	 * @param alerta
	 */
	public void tornarAlertaVisto(Alerta alerta) {
		try {
			String query = "UPDATE alertas SET Visto = 1 WHERE IDAlerta = " + alerta.getIDAlerta() + ";";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha tornar alertas vistos");
		}
	}
}