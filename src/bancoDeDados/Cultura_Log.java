package bancoDeDados;

/**
 * Class Cultura_Log.
 */
public class Cultura_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID log utilizador. */
	public int IDLogUtilizador;
	
	/** The ID cultura. */
	public final int IDCultura;
	
	/** The Nome cultura. */
	public String NomeCultura;
	
	/** The Descricao cultura. */
	public String DescricaoCultura;
	
	/** The ID utilizador. */
	public int IDUtilizador;
	
	/** The Operacao. */
	public String Operacao;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new cultura log.
	 *
	 * @param IDLog the ID log
	 * @param IDLogUtilizador the ID log utilizador
	 * @param IDCultura the ID cultura
	 * @param NomeCultura the nome cultura
	 * @param DescricaoCultura the descricao cultura
	 * @param IDUtilizador the ID utilizador
	 * @param Operacao the operacao
	 * @param data the data
	 */
	public Cultura_Log(int IDLog, int IDLogUtilizador, int IDCultura, String NomeCultura, String DescricaoCultura,
			int IDUtilizador, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.NomeCultura = NomeCultura;
		this.DescricaoCultura = DescricaoCultura;
		this.IDUtilizador = IDUtilizador;
		this.Operacao = Operacao;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDCultura, this.NomeCultura, this.DescricaoCultura,
				this.IDUtilizador, this.Operacao, this.data };
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
	 * Gets the nome cultura.
	 *
	 * @return the nome cultura
	 */
	public String getNomeCultura() {
		return NomeCultura;
	}

	/**
	 * Sets the nome cultura.
	 *
	 * @param nomeCultura the new nome cultura
	 */
	public void setNomeCultura(String nomeCultura) {
		NomeCultura = nomeCultura;
	}

	/**
	 * Gets the descricao cultura.
	 *
	 * @return the descricao cultura
	 */
	public String getDescricaoCultura() {
		return DescricaoCultura;
	}

	/**
	 * Sets the descricao cultura.
	 *
	 * @param descricaoCultura the new descricao cultura
	 */
	public void setDescricaoCultura(String descricaoCultura) {
		DescricaoCultura = descricaoCultura;
	}

	/**
	 * Gets the ID utilizador.
	 *
	 * @return the ID utilizador
	 */
	public int getIDUtilizador() {
		return IDUtilizador;
	}

	/**
	 * Sets the ID utilizador.
	 *
	 * @param iDUtilizador the new ID utilizador
	 */
	public void setIDUtilizador(int iDUtilizador) {
		IDUtilizador = iDUtilizador;
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


}
