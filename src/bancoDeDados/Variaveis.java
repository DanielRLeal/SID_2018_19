package bancoDeDados;

public class Variaveis implements ObjectBD {
	private int IDVariaveis;
	private String NomeVariaveis;
	private int IDCultura_fk;

	public Variaveis(int IDVariaveis, String NomeVariaveis, int IDCultura_fk) {
		IDVariaveis = IDVariaveis;
		NomeVariaveis = NomeVariaveis;
		IDCultura_fk = IDCultura_fk;
	}

	@Override
	public Object[] toObjectArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIDVariaveis() {
		return IDVariaveis;
	}

	public void setIDVariaveis(int iDVariaveis) {
		IDVariaveis = iDVariaveis;
	}

	public String getNomeVariaveis() {
		return NomeVariaveis;
	}

	public void setNomeVariaveis(String nomeVariaveis) {
		NomeVariaveis = nomeVariaveis;
	}

	public int getIDCultura_fk() {
		return IDCultura_fk;
	}

	public void setIDCultura_fk(int iDCultura_fk) {
		IDCultura_fk = iDCultura_fk;
	}
}