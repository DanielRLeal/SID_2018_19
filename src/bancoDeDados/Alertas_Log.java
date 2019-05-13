package bancoDeDados;

public class Alertas_Log implements ObjectBD {
	public int IDLog;
	public int IDAlerta;
	public final int IDUtilizador;
	public String DataHora;
	public String NomeVariavel;
	public double LimiteInferior;
	public double LimiteSuperior;
	public double ValorMedicao;
	public String Descricao;
	public boolean Visto;
	public String data;

	public Alertas_Log(int IDLog, int IDAlerta, int IDUtilizador, String DataHora, String NomeVariavel,
			double LimiteInferior, double LimiteSuperior, double ValorMedicao, String Descricao, boolean Visto,
			String data) {
		this.IDLog = IDLog;
		this.IDAlerta = IDAlerta;
		this.IDUtilizador = IDUtilizador;
		this.DataHora = DataHora;
		this.NomeVariavel = NomeVariavel;
		this.LimiteInferior = LimiteInferior;
		this.Descricao = Descricao;
		this.Visto = Visto;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDAlerta, this.IDUtilizador, this.DataHora, this.NomeVariavel,
				this.LimiteInferior, this.LimiteSuperior, this.ValorMedicao, this.Descricao, this.Visto, this.data };
	}

	public int getIDLog() {
		return IDLog;
	}

	public void setIDLog(int iDLog) {
		IDLog = iDLog;
	}

	public int getIDAlerta() {
		return IDAlerta;
	}

	public void setIDAlerta(int iDAlerta) {
		IDAlerta = iDAlerta;
	}

	public String getDataHora() {
		return DataHora;
	}

	public void setDataHora(String dataHora) {
		DataHora = dataHora;
	}

	public String getNomeVariavel() {
		return NomeVariavel;
	}

	public void setNomeVariavel(String nomeVariavel) {
		NomeVariavel = nomeVariavel;
	}

	public double getLimiteInferior() {
		return LimiteInferior;
	}

	public void setLimiteInferior(double limiteInferior) {
		LimiteInferior = limiteInferior;
	}

	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	public void setLimiteSuperior(int limiteSuperior) {
		LimiteSuperior = limiteSuperior;
	}

	public double getValorMedicao() {
		return ValorMedicao;
	}

	public void setValorMedicao(int valorMedicao) {
		ValorMedicao = valorMedicao;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public boolean isVisto() {
		return Visto;
	}

	public void setVisto(boolean visto) {
		Visto = visto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIDUtilizador() {
		return IDUtilizador;
	}

}
