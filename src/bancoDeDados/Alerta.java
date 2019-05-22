package bancoDeDados;

import java.util.Date;

/**
 * Class Alerta.
 */
public class Alerta implements ObjectBD {
	
	/** The ID alerta. */
	private int IDAlerta;
	
	/** The Email utilizador. */
	private String EmailUtilizador;
	
	/** The Data hora. */
	private Date DataHora;
	
	/** The Nome variavel. */
	private String NomeVariavel;
	
	/** The Limite inferior. */
	private double LimiteInferior;
	
	/** The Limite superior. */
	private double LimiteSuperior;
	
	/** The Valor medicao. */
	private double ValorMedicao;
	
	/** The Descricao. */
	private String Descricao;
	
	/**
	 * Instantiates a new alerta.
	 *
	 * @param iDAlerta the i D alerta
	 * @param emailUtilizador the email utilizador
	 * @param dataHora the data hora
	 * @param nomeVariavel the nome variavel
	 * @param limiteInferior the limite inferior
	 * @param limiteSuperior the limite superior
	 * @param valorMedicao the valor medicao
	 * @param descricao the descricao
	 */
	public Alerta(int iDAlerta, String emailUtilizador, Date dataHora, String nomeVariavel, double limiteInferior,
			double limiteSuperior, double valorMedicao, String descricao) {
		IDAlerta = iDAlerta;
		EmailUtilizador = emailUtilizador;
		DataHora = dataHora;
		NomeVariavel = nomeVariavel;
		LimiteInferior = limiteInferior;
		LimiteSuperior = limiteSuperior;
		ValorMedicao = valorMedicao;
		Descricao = descricao;
	}

	/**
	 * Gets the ID alerta.
	 *
	 * @return the ID alerta
	 */
	public int getIDAlerta(){
		return this.IDAlerta;
	}
	
	/**
	 * Gets the email utilizador.
	 *
	 * @return the email utilizador
	 */
	public String getEmailUtilizador(){
		return this.EmailUtilizador;
	}
	
	/**
	 * Gets the data hora.
	 *
	 * @return the data hora
	 */
	public Date getDataHora() {
		return DataHora;
	}

	/**
	 * Gets the nome variavel.
	 *
	 * @return the nome variavel
	 */
	public String getNomeVariavel() {
		return NomeVariavel;
	}

	/**
	 * Gets the limite inferior.
	 *
	 * @return the limite inferior
	 */
	public double getLimiteInferior() {
		return LimiteInferior;
	}

	/**
	 * Gets the limite superior.
	 *
	 * @return the limite superior
	 */
	public double getLimiteSuperior() {
		return LimiteSuperior;
	}

	/**
	 * Gets the valor medicao.
	 *
	 * @return the valor medicao
	 */
	public double getValorMedicao() {
		return ValorMedicao;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return Descricao;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
