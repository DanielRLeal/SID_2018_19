package bancoDeDados;

/**
 * Class Utilizador_Log.
 */
public class Utilizador_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID log utilizador. */
	public int IDLogUtilizador;
	
	/** The ID utilizador. */
	public final int IDUtilizador;
	
	/** The Nome utilizador. */
	public String NomeUtilizador;
	
	/** The Categoria profissional. */
	public String CategoriaProfissional;
	
	/** The Email. */
	public String Email;
	
	/** The Ativo. */
	public boolean Ativo;
	
	/** The Operacao. */
	public String Operacao;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new utilizador log.
	 *
	 * @param IDLog the ID log
	 * @param IDLogUtilizador the ID log utilizador
	 * @param IDUtilizador the ID utilizador
	 * @param nomeUtilizador the nome utilizador
	 * @param categoriaProfissional the categoria profissional
	 * @param email the email
	 * @param ativo the ativo
	 * @param Operacao the operacao
	 * @param data the data
	 */
	public Utilizador_Log(int IDLog, int IDLogUtilizador, int IDUtilizador, String nomeUtilizador,
			String categoriaProfissional, String email, boolean ativo, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDUtilizador = IDUtilizador;
		this.NomeUtilizador = nomeUtilizador;
		this.CategoriaProfissional = categoriaProfissional;
		this.Email = email;
		this.Ativo = ativo;
		this.Operacao = Operacao;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDUtilizador, this.NomeUtilizador,
				this.CategoriaProfissional, this.Email, this.Ativo, this.Operacao, this.data };
	}

	/**
	 * Gets the nome utilizador.
	 *
	 * @return the nome utilizador
	 */
	public String getNomeUtilizador() {
		return NomeUtilizador;
	}

	/**
	 * Gets the ID log.
	 *
	 * @return the ID log
	 */
	public int getIDLog() {
		return IDLog;
	}

	/**
	 * Sets the ID log.
	 *
	 * @param iDLog the new ID log
	 */
	public void setIDLog(int iDLog) {
		IDLog = iDLog;
	}

	/**
	 * Gets the ID log utilizador.
	 *
	 * @return the ID log utilizador
	 */
	public int getIDLogUtilizador() {
		return IDLogUtilizador;
	}

	/**
	 * Sets the ID log utilizador.
	 *
	 * @param iDLogUtilizador the new ID log utilizador
	 */
	public void setIDLogUtilizador(int iDLogUtilizador) {
		IDLogUtilizador = iDLogUtilizador;
	}

	/**
	 * Gets the operacao.
	 *
	 * @return the operacao
	 */
	public String getOperacao() {
		return Operacao;
	}

	/**
	 * Sets the operacao.
	 *
	 * @param operacao the new operacao
	 */
	public void setOperacao(String operacao) {
		Operacao = operacao;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Sets the nome utilizador.
	 *
	 * @param nomeUtilizador the new nome utilizador
	 */
	public void setNomeUtilizador(String nomeUtilizador) {
		NomeUtilizador = nomeUtilizador;
	}

	/**
	 * Gets the categoria profissional.
	 *
	 * @return the categoria profissional
	 */
	public String getCategoriaProfissional() {
		return CategoriaProfissional;
	}

	/**
	 * Sets the categoria profissional.
	 *
	 * @param categoriaProfissional the new categoria profissional
	 */
	public void setCategoriaProfissional(String categoriaProfissional) {
		CategoriaProfissional = categoriaProfissional;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * Checks if is ativo.
	 *
	 * @return true, if is ativo
	 */
	public boolean isAtivo() {
		return Ativo;
	}

	/**
	 * Sets the ativo.
	 *
	 * @param ativo the new ativo
	 */
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	/**
	 * Gets the ID utilizador.
	 *
	 * @return the ID utilizador
	 */
	public int getIDUtilizador() {
		return IDUtilizador;
	}

}
