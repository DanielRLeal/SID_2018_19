package bancoDeDados;

public class Variaveis_Log implements ObjectBD {
	public int IDLog;
	public int IDLogUtilizador;
	public final int IDCultura;
	public final int IDVariaveis;
	public String NomeVariaveis;
	public String Operacao;
	public String data;

	public Variaveis_Log(int IDLog, int IDLogUtilizador, int IDVariaveis, String NomeVariaveis, int IDCultura,
			String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDCultura = IDCultura;
		this.NomeVariaveis = NomeVariaveis;
		this.IDVariaveis = IDVariaveis;
		this.Operacao = Operacao;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDVariaveis, this.NomeVariaveis, this.IDCultura,
				this.Operacao, this.data };
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

	public String getNomeVariaveis() {
		return NomeVariaveis;
	}

	public void setNomeVariaveis(String nomeVariaveis) {
		NomeVariaveis = nomeVariaveis;
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

	public int getIDVariaveis() {
		return IDVariaveis;
	}

}
