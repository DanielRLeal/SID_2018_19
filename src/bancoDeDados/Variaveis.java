package bancoDeDados;

/**
 * Class Variaveis.
 */
public class Variaveis implements ObjectBD {
	
	/** The ID variaveis. */
	private int IDVariaveis;
	
	/** The Nome variaveis. */
	private String NomeVariaveis;
	
	/** The ID cultura fk. */
	private int IDCultura_fk;
	
	/** The Nome cultura. */
	private String NomeCultura;

	/**
	 * Instantiates a new variaveis.
	 *
	 * @param IDVariaveis the ID variaveis
	 * @param NomeVariaveis the nome variaveis
	 * @param IDCultura_fk the ID cultura fk
	 * @param NomeCultura the nome cultura
	 */
	public Variaveis(int IDVariaveis, String NomeVariaveis, int IDCultura_fk, String NomeCultura) {
		this.IDVariaveis = IDVariaveis;
		this.NomeVariaveis = NomeVariaveis;
		this.IDCultura_fk = IDCultura_fk;
		this.NomeCultura = NomeCultura;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDVariaveis, this.NomeVariaveis, this.NomeCultura };
	}

	/**
	 * Gets the ID variaveis.
	 *
	 * @return the ID variaveis
	 */
	public int getIDVariaveis() {
		return IDVariaveis;
	}

	/**
	 * Sets the ID variaveis.
	 *
	 * @param iDVariaveis the new ID variaveis
	 */
	public void setIDVariaveis(int iDVariaveis) {
		IDVariaveis = iDVariaveis;
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
}