package bancoDeDados;

/**
 * Class Variaveis_Log.
 */
public class Variaveis_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID log utilizador. */
	public int IDLogUtilizador;
	
	/** The ID cultura. */
	public final int IDCultura;
	
	/** The ID variaveis. */
	public final int IDVariaveis;
	
	/** The Nome variaveis. */
	public String NomeVariaveis;
	
	/** The Operacao. */
	public String Operacao;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new variaveis log.
	 *
	 * @param IDLog the ID log
	 * @param IDLogUtilizador the ID log utilizador
	 * @param IDVariaveis the ID variaveis
	 * @param NomeVariaveis the nome variaveis
	 * @param IDCultura the ID cultura
	 * @param Operacao the operacao
	 * @param data the data
	 */
	public Variaveis_Log(int IDLog, int IDLogUtilizador, int IDVariaveis, String NomeVariaveis, int IDCultura,
			String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.NomeVariaveis = NomeVariaveis;
		this.IDVariaveis = IDVariaveis;
		this.Operacao = Operacao;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDVariaveis, this.NomeVariaveis, this.IDCultura,
				this.Operacao, this.data };
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
	 * Gets the nome variaveis.
	 *
	 * @return the nome variaveis
	 */
	public String getNomeVariaveis() {
		return NomeVariaveis;
	}

	/**
	 * Sets the nome variaveis.
	 *
	 * @param nomeVariaveis the new nome variaveis
	 */
	public void setNomeVariaveis(String nomeVariaveis) {
		NomeVariaveis = nomeVariaveis;
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
	 * Gets the ID cultura.
	 *
	 * @return the ID cultura
	 */
	public int getIDCultura() {
		return IDCultura;
	}

	/**
	 * Gets the ID variaveis.
	 *
	 * @return the ID variaveis
	 */
	public int getIDVariaveis() {
		return IDVariaveis;
	}

}
