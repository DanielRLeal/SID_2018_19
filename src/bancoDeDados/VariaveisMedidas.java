package bancoDeDados;

public class VariaveisMedidas implements ObjectBD {
	private int IDCultura_fk;
	private int IDVariavel_fk;
	private int LimiteSuperior;
	private int LimiteInferior;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public VariaveisMedidas(int IDCultura_fk, int IDVariavel_fk, int LimiteSuperior, int LimiteInferior) {
		this.IDCultura_fk = IDCultura_fk;
		this.IDVariavel_fk = IDVariavel_fk;
		this.LimiteSuperior = LimiteSuperior;
		this.LimiteInferior = LimiteInferior;
	}

	public int getIDCultura_fk() {
		return IDCultura_fk;
	}

	public void setIDCultura_fk(int iDCultura_fk) {
		IDCultura_fk = iDCultura_fk;
	}

	public int getIDVariavel_fk() {
		return IDVariavel_fk;
	}

	public void setIDVariavel_fk(int iDVariavel_fk) {
		IDVariavel_fk = iDVariavel_fk;
	}

	public int getLimiteSuperior() {
		return LimiteSuperior;
	}

	public void setLimiteSuperior(int limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}

	public int getLimiteInferior() {
		return LimiteInferior;
	}

	public void setLimiteInferior(int limiteInferior) {
		LimiteInferior = limiteInferior;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDCultura_fk, this.IDVariavel_fk, this.LimiteInferior, this.LimiteSuperior };
	}

}
