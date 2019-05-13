package bancoDeDados;

import java.sql.CallableStatement;
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

import Login.VerificarAlertas;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public DefaultListModel<String> listaUtilizadores = new DefaultListModel<String>();
	public Utilizador utilizadorLogado;
	ArrayList<Utilizador> users = new ArrayList<>();
	String BDname = "sid_bd_php.";
	
	public void conectar(String utilizador, String pass) {
		String servidor = "jdbc:mysql://localhost:3306/sid_bd_php";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, utilizador, pass);
			this.statement = this.connection.createStatement();
			getUtilizador(utilizador);
			
			Thread t = t();
		} catch (Exception e) {
		}
	}

	private Thread t() {
		VerificarAlertas vAlertas = new VerificarAlertas(this);
		Thread t = new Thread(vAlertas);
		t.start();
		return t;
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

			String query = "SELECT * FROM " + BDname + "utilizador WHERE IDUtilizador = " + utilizador;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			if(this.resultset.next()){
				utilizadorLogado = new Utilizador(this.resultset.getInt("IDUtilizador"),
					this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
					this.resultset.getString("Email"), this.resultset.getBoolean("Activo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a pesquisar o Utilizador");
		}
	}

	public ArrayList<Utilizador> listarUtilizador() {
		ArrayList<Utilizador> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM " + BDname + "utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			temp(temp);
			while (this.resultset.next()) {

				users = removeDuplicates(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Utilizador");
		}
		return users;
	}

	private void temp(ArrayList<Utilizador> temp) throws java.sql.SQLException {
		while (this.resultset.next()) {
			Utilizador user = new Utilizador(this.resultset.getInt("IDUtilizador"),
					this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
					this.resultset.getString("Email"), this.resultset.getBoolean("Activo"));
			temp.add(user);
		}
	}

	public void inserirUtilizador(String nome, String password, String categoria, String email, boolean activo) {
		try {
			//Corre sem erros, mas n�o executa o SP...
			/*String query = "{CALL " + BDname + "CriarUtilizador(?, ?, ?, ?, ?)}";
			CallableStatement stmt = this.connection.prepareCall(query);
			
			stmt.setString(1, nome);
			stmt.setString(2, categoria);
			stmt.setString(3, email);
			stmt.setBoolean(4, true);
			stmt.setString(5, password);
			
			stmt.executeQuery();*/
			
			String query = "INSERT INTO " + BDname + "utilizador (NomeUtilizador, CategoriaProfissional, Email, Activo) VALUES ('"
					+ nome + "', '" + categoria + "', '" + email + "', " + activo + ");";
			
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador");
		}
	}

	public void actualizarUtilizador(int id, String nome, String categoria, String email, boolean activo, String password) {
		try {
			//Corre sem erros, mas n�o executa o SP...
			/*String query = "{CALL " + BDname + "EditarUtilizador(?, ?, ?, ?, ?, ?)}";
			CallableStatement stmt = this.connection.prepareCall(query);
			
			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, categoria);
			stmt.setString(4, email);
			stmt.setBoolean(5, true);
			stmt.setString(6, password);
			
			stmt.executeQuery();*/
			
			String query = "UPDATE " + BDname + "Utilizador SET NomeUtilizador = '" + nome
					+ "', CategoriaProfissional = '" + categoria + "',Email = '" + email + "', Activo = " + activo
					+ " WHERE IDUtilizador = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar utilizador");
		}
	}

	public void apagarUtilizador(int id, boolean bool) {
		try {
			//Corre sem erros, mas n�o executa o SP...
			/*String query = "{CALL " + BDname + "ApagarUtilizador(?)}";
			CallableStatement stmt = this.connection.prepareCall(query);
			
			stmt.setInt(1, id);
			
			stmt.executeQuery();*/
			
			String query = "UPDATE " + BDname + "Utilizador set Activo = " + bool + " WHERE IDUtilizador = " + id + ";";
			System.out.println(query + "\n" + "Vou desativar o utilizador com id " + id);
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar utilizador");
		}
	}

	public ArrayList<Cultura> listaCultura() {
		try {
			String query = "SELECT c.IDCultura, c.NomeCultura, c.DescricaoCultura, c.IDUtilizador_fk, u.NomeUtilizador "
					+ "FROM " + BDname + "cultura c INNER JOIN " + BDname + "utilizador u ON u.IDUtilizador = c.IDUtilizador_fk;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Cultura> listCulturas = new ArrayList<Cultura>();
			while (this.resultset.next()) {
				Cultura cultura = new Cultura(this.resultset.getInt("IDCultura"),
						this.resultset.getString("NomeCultura"), this.resultset.getString("DescricaoCultura"),
						this.resultset.getInt("IDUtilizador_fk"),
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
			String query = "INSERT INTO " + BDname + "Cultura (NomeCultura, DescricaoCultura, IDUtilizador_fk) VALUES ('" + nome
					+ "', '" + descricao + "', '" + IDUtilizador_fk + "');";

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cultura adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir cultura");
		}
	}

	public void actualizarCultura(int id, String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "UPDATE " + BDname + "Cultura set NomeCultura = '" + nome + "' , DescricaoCultura = '" + descricao
					+ "', IDUtilizador_fk = " + IDUtilizador_fk + " WHERE IDCultura = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar cultura");
		}
	}

	public void apagarCultura(int id) {
		try {
			String query = "DELETE FROM " + BDname + "Cultura WHERE IDCultura = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar cultura");
		}
	}

	// Listar(..) Medicoes

	public ArrayList<Medicoes> listaMedicoes() {
		try {
			String query = "SELECT m.*, c.NomeCultura, v.NomeVariaveis FROM " + BDname + "Medicoes m "
					+ "INNER JOIN " + BDname + "Cultura c ON m.IDCultura_fk = c.IDCultura "
					+ "INNER JOIN " + BDname + "Variaveis v ON m.IDVariavel_fk = v.IDVariaveis";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Medicoes> listMedicoes = new ArrayList<Medicoes>();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				sdf.format(date);

				Medicoes medicao = new Medicoes(this.resultset.getInt("IDMedicoes"),
						this.resultset.getInt("IDCultura_fk"),
						this.resultset.getString("NomeCultura"),
						this.resultset.getInt("IDVariavel_fk"), 
						this.resultset.getString("NomeVariaveis"), date,
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

	public void inserirMedicoes(String IDCultura_fk, String iDVariavel_fk, String dataHoraMedicao, double ValorMedicao) {
		try {
			String query = "INSERT INTO " + BDname + "Medicoes (IDCultura_fk, IDVariavel_fk, DataHoraMedicao, ValorMedicao) VALUES ('"
					+ IDCultura_fk + "', '" + iDVariavel_fk + "', '" + dataHoraMedicao + "', '" + ValorMedicao + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Medicoes adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir Medicoes");
		}
	}

	public void actualizarMedicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, String dataHoraMedicao, double ValorMedicao) {
		try {
			String query = "UPDATE " + BDname + "Medicoes set IDCultura_fk = " + IDCultura_fk + ", IDVariavel_fk = " + IDVariavel_fk + ", "
					+ "DataHoraMedicao = " + dataHoraMedicao + ",ValorMedicao = " + ValorMedicao + " WHERE IDMedicoes = " + IDMedicoes + ";";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar Medicoes");
		}
	}

	public void apagarMedicoes(int id) {
		try {
			String query = "DELETE FROM " + BDname + "Medicoes WHERE IDMedicoes = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Medicoes");
		}
	}

	// Listar(..) Variaveis

	public ArrayList<Variaveis> listarVariaveis() {
		ArrayList<Variaveis> temp = new ArrayList<>();
		try {
			String query = "SELECT v.*, c.NomeCultura FROM " + BDname + "variaveis v INNER JOIN " + BDname + "cultura c ON v.IDCultura_fk = c.IDCultura;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Variaveis var = new Variaveis(this.resultset.getInt("IDVariaveis"),
						this.resultset.getString("NomeVariaveis"),
						this.resultset.getInt("IDCultura_fk"),
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
			String query = "INSERT INTO " + BDname + "Variaveis (NomeVariaveis, IDCultura_fk) VALUES ('" + NomeVariaveis + "', '"
					+ IDCultura_fk + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			// Cria Variaveis insere no programa enquanto nao fechado
			// Mas n�o adiciona correctamente na GUI
			JOptionPane.showMessageDialog(null, "Falha a inserir Variaveis");
		}
	}

	public void actualizarVariaveis(int IDVariaveis, String NomeVariaveis, String IDCultura_fk) {
		try {
			String query = "UPDATE " + BDname + "Variaveis set IDVariaveis = '" + IDVariaveis + "' , NomeVariaveis = '"
					+ NomeVariaveis + "', IDCultura_fk = " + IDCultura_fk + " WHERE IDVariaveis = " + IDVariaveis
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar Variaveis");
		}
	}

	public void apagarVariaveis(int id) {
		try {
			String query = "DELETE FROM " + BDname + "variaveis WHERE IDVariaveis = " + id + ";";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Variavel apagada com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Variaveis");
		}
	}

	// Listar(..) VariaveisMedidas

	public ArrayList<VariaveisMedidas> listaVariaveisMedidas() {
		try {
			String query = "SELECT vm.*, c.NomeCultura, v.NomeVariaveis FROM " + BDname + "variaveismedidas vm "
					+ "INNER JOIN " + BDname + "cultura c ON vm.IDCultura_fk = c.IDCultura "
					+ "INNER JOIN " + BDname + "variaveis v ON vm.IDVariavel_fk = v.IDVariaveis;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<VariaveisMedidas> listVariaveisMedidas = new ArrayList<VariaveisMedidas>();
			while (this.resultset.next()) {
				VariaveisMedidas vm = new VariaveisMedidas(this.resultset.getInt("IDCultura_fk"),
						this.resultset.getString("NomeCultura"),
						this.resultset.getInt("IDVariavel_fk"),
						this.resultset.getString("NomeVariaveis"),
						this.resultset.getDouble("LimiteSuperior"),
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
			String query = "INSERT INTO " + BDname + "VariaveisMedidas (IDCultura_fk, IDVariavel_fk, LimiteSuperior, LimiteInferior) VALUES ('"
					+ iDCultura_fk + "', '" + iDVariavel_fk + "', '" + limSuperior + "', '" + limInferior + "');";
			System.out.println(query);

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "VariaveisMedidas adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir VariaveisMedidas");
		}
	}

	public void actualizarVariaveisMedidas(int idCultura, int idVariavel, double LimiteSuperior, double LimiteInferior) {
		try {
			String query = "UPDATE " + BDname + "VariaveisMedidas set LimiteSuperior = " + LimiteSuperior + " , LimiteInferior = " + LimiteInferior
					+ " WHERE IDCultura_fk = " + idCultura + " AND IDVariavel_fk = " + idVariavel + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar VariaveisMedidas");
		}
	}

	public void apagarVariaveisMedidas(int idCultura, int idVariavel) {
		try {
			String query = "DELETE FROM " + BDname + "variaveismedidas WHERE IDCultura_fk = '" + idCultura + "' AND IDVariavel_fk = '" + idVariavel + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar VariaveisMedidas");
		}
	}

	// Listar(..) MedicoesLuminiosidade

	public ArrayList<MedicaoLuminosidade> listaMedicoesLuminosidade() {
		try {
			String query = "SELECT * FROM " + BDname + "medicoesluminosidade";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<MedicaoLuminosidade> listMedicoesLumin = new ArrayList<>();
			while (this.resultset.next()) {

				MedicaoLuminosidade medLum = medLum();
				listMedicoesLumin.add(medLum);
			}

			return listMedicoesLumin;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar medicoesluminosidade");
			return null;
		}
	}

	private MedicaoLuminosidade medLum() throws java.sql.SQLException {
		Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
		Date date = new Date(timestamp.getTime());
		MedicaoLuminosidade medLum = new MedicaoLuminosidade(this.resultset.getInt("IDMedicao"), date,
				this.resultset.getDouble("ValorMedicaoLuminosidade"));
		return medLum;
	}

	public void inserirMedicoesLuminosidade(String dataHoraMedicao, double ValorMedicaoLuminosidade) {
		try {
			String query = "INSERT INTO " + BDname + "medicoesluminosidade (DataHoraMedicao, ValorMedicaoLuminosidade) VALUES ('"
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
			String query = "UPDATE " + BDname + "medicoesluminosidade set DataHoraMedicao = '" + DataHoraMedicao
					+ "', ValorMedicaoLuminosidade = '" + ValorMedicaoLuminosidade + "' WHERE IDMedicao = " + IDMedicao
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar medicoesluminosidade");
		}
	}

	public void apagarMedicoesLuminosidade(int IDMedicao) {
		try {
			String query = "DELETE FROM " + BDname + "medicoesluminosidade WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoesluminosidade");
		}
	}

	// Listar(..) MedicoesTemperatura

	public ArrayList<MedicaoTemperatura> listaMedicoesTemperatura() {
		try {
			String query = "SELECT * FROM " + BDname + "medicoestemperatura";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<MedicaoTemperatura> listMedicoesTemp = new ArrayList<>();
			while (this.resultset.next()) {

				MedicaoTemperatura medTemp = medTemp();
				listMedicoesTemp.add(medTemp);
			}

			return listMedicoesTemp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar medicoestemperatura");
			return null;
		}
	}

	private MedicaoTemperatura medTemp() throws java.sql.SQLException {
		Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
		Date date = new Date(timestamp.getTime());
		MedicaoTemperatura medTemp = new MedicaoTemperatura(this.resultset.getInt("IDMedicao"), date,
				this.resultset.getDouble("ValorMedicaoTemperatura"));
		return medTemp;
	}

	public void inserirMedicoesTemperatura(String dataHoraMedicao, double ValorMedicaoTemperatura) {
		try {
			String query = "INSERT INTO " + BDname + "medicoesluminosidade (IDMedicao, DataHoraMedicao, ValorMedicaoTemperatura) VALUES ('"
					+ dataHoraMedicao + "', '" + ValorMedicaoTemperatura + "');";

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "medicoestemperatura adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir medicoestemperatura");
		}
	}

	public void actualizarMedicoesTemperatura(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoTemperatura) {
		try {
			String query = "UPDATE " + BDname + "medicoestemperatura set DataHoraMedicao = '" + DataHoraMedicao
					+ "', ValorMedicaoLuminosidade = '" + ValorMedicaoTemperatura + "' WHERE IDMedicao = " + IDMedicao
					+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar medicoestemperatura");
		}
	}

	public void apagarMedicoesTemperatura(int IDMedicao) {
		try {
			String query = "DELETE FROM " + BDname + "medicoestemperatura WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoestemperatura");
		}
	}

	// Listar(..) Sistema

	public ArrayList<Sistema> listaSistema() {
		try {
			String query = "SELECT * FROM " + BDname + "Sistema";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			ArrayList<Sistema> listTemp = new ArrayList<>();
			while (this.resultset.next()) {
				Sistema sis = new Sistema(
						this.resultset.getDouble("LimiteSuperiorTemperatura"),
						this.resultset.getDouble("LimiteInferiorTemperatura"),
						this.resultset.getDouble("LimiteSuperiorLuminosidade"),
						this.resultset.getDouble("LimiteInferiorLuminosidade"));

				listTemp.add(sis);
			}

			return listTemp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar sistema");
			return null;
		}
	}
	
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
			String query = "SELECT * FROM " + BDname + "utilizador_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Utilizador_Log user = new Utilizador_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"),
						this.resultset.getInt("IDUtilizador"),
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
			String query = "SELECT * FROM " + BDname + "alertas_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Alertas_Log user = new Alertas_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDAlerta"),
						this.resultset.getInt("IDUtilizador"),
						this.resultset.getString("DataHora"), this.resultset.getString("NomeVariavel"),
						this.resultset.getDouble("LimiteInferior"), this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("ValorMedicao"), this.resultset.getString("Descricao"),
						this.resultset.getBoolean("Visto"), this.resultset.getString("Data"));
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
			String query = "SELECT * FROM " + BDname + "medicoes_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				// passar para double ValorMEDICAO
				Medicoes_Log user = new Medicoes_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"),
						this.resultset.getInt("IDMedicoes"),
						this.resultset.getInt("IDCultura"),
						this.resultset.getInt("IDVariavel"),
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
			String query = "SELECT * FROM " + BDname + "cultura_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Cultura_Log user = new Cultura_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"),
						this.resultset.getInt("IDCultura"),
						this.resultset.getString("NomeCultura"), this.resultset.getString("DescricaoCultura"),
						this.resultset.getInt("IDUtilizador"),
						this.resultset.getString("Operacao"), this.resultset.getString("Data"));
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
			String query = "SELECT * FROM " + BDname + "variaveismedidas_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				VariaveisMedidas_Log user = new VariaveisMedidas_Log(
						this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"),
						this.resultset.getInt("IDCultura"),
						this.resultset.getInt("IDVariavel"),
						this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("LimiteInferior"),
						this.resultset.getString("Operacao"), 
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
			String query = "SELECT * FROM " + BDname + "variaveis_log";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Variaveis_Log user = new Variaveis_Log(this.resultset.getInt("IDLog"),
						this.resultset.getInt("IDLogUtilizador"),
						this.resultset.getInt("IDVariaveis"),
						this.resultset.getString("NomeVariaveis"),
						this.resultset.getInt("IDCultura"),
						this.resultset.getString("Operacao"),
						this.resultset.getString("Data"));
				temp.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Variaveis_Log");
		}
		return temp;
	}
	
	public ArrayList<Alerta> verificarAlertas() {
		ArrayList<Alerta> temp = new ArrayList<>();
		try {
			String query = "SELECT a.*, u.Email FROM " + BDname + "alertas a "
					+ "LEFT OUTER JOIN " + BDname + "utilizador u ON a.IDUtilizador = u.IDUtilizador "
					+ "WHERE a.Visto = 0 "
					//+ "AND a.DataHora > DATE_SUB(NOW(), INTERVAL 1 MINUTE) "
					+ "AND (a.IDUtilizador IS NULL OR a.IDUtilizador = " + this.utilizadorLogado.ID + ");";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHora");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				sdf.format(date);
				
				int IDUtilizador = IDUtilizador();
				Alerta alerta = new Alerta(Integer.parseInt(this.resultset.getString("IDAlerta")),
						IDUtilizador,
						this.resultset.getString("Email"),
						date,
						this.resultset.getString("NomeVariavel"),
						this.resultset.getDouble("LimiteInferior"),
						this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("ValorMedicao"),
						this.resultset.getString("Descricao"),
						this.resultset.getBoolean("Visto"));
				temp.add(alerta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar alertas");
		}
		return temp;
	}

	private int IDUtilizador() throws java.sql.SQLException {
		int IDUtilizador = 0;
		if (this.resultset.findColumn("IDUtilizador") > 0)
			IDUtilizador = this.resultset.getInt("IDUtilizador");
		return IDUtilizador;
	}
	
	public void tornarAlertaVisto(Alerta alerta) {
		try {
			String query = "UPDATE " + BDname + "alertas SET Visto = 1 WHERE IDAlerta = " + alerta.getIDAlerta() + ";";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha tornar alertas vistos");
		}
	}
}