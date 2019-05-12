package bancoDeDados;

public class Medicoes_Log implements ObjectBD {
	public int IDLog;
	public int IDLogUtilizador;
	public final int IDMedicoes;
	public int IDCultura;
	public int IDVariavel;
	public String DataHoraMedicao;
	public int ValorMedicao;
	public String Operacao;
	public String data;

	public Medicoes_Log(int IDLog, int IDLogUtilizador, int IDMedicoes, int IDCultura, int IDVariavel,
			String DataHoraMedicao, int ValorMedicao, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDMedicoes = IDMedicoes;
		this.IDCultura = IDCultura;
		this.IDVariavel = IDVariavel;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicao = ValorMedicao;
		this.Operacao = Operacao;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDMedicoes, this.IDCultura, this.IDVariavel,
				this.DataHoraMedicao, this.ValorMedicao, this.Operacao, this.data };
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

	public int getIDCultura() {
		return IDCultura;
	}

	public void setIDCultura(int iDCultura) {
		IDCultura = iDCultura;
	}

	public int getIDVariavel() {
		return IDVariavel;
	}

	public void setIDVariavel(int iDVariavel) {
		IDVariavel = iDVariavel;
	}

	public String getDataHoraMedicao() {
		return DataHoraMedicao;
	}

	public void setDataHoraMedicao(String dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
	}

	public int getValorMedicao() {
		return ValorMedicao;
	}

	public void setValorMedicao(int valorMedicao) {
		ValorMedicao = valorMedicao;
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

	public int getIDMedicoes() {
		return IDMedicoes;
	}

}
