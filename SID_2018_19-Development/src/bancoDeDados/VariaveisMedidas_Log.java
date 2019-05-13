package bancoDeDados;

public class VariaveisMedidas_Log implements ObjectBD {
	public int IDLog;
	public int IDLogUtilizador;
	public final int IDCultura;
	public final int IDVariavel;
	public double LimiteSuperior;
	public double LimiteInferior;
	public String Operacao;
	public String data;

	public VariaveisMedidas_Log(int IDLog, int IDLogUtilizador, int IDCultura, int IDVariavel, double LimiteSuperior,
			double LimiteInferior, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.IDVariavel = IDVariavel;
		this.LimiteSuperior = LimiteSuperior;
		this.LimiteInferior = LimiteInferior;
		this.Operacao = Operacao;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDCultura, this.IDVariavel, this.LimiteSuperior,
				this.LimiteInferior, this.Operacao, this.data };
	}

	public int getIDLog() {
		return IDLog;
	}

	public void setIDLog(int iDLog) {
		IDLog = iDLog;
	}

	public int getIDLogUtilizador() {
		return IDLogUtilizador;
	}

	public void setIDLogUtilizador(int iDLogUtilizador) {
		IDLogUtilizador = iDLogUtilizador;
	}

	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	public void setLimiteSuperior(double limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}

	public double getLimiteInferior() {
		return LimiteInferior;
	}

	public void setLimiteInferior(double limiteInferior) {
		LimiteInferior = limiteInferior;
	}

	public String getOperacao() {
		return Operacao;
	}

	public void setOperacao(String operacao) {
		Operacao = operacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIDCultura() {
		return IDCultura;
	}

	public int getIDVariavel() {
		return IDVariavel;
	}

}
