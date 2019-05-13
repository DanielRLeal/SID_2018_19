package bancoDeDados;

import java.util.Date;

public class Alerta implements ObjectBD {
	private int IDAlerta;
	private int IDUtilizador;
	private String EmailUtilizador;
	private Date DataHora;
	private String NomeVariavel;
	private double LimiteInferior;
	private double LimiteSuperior;
	private double ValorMedicao;
	private String Descricao;
	private boolean Visto;
	
	/**
	 * @param iDAlerta
	 * @param iDUtilizador
	 * @param dataHora
	 * @param nomeVariavel
	 * @param limiteInferior
	 * @param limiteSuperior
	 * @param valorMedicao
	 * @param descricao
	 * @param visto
	 */
	public Alerta(int iDAlerta, int iDUtilizador, String emailUtilizador, Date dataHora, String nomeVariavel, double limiteInferior,
			double limiteSuperior, double valorMedicao, String descricao, boolean visto) {
		IDAlerta = iDAlerta;
		IDUtilizador = iDUtilizador;
		EmailUtilizador = emailUtilizador;
		DataHora = dataHora;
		NomeVariavel = nomeVariavel;
		LimiteInferior = limiteInferior;
		LimiteSuperior = limiteSuperior;
		ValorMedicao = valorMedicao;
		Descricao = descricao;
		Visto = visto;
	}

	public int getIDAlerta(){
		return this.IDAlerta;
	}
	
	public String getEmailUtilizador(){
		return this.EmailUtilizador;
	}
	
	public Date getDataHora() {
		return DataHora;
	}

	public String getNomeVariavel() {
		return NomeVariavel;
	}

	public double getLimiteInferior() {
		return LimiteInferior;
	}

	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	public double getValorMedicao() {
		return ValorMedicao;
	}

	public String getDescricao() {
		return Descricao;
	}

	@Override
	public Object[] toObjectArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
