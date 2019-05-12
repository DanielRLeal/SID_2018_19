package bancoDeDados;

public class Utilizador_Log implements ObjectBD {
	public int IDLog;
	public int IDLogUtilizador;
	public final int IDUtilizador;
	public String NomeUtilizador;
	public String CategoriaProfissional;
	public String Email;
	public boolean Ativo;
	public String Operacao;
	public String data;

	public Utilizador_Log(int IDLog, int IDLogUtilizador, int IDUtilizador, String nomeUtilizador,
			String categoriaProfissional, String email, boolean ativo, String Operacao, String data) {
		this.IDLog = IDLog;
		this.IDLogUtilizador = IDLogUtilizador;
		this.IDUtilizador = IDUtilizador;
		this.NomeUtilizador = nomeUtilizador;
		this.CategoriaProfissional = categoriaProfissional;
		this.Email = email;
		this.Ativo = ativo;
		this.Operacao = Operacao;
		this.data = data;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDLog, this.IDLogUtilizador, this.IDUtilizador, this.NomeUtilizador,
				this.CategoriaProfissional, this.Email, this.Ativo, this.Operacao, this.data };
	}

	public String getNomeUtilizador() {
		return NomeUtilizador;
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

	public void setNomeUtilizador(String nomeUtilizador) {
		NomeUtilizador = nomeUtilizador;
	}

	public String getCategoriaProfissional() {
		return CategoriaProfissional;
	}

	public void setCategoriaProfissional(String categoriaProfissional) {
		CategoriaProfissional = categoriaProfissional;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public int getIDUtilizador() {
		return IDUtilizador;
	}

}
