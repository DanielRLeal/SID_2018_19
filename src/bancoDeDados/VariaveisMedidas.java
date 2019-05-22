package bancoDeDados;

/**
 * Class VariaveisMedidas.
 */
public class VariaveisMedidas implements ObjectBD {
	
	/** The ID cultura fk. */
	private int IDCultura_fk;
	
	/** The Nome cultura. */
	private String NomeCultura;
	
	/** The ID variavel fk. */
	private int IDVariavel_fk;
	
	/** The Nome variavel. */
	private String NomeVariavel;
	
	/** The Limite superior. */
	private double LimiteSuperior;
	
	/** The Limite inferior. */
	private double LimiteInferior;

	/**
	 * Instantiates a new variaveis medidas.
	 *
	 * @param IDCultura_fk the ID cultura fk
	 * @param NomeCultura the nome cultura
	 * @param IDVariavel_fk the ID variavel fk
	 * @param NomeVariavel the nome variavel
	 * @param d the d
	 * @param e the e
	 */
	public VariaveisMedidas(int IDCultura_fk, String NomeCultura, int IDVariavel_fk, String NomeVariavel, double d, double e) {
		this.IDCultura_fk = IDCultura_fk;
		this.NomeCultura = NomeCultura;
		this.IDVariavel_fk = IDVariavel_fk;
		this.NomeVariavel = NomeVariavel;
		this.LimiteSuperior = d;
		this.LimiteInferior = e;
	}

	/**
	 * Gets the ID cultura fk.
	 *
	 * @return the ID cultura fk
	 */
	public int getIDCultura_fk() {
		return IDCultura_fk;
	}

	/**
	 * Sets the ID cultura fk.
	 *
	 * @param iDCultura_fk the new ID cultura fk
	 */
	public void setIDCultura_fk(int iDCultura_fk) {
		IDCultura_fk = iDCultura_fk;
	}

	/**
	 * Gets the ID variavel fk.
	 *
	 * @return the ID variavel fk
	 */
	public int getIDVariavel_fk() {
		return IDVariavel_fk;
	}

	/**
	 * Sets the ID variavel fk.
	 *
	 * @param iDVariavel_fk the new ID variavel fk
	 */
	public void setIDVariavel_fk(int iDVariavel_fk) {
		IDVariavel_fk = iDVariavel_fk;
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
	public void setLimiteInferior(int limiteInferior) {
		LimiteInferior = limiteInferior;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.NomeCultura, this.NomeVariavel, this.LimiteInferior, this.LimiteSuperior };
	}

}
