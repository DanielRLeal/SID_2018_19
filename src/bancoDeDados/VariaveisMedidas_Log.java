package bancoDeDados;

/**
 * Class VariaveisMedidas_Log.
 */
public class VariaveisMedidas_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID log utilizador. */
	public int IDLogUtilizador;
	
	/** The ID cultura. */
	public final int IDCultura;
	
	/** The ID variavel. */
	public final int IDVariavel;
	
	/** The Limite superior. */
	public double LimiteSuperior;
	
	/** The Limite inferior. */
	public double LimiteInferior;
	
	/** The Operacao. */
	public String Operacao;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new variaveis medidas log.
	 *
	 * @param IDLog the ID log
	 * @param IDLogUtilizador the ID log utilizador
	 * @param IDCultura the ID cultura
	 * @param IDVariavel the ID variavel
	 * @param LimiteSuperior the limite superior
	 * @param LimiteInferior the limite inferior
	 * @param Operacao the operacao
	 * @param data the data
	 */
	public VariaveisMedidas_Log(int IDLog, int IDLogUtilizador, int IDCultura, int IDVariavel, double LimiteSuperior,
			double LimiteInferior, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.IDVariavel = IDVariavel;
		this.LimiteSuperior = LimiteSuperior;
		this.LimiteInferior = LimiteInferior;
		this.Operacao = Operacao;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDCultura, this.IDVariavel, this.LimiteSuperior,
				this.LimiteInferior, this.Operacao, this.data };
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
	 * Gets the limite superior.
	 *
	 * @return the limite superior
	 */
	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	/**
	 * Sets the limite superior.
	 *
	 * @param limiteSuperior the new limite superior
	 */
	public void setLimiteSuperior(double limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}

	/**
	 * Gets the limite inferior.
	 *
	 * @return the limite inferior
	 */
	public double getLimiteInferior() {
		return LimiteInferior;
	}

	/**
	 * Sets the limite inferior.
	 *
	 * @param limiteInferior the new limite inferior
	 */
	public void setLimiteInferior(double limiteInferior) {
		LimiteInferior = limiteInferior;
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
	 * Gets the ID variavel.
	 *
	 * @return the ID variavel
	 */
	public int getIDVariavel() {
		return IDVariavel;
	}

}
