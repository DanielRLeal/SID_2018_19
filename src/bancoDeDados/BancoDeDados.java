package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import Login.VerificarAlertas;

/**
 * Class BancoDeDados.
 */
public class BancoDeDados {

	/** The connection. */
	private Connection connection = null;
	
	/** The statement. */
	private Statement statement = null;
	
	/** The resultset. */
	private ResultSet resultset = null;
	
	/** The lista utilizadores. */
	public DefaultListModel<String> listaUtilizadores = new DefaultListModel<String>();
	
	/** The utilizador logado. */
	public Utilizador utilizadorLogado;
	
	/** The users. */
	ArrayList<Utilizador> users = new ArrayList<>();
	
	/** The B dname. */
	String BDname = "sid_bd_php.";
	
	/**
	 * Conectar.
	 *
	 * @param utilizador the utilizador
	 * @param pass the pass
	 */
	public void conectar(String utilizador, String pass) {
		String servidor = "jdbc:mysql://localhost:3306/sid_bd_php";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, utilizador, pass);
			this.statement = this.connection.createStatement();
			getUtilizador(utilizador);
			
			//Thread t = t();
		} catch (Exception e) {
		}
	}

	/**
	 * T.
	 *
	 * @return the thread
	 */
	private Thread t() {
		VerificarAlertas vAlertas = new VerificarAlertas(this);
		Thread t = new Thread(vAlertas);
		t.start();
		return t;
	}

	/**
	 * Esta ligado.
	 *
	 * @return true, if successful
	 */
	public boolean estaLigado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the utilizador.
	 *
	 * @param utilizador the utilizador
	 * @return the utilizador
	 */
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

	/**
	 * Listar utilizador.
	 *
	 * @return the array list
	 */
	public ArrayList<Utilizador> listarUtilizador() {
		ArrayList<Utilizador> temp = new ArrayList<>();
		try {
			String query = "SELECT * FROM " + BDname + "utilizador";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			users = new ArrayList<Utilizador>();
			while (this.resultset.next()) {
				Utilizador user = new Utilizador(this.resultset.getInt("IDUtilizador"),
						this.resultset.getString("NomeUtilizador"), this.resultset.getString("CategoriaProfissional"),
						this.resultset.getString("Email"), this.resultset.getBoolean("Activo"));
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar Utilizador");
		}
		return users;
	}

	/**
	 * Inserir utilizador.
	 *
	 * @param nome the nome
	 * @param password the password
	 * @param categoria the categoria
	 * @param email the email
	 * @param activo the activo
	 */
	public void inserirUtilizador(String nome, String password, String categoria, String email, boolean activo) {
		try {
			String query = "{call " + BDname + "CriarUtilizador(?, ?, ?, ?)}";
			PreparedStatement stmt = this.connection.prepareStatement(query);
			
			stmt.setString(1, nome);
			stmt.setString(2, categoria);
			stmt.setString(3, email);
			stmt.setString(4, password);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir utilizador");
		}
	}

	/**
	 * Actualizar utilizador.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param categoria the categoria
	 * @param email the email
	 * @param activo the activo
	 * @param password the password
	 */
	public void actualizarUtilizador(int id, String nome, String categoria, String email, boolean activo, String password) {
		try {
			//Corre sem erros, mas nao executa o SP...
			String query = "{CALL " + BDname + "EditarUtilizador(?, ?, ?, ?, ?, ?)}";
			PreparedStatement stmt = this.connection.prepareCall(query);
			
			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, categoria);
			stmt.setString(4, email);
			stmt.setBoolean(5, true);
			stmt.setString(6, password);
			
			stmt.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar utilizador");
		}
	}

	/**
	 * Apagar utilizador.
	 *
	 * @param id the id
	 * @param bool the bool
	 */
	public void apagarUtilizador(int id, boolean bool) {
		try {
			//Corre sem erros, mas nao executa o SP...
			String query = "{CALL " + BDname + "ApagarUtilizador(?)}";
			PreparedStatement stmt = this.connection.prepareCall(query);
			
			stmt.setInt(1, id);
			
			stmt.executeQuery();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar utilizador");
		}
	}

	/**
	 * Lista cultura.
	 *
	 * @return the array list
	 */
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

	/**
	 * Inserir cultura.
	 *
	 * @param nome the nome
	 * @param descricao the descricao
	 * @param IDUtilizador_fk the ID utilizador fk
	 */
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

	/**
	 * Actualizar cultura.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param descricao the descricao
	 * @param IDUtilizador_fk the ID utilizador fk
	 */
	public void actualizarCultura(int id, String nome, String descricao, String IDUtilizador_fk) {
		try {
			String query = "UPDATE " + BDname + "Cultura set NomeCultura = '" + nome + "' , DescricaoCultura = '" + descricao
					+ "', IDUtilizador_fk = " + IDUtilizador_fk + " WHERE IDCultura = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar cultura");
		}
	}

	/**
	 * Apagar cultura.
	 *
	 * @param id the id
	 */
	public void apagarCultura(int id) {
		try {
			String query = "DELETE FROM " + BDname + "Cultura WHERE IDCultura = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar cultura");
		}
	}

	// Listar(..) Medicoes

	/**
	 * Lista medicoes.
	 *
	 * @return the array list
	 */
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

	/**
	 * Inserir medicoes.
	 *
	 * @param IDCultura_fk the ID cultura fk
	 * @param iDVariavel_fk the i D variavel fk
	 * @param dataHoraMedicao the data hora medicao
	 * @param ValorMedicao the valor medicao
	 */
	public void inserirMedicoes(String IDCultura_fk, String iDVariavel_fk, String dataHoraMedicao, double ValorMedicao) {
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(dataHoraMedicao);
			String dataHora = dateFormat.format(date);
			
			String query = "INSERT INTO " + BDname + "Medicoes (IDCultura_fk, IDVariavel_fk, DataHoraMedicao, ValorMedicao) VALUES ('"
					+ IDCultura_fk + "', '" + iDVariavel_fk + "', '" + dataHora + "', '" + ValorMedicao + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Medicoes adiciona com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a inserir Medicoes");
		}
	}

	/**
	 * Actualizar medicoes.
	 *
	 * @param IDMedicoes the ID medicoes
	 * @param IDCultura_fk the ID cultura fk
	 * @param IDVariavel_fk the ID variavel fk
	 * @param dataHoraMedicao the data hora medicao
	 * @param ValorMedicao the valor medicao
	 */
	public void actualizarMedicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, String dataHoraMedicao, double ValorMedicao) {
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(dataHoraMedicao);
			String dataHora = dateFormat.format(date);
			
			String query = "UPDATE " + BDname + "Medicoes set IDCultura_fk = " + IDCultura_fk + ", IDVariavel_fk = " + IDVariavel_fk + ", "
					+ "DataHoraMedicao = '" + dataHora + "',ValorMedicao = " + ValorMedicao + " WHERE IDMedicoes = " + IDMedicoes + ";";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar Medicoes");
		}
	}

	/**
	 * Apagar medicoes.
	 *
	 * @param id the id
	 */
	public void apagarMedicoes(int id) {
		try {
			String query = "DELETE FROM " + BDname + "Medicoes WHERE IDMedicoes = '" + id + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar Medicoes");
		}
	}

	// Listar(..) Variaveis

	/**
	 * Listar variaveis.
	 *
	 * @return the array list
	 */
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

	/**
	 * Inserir variaveis.
	 *
	 * @param NomeVariaveis the nome variaveis
	 * @param IDCultura_fk the ID cultura fk
	 */
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

	/**
	 * Actualizar variaveis.
	 *
	 * @param IDVariaveis the ID variaveis
	 * @param NomeVariaveis the nome variaveis
	 * @param IDCultura_fk the ID cultura fk
	 */
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

	/**
	 * Apagar variaveis.
	 *
	 * @param id the id
	 */
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

	/**
	 * Lista variaveis medidas.
	 *
	 * @return the array list
	 */
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
	
	/**
	 * Inserir variaveis medidas.
	 *
	 * @param iDCultura_fk the i D cultura fk
	 * @param iDVariavel_fk the i D variavel fk
	 * @param limSuperior the lim superior
	 * @param limInferior the lim inferior
	 */
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

	/**
	 * Actualizar variaveis medidas.
	 *
	 * @param idCultura the id cultura
	 * @param idVariavel the id variavel
	 * @param LimiteSuperior the limite superior
	 * @param LimiteInferior the limite inferior
	 */
	public void actualizarVariaveisMedidas(int idCultura, int idVariavel, double LimiteSuperior, double LimiteInferior) {
		try {
			String query = "UPDATE " + BDname + "VariaveisMedidas set LimiteSuperior = " + LimiteSuperior + " , LimiteInferior = " + LimiteInferior
					+ " WHERE IDCultura_fk = " + idCultura + " AND IDVariavel_fk = " + idVariavel + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a actualizar VariaveisMedidas");
		}
	}

	/**
	 * Apagar variaveis medidas.
	 *
	 * @param idCultura the id cultura
	 * @param idVariavel the id variavel
	 */
	public void apagarVariaveisMedidas(int idCultura, int idVariavel) {
		try {
			String query = "DELETE FROM " + BDname + "variaveismedidas WHERE IDCultura_fk = '" + idCultura + "' AND IDVariavel_fk = '" + idVariavel + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar VariaveisMedidas");
		}
	}

	// Listar(..) MedicoesLuminiosidade

	/**
	 * Lista medicoes luminosidade.
	 *
	 * @return the array list
	 */
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

	/**
	 * Med lum.
	 *
	 * @return the medicao luminosidade
	 * @throws SQLException the SQL exception
	 */
	private MedicaoLuminosidade medLum() throws java.sql.SQLException {
		Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
		Date date = new Date(timestamp.getTime());
		MedicaoLuminosidade medLum = new MedicaoLuminosidade(this.resultset.getInt("IDMedicao"), date,
				this.resultset.getDouble("ValorMedicaoLuminosidade"));
		return medLum;
	}

	/**
	 * Inserir medicoes luminosidade.
	 *
	 * @param dataHoraMedicao the data hora medicao
	 * @param ValorMedicaoLuminosidade the valor medicao luminosidade
	 */
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

	/**
	 * Actualizar medicoes luminosidade.
	 *
	 * @param IDMedicao the ID medicao
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicaoLuminosidade the valor medicao luminosidade
	 */
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

	/**
	 * Apagar medicoes luminosidade.
	 *
	 * @param IDMedicao the ID medicao
	 */
	public void apagarMedicoesLuminosidade(int IDMedicao) {
		try {
			String query = "DELETE FROM " + BDname + "medicoesluminosidade WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoesluminosidade");
		}
	}

	// Listar(..) MedicoesTemperatura

	/**
	 * Lista medicoes temperatura.
	 *
	 * @return the array list
	 */
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
	

	/**
	 * Med temp.
	 *
	 * @return the medicao temperatura
	 * @throws SQLException the SQL exception
	 */
	private MedicaoTemperatura medTemp() throws java.sql.SQLException {
		Timestamp timestamp = this.resultset.getTimestamp("DataHoraMedicao");
		Date date = new Date(timestamp.getTime());
		MedicaoTemperatura medTemp = new MedicaoTemperatura(this.resultset.getInt("IDMedicao"), date,
				this.resultset.getDouble("ValorMedicaoTemperatura"));
		return medTemp;
	}

	/**
	 * Inserir medicoes temperatura.
	 *
	 * @param dataHoraMedicao the data hora medicao
	 * @param ValorMedicaoTemperatura the valor medicao temperatura
	 */
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

	/**
	 * Actualizar medicoes temperatura.
	 *
	 * @param IDMedicao the ID medicao
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicaoTemperatura the valor medicao temperatura
	 */
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

	/**
	 * Apagar medicoes temperatura.
	 *
	 * @param IDMedicao the ID medicao
	 */
	public void apagarMedicoesTemperatura(int IDMedicao) {
		try {
			String query = "DELETE FROM " + BDname + "medicoestemperatura WHERE IDMedicao = '" + IDMedicao + "';";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha a apagar medicoestemperatura");
		}
	}

	// Listar(..) Sistema

	/**
	 * Lista sistema.
	 *
	 * @return the array list
	 */
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
						this.resultset.getDouble("LimiteInferiorLuminosidade"),
						this.resultset.getDouble("PercentagemLimiarTemperatura"),
						this.resultset.getDouble("PercentagemLimiarLuminosidade"),
						this.resultset.getInt("NumeroMedicoesParaAlertaTemperatura"),
						this.resultset.getInt("NumeroMedicoesParaAlertaLuminosidade"),
						this.resultset.getDouble("IntervaloEntreAlertasMinutos"));

				listTemp.add(sis);
			}

			return listTemp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar sistema");
			return null;
		}
	}
	
	/**
	 * Desconectar.
	 */
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Listar utilizador log.
	 *
	 * @return the array list
	 */
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

	/**
	 * Listar alertas log.
	 *
	 * @return the array list
	 */
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

	/**
	 * Listar medicoes log.
	 *
	 * @return the array list
	 */
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

	/**
	 * Listar cultura log.
	 *
	 * @return the array list
	 */
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

	/**
	 * Listar variaveis medidas log.
	 *
	 * @return the array list
	 */
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

	/**
	 * Listar variaveis log.
	 *
	 * @return the array list
	 */
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
	
	/**
	 * Verificar alertas.
	 *
	 * @return the array list
	 */
	public ArrayList<Alerta> verificarAlertas() {
		ArrayList<Alerta> temp = new ArrayList<>();
		try {
			String query = "SELECT a.*, u.Email FROM " + BDname + "alertas a "
					+ "LEFT OUTER JOIN " + BDname + "cultura c ON a.IDCultura = c.IDCultura "
					+ "LEFT OUTER JOIN " + BDname + "utilizador u ON c.IDUtilizador_fk = u.IDUtilizador "
					+ "WHERE a.Visto = 0 "
					//+ "AND a.DataHora > DATE_SUB(NOW(), INTERVAL 1 MINUTE) "
					+ "AND (a.IDCultura IS NULL OR u.IDUtilizador = " + this.utilizadorLogado.ID + ");";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {

				Timestamp timestamp = this.resultset.getTimestamp("DataHora");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				sdf.format(date);
				
				Alerta alerta = new Alerta(Integer.parseInt(this.resultset.getString("IDAlerta")),
						this.resultset.getString("Email"),
						date,
						this.resultset.getString("NomeVariavel"),
						this.resultset.getDouble("LimiteInferior"),
						this.resultset.getDouble("LimiteSuperior"),
						this.resultset.getDouble("ValorMedicao"),
						this.resultset.getString("Descricao"));
				temp.add(alerta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha a listar alertas");
		}
		return temp;
	}
	
	/**
	 * Tornar alerta visto.
	 *
	 * @param alerta the alerta
	 */
	public void tornarAlertaVisto(Alerta alerta) {
		try {
			String query = "UPDATE " + BDname + "alertas SET Visto = 1 WHERE IDAlerta = " + alerta.getIDAlerta() + ";";
			this.statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha tornar alertas vistos");
		}
	}
}