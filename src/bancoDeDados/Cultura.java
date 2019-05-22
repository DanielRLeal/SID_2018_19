package bancoDeDados;

/**
 * Class Cultura.
 */
public class Cultura implements ObjectBD {
	
	/** The id. */
	public final int ID;
	
	/** The Nome cultura. */
	public String NomeCultura;
	
	/** The Descricao cultura. */
	public String DescricaoCultura;
	
	/** The ID utilizador fk. */
	public int IDUtilizador_fk;
	
	/** The Nome utilizador. */
	public String NomeUtilizador;

	/**
	 * Instantiates a new cultura.
	 *
	 * @param iD the i D
	 * @param nomeCultura the nome cultura
	 * @param descricaoCultura the descricao cultura
	 * @param iDUtilizador_fk the i D utilizador fk
	 * @param nomeUtilizador the nome utilizador
	 */
	public Cultura(int iD, String nomeCultura, String descricaoCultura, int iDUtilizador_fk, String nomeUtilizador) {
		ID = iD;
		NomeCultura = nomeCultura;
		DescricaoCultura = descricaoCultura;
		IDUtilizador_fk = iDUtilizador_fk;
		NomeUtilizador = nomeUtilizador;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.ID, this.NomeCultura, this.DescricaoCultura, this.NomeUtilizador };
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
	 * Gets the ID utilizador fk.
	 *
	 * @return the ID utilizador fk
	 */
	public int getIDUtilizador_fk() {
		return IDUtilizador_fk;
	}

	/**
	 * Sets the ID utilizador fk.
	 *
	 * @param iDUtilizador_fk the new ID utilizador fk
	 */
	public void setIDUtilizador_fk(int iDUtilizador_fk) {
		IDUtilizador_fk = iDUtilizador_fk;
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
	 * Sets the nome utilizador.
	 *
	 * @param nomeUtilizador the new nome utilizador
	 */
	public void setNomeUtilizador(String nomeUtilizador) {
		NomeUtilizador = nomeUtilizador;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return ID;
	}
}
