package bancoDeDados;

/**
 * Class Medicoes_Log.
 */
public class Medicoes_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID log utilizador. */
	public int IDLogUtilizador;
	
	/** The ID medicoes. */
	public final int IDMedicoes;
	
	/** The ID cultura. */
	public int IDCultura;
	
	/** The ID variavel. */
	public int IDVariavel;
	
	/** The Data hora medicao. */
	public String DataHoraMedicao;
	
	/** The Valor medicao. */
	public double ValorMedicao;
	
	/** The Operacao. */
	public String Operacao;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new medicoes log.
	 *
	 * @param IDLog the ID log
	 * @param IDLogUtilizador the ID log utilizador
	 * @param IDMedicoes the ID medicoes
	 * @param IDCultura the ID cultura
	 * @param IDVariavel the ID variavel
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicao the valor medicao
	 * @param Operacao the operacao
	 * @param data the data
	 */
	public Medicoes_Log(int IDLog, int IDLogUtilizador, int IDMedicoes, int IDCultura, int IDVariavel,
			String DataHoraMedicao, double ValorMedicao, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDMedicoes = IDMedicoes;
		this.IDCultura = IDCultura;
		this.IDVariavel = IDVariavel;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicao = ValorMedicao;
		this.Operacao = Operacao;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDMedicoes, this.IDCultura, this.IDVariavel,
				this.DataHoraMedicao, this.ValorMedicao, this.Operacao, this.data };
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
	 * Gets the ID cultura.
	 *
	 * @return the ID cultura
	 */
	public int getIDCultura() {
		return IDCultura;
	}

	/**
	 * Sets the ID cultura.
	 *
	 * @param iDCultura the new ID cultura
	 */
	public void setIDCultura(int iDCultura) {
		IDCultura = iDCultura;
	}

	/**
	 * Gets the ID variavel.
	 *
	 * @return the ID variavel
	 */
	public int getIDVariavel() {
		return IDVariavel;
	}

	/**
	 * Sets the ID variavel.
	 *
	 * @param iDVariavel the new ID variavel
	 */
	public void setIDVariavel(int iDVariavel) {
		IDVariavel = iDVariavel;
	}

	/**
	 * Gets the data hora medicao.
	 *
	 * @return the data hora medicao
	 */
	public String getDataHoraMedicao() {
		return DataHoraMedicao;
	}

	/**
	 * Sets the data hora medicao.
	 *
	 * @param dataHoraMedicao the new data hora medicao
	 */
	public void setDataHoraMedicao(String dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
	}

	/**
	 * Gets the valor medicao.
	 *
	 * @return the valor medicao
	 */
	public double getValorMedicao() {
		return ValorMedicao;
	}

	/**
	 * Sets the valor medicao.
	 *
	 * @param valorMedicao the new valor medicao
	 */
	public void setValorMedicao(int valorMedicao) {
		ValorMedicao = valorMedicao;
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
	 * Gets the ID medicoes.
	 *
	 * @return the ID medicoes
	 */
	public int getIDMedicoes() {
		return IDMedicoes;
	}

}
