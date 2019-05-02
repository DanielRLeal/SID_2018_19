package bancoDeDados;

public class Utilizador implements ObjectBD{
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
		ID = iD;
		NomeUtilizador = nomeUtilizador;
		CategoriaProfissional = categoriaProfissional;
		Email = email;
		Ativo = ativo;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[]{ this.ID, this.NomeUtilizador, this.CategoriaProfissional, this.Email, this.Ativo };
	}
}
