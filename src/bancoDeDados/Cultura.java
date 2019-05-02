package bancoDeDados;

public class Cultura implements ObjectBD {
	public final int ID;
	public String NomeCultura;
	public String DescricaoCultura;
	public int IDUtilizador_fk;
	public String NomeUtilizador;
	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public Cultura(int iD, String nomeCultura, String descricaoCultura, int iDUtilizador_fk, String nomeUtilizador) {
		ID = iD;
		NomeCultura = nomeCultura;
		DescricaoCultura = descricaoCultura;
		IDUtilizador_fk = iDUtilizador_fk;
		NomeUtilizador = nomeUtilizador;
	}
	
	public Object[] toObjectArray(){
		return new Object[]{ this.ID, this.NomeCultura, this.DescricaoCultura, this.NomeUtilizador };
	}
}
