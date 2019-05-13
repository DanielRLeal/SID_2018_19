package bancoDeDados;

public class Cultura_Log implements ObjectBD {
	public int IDLog;
	public int IDLogUtilizador;
	public final int IDCultura;
	public String NomeCultura;
	public String DescricaoCultura;
	public int IDUtilizador;
	public String Operacao;
	public String data;

	public Cultura_Log(int IDLog, int IDLogUtilizador, int IDCultura, String NomeCultura, String DescricaoCultura,
			int IDUtilizador, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.NomeCultura = NomeCultura;
		this.DescricaoCultura = DescricaoCultura;
		this.IDUtilizador = IDUtilizador;
		this.Operacao = Operacao;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDCultura, this.NomeCultura, this.DescricaoCultura,
				this.IDUtilizador, this.Operacao, this.data };
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

	public int getIDUtilizador() {
		return IDUtilizador;
	}

	public void setIDUtilizador(int iDUtilizador) {
		IDUtilizador = iDUtilizador;
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


}
