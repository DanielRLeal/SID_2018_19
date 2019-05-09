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

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.ID, this.NomeCultura, this.DescricaoCultura, this.NomeUtilizador };
	}

	public String getNomeCultura() {
		return NomeCultura;
	}

	public void setNomeCultura(String nomeCultura) {
		NomeCultura = nomeCultura;
	}

	public String getDescricaoCultura() {
		return DescricaoCultura;
	}

	public void setDescricaoCultura(String descricaoCultura) {
		DescricaoCultura = descricaoCultura;
	}

	public int getIDUtilizador_fk() {
		return IDUtilizador_fk;
	}

	public void setIDUtilizador_fk(int iDUtilizador_fk) {
		IDUtilizador_fk = iDUtilizador_fk;
	}

	public String getNomeUtilizador() {
		return NomeUtilizador;
	}

	public void setNomeUtilizador(String nomeUtilizador) {
		NomeUtilizador = nomeUtilizador;
	}

	public int getID() {
		return ID;
	}
}
