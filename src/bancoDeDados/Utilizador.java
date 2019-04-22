package bancoDeDados;

import org.omg.CORBA.Environment;

public class Utilizador {
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
	public String toString(){
		return "IDUtilizador: " + this.ID + ";\r\n Nome do Utilizador: "
				+ this.NomeUtilizador + ";\r\n Categoria Profissional:"
				+ this.CategoriaProfissional + ";\r\n Email: "
				+ this.Email + ";\r\n Activo: " + this.Ativo;
	}
}
