package bancoDeDados;

public class VariaveisMedidas implements ObjectBD {
	private int IDCultura_fk;
	private int IDVariavel_fk;
	private double LimiteSuperior;
	private double LimiteInferior;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public VariaveisMedidas(int IDCultura_fk, int IDVariavel_fk, double d, double e) {
		this.IDCultura_fk = IDCultura_fk;
		this.IDVariavel_fk = IDVariavel_fk;
		this.LimiteSuperior = d;
		this.LimiteInferior = e;
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

	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	public void setLimiteSuperior(int limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}

	public double getLimiteInferior() {
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
