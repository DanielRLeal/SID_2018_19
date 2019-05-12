package bancoDeDados;

public class Utilizador implements ObjectBD {
	public final int ID;
	public String NomeUtilizador;
	public String CategoriaProfissional;
	public String Email;
	public boolean Ativo;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public Utilizador(int iD, String nomeUtilizador, String categoriaProfissional, String email, boolean ativo) {
		this.ID = iD;
		this.NomeUtilizador = nomeUtilizador;
		this.CategoriaProfissional = categoriaProfissional;
		this.Email = email;
		this.Ativo = ativo;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.ID, this.NomeUtilizador, this.CategoriaProfissional, this.Email, this.Ativo };
	}

	public String getNomeUtilizador() {
		return NomeUtilizador;
	}

	public void setNomeUtilizador(String nomeUtilizador) {
		NomeUtilizador = nomeUtilizador;
	}

	public String getCategoriaProfissional() {
		return CategoriaProfissional;
	}

	public void setCategoriaProfissional(String categoriaProfissional) {
		CategoriaProfissional = categoriaProfissional;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public int getID() {
		return ID;
	}
}
