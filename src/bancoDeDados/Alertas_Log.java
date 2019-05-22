package bancoDeDados;

/**
 * Class Alertas_Log.
 */
public class Alertas_Log implements ObjectBD {
	
	/** The ID log. */
	public int IDLog;
	
	/** The ID alerta. */
	public int IDAlerta;
	
	/** The ID cultura. */
	public final int IDCultura;
	
	/** The Data hora. */
	public String DataHora;
	
	/** The Nome variavel. */
	public String NomeVariavel;
	
	/** The Limite inferior. */
	public double LimiteInferior;
	
	/** The Limite superior. */
	public double LimiteSuperior;
	
	/** The Valor medicao. */
	public double ValorMedicao;
	
	/** The Descricao. */
	public String Descricao;
	
	/** The Visto. */
	public boolean Visto;
	
	/** The data. */
	public String data;

	/**
	 * Instantiates a new alertas log.
	 *
	 * @param IDLog the ID log
	 * @param IDAlerta the ID alerta
	 * @param IDCultura the ID cultura
	 * @param DataHora the data hora
	 * @param NomeVariavel the nome variavel
	 * @param LimiteInferior the limite inferior
	 * @param LimiteSuperior the limite superior
	 * @param ValorMedicao the valor medicao
	 * @param Descricao the descricao
	 * @param Visto the visto
	 * @param data the data
	 */
	public Alertas_Log(int IDLog, int IDAlerta, int IDCultura, String DataHora, String NomeVariavel,
			double LimiteInferior, double LimiteSuperior, double ValorMedicao, String Descricao, boolean Visto,
			String data) {
		this.IDLog = IDLog;
		this.IDAlerta = IDAlerta;
		this.IDCultura = IDCultura;
		this.DataHora = DataHora;
		this.NomeVariavel = NomeVariavel;
		this.LimiteInferior = LimiteInferior;
		this.Descricao = Descricao;
		this.Visto = Visto;
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDAlerta, this.IDCultura, this.DataHora, this.NomeVariavel,
				this.LimiteInferior, this.LimiteSuperior, this.ValorMedicao, this.Descricao, this.Visto, this.data };
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
	 * Gets the ID alerta.
	 *
	 * @return the ID alerta
	 */
	public int getIDAlerta() {
		return IDAlerta;
	}

	/**
	 * Sets the ID alerta.
	 *
	 * @param iDAlerta the new ID alerta
	 */
	public void setIDAlerta(int iDAlerta) {
		IDAlerta = iDAlerta;
	}

	/**
	 * Gets the data hora.
	 *
	 * @return the data hora
	 */
	public String getDataHora() {
		return DataHora;
	}

	/**
	 * Sets the data hora.
	 *
	 * @param dataHora the new data hora
	 */
	public void setDataHora(String dataHora) {
		DataHora = dataHora;
	}

	/**
	 * Gets the nome variavel.
	 *
	 * @return the nome variavel
	 */
	public String getNomeVariavel() {
		return NomeVariavel;
	}

	/**
	 * Sets the nome variavel.
	 *
	 * @param nomeVariavel the new nome variavel
	 */
	public void setNomeVariavel(String nomeVariavel) {
		NomeVariavel = nomeVariavel;
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
	public void setLimiteSuperior(int limiteSuperior) {
		LimiteSuperior = limiteSuperior;
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
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return Descricao;
	}

	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	/**
	 * Checks if is visto.
	 *
	 * @return true, if is visto
	 */
	public boolean isVisto() {
		return Visto;
	}

	/**
	 * Sets the visto.
	 *
	 * @param visto the new visto
	 */
	public void setVisto(boolean visto) {
		Visto = visto;
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
}
