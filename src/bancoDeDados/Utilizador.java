package bancoDeDados;

/**
 * Class Utilizador.
 */
public class Utilizador implements ObjectBD {
	
	/** The id. */
	public final int ID;
	
	/** The Nome utilizador. */
	public String NomeUtilizador;
	
	/** The Categoria profissional. */
	public String CategoriaProfissional;
	
	/** The Email. */
	public String Email;
	
	/** The Ativo. */
	public boolean Ativo;

	/**
	 * Instantiates a new utilizador.
	 *
	 * @param iD the i D
	 * @param nomeUtilizador the nome utilizador
	 * @param categoriaProfissional the categoria profissional
	 * @param email the email
	 * @param ativo the ativo
	 */
	public Utilizador(int iD, String nomeUtilizador, String categoriaProfissional, String email, boolean ativo) {
		this.ID = iD;
		this.NomeUtilizador = nomeUtilizador;
		this.CategoriaProfissional = categoriaProfissional;
		this.Email = email;
		this.Ativo = ativo;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.ID, this.NomeUtilizador, this.CategoriaProfissional, this.Email, this.Ativo };
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return ID;
	}
}
