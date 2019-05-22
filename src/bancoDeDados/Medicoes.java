package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Class Medicoes.
 */
public class Medicoes implements ObjectBD {
	
	/** The ID medicoes. */
	private int IDMedicoes;
	
	/** The ID cultura fk. */
	private int IDCultura_fk;
	
	/** The Nome cultura. */
	private String NomeCultura;
	
	/** The ID variavel fk. */
	private int IDVariavel_fk;
	
	/** The Nome variavel. */
	private String NomeVariavel;
	
	/** The Data hora medicao. */
	private Date DataHoraMedicao;
	
	/** The Valor medicao. */
	private double ValorMedicao;

	/**
	 * Instantiates a new medicoes.
	 *
	 * @param IDMedicoes the ID medicoes
	 * @param IDCultura_fk the ID cultura fk
	 * @param NomeCultura the nome cultura
	 * @param IDVariavel_fk the ID variavel fk
	 * @param NomeVariavel the nome variavel
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicao the valor medicao
	 */
	public Medicoes(int IDMedicoes, int IDCultura_fk, String NomeCultura, int IDVariavel_fk, String NomeVariavel, Date DataHoraMedicao, double ValorMedicao) {
		this.IDMedicoes = IDMedicoes;
		this.IDCultura_fk = IDCultura_fk;
		this.NomeCultura = NomeCultura;
		this.IDVariavel_fk = IDVariavel_fk;
		this.NomeVariavel = NomeVariavel;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicao = ValorMedicao;
	}

	/**
	 * Gets the ID medicoes.
	 *
	 * @return the ID medicoes
	 */
	public int getIDMedicoes() {
		return IDMedicoes;
	}

	/**
	 * Sets the ID medicoes.
	 *
	 * @param iDMedicoes the new ID medicoes
	 */
	public void setIDMedicoes(int iDMedicoes) {
		IDMedicoes = iDMedicoes;
	}

	/**
	 * Gets the ID cultura fk.
	 *
	 * @return the ID cultura fk
	 */
	public int getIDCultura_fk() {
		return IDCultura_fk;
	}

	/**
	 * Sets the ID cultura fk.
	 *
	 * @param iDCultura_fk the new ID cultura fk
	 */
	public void setIDCultura_fk(int iDCultura_fk) {
		IDCultura_fk = iDCultura_fk;
	}

	/**
	 * Gets the ID variavel fk.
	 *
	 * @return the ID variavel fk
	 */
	public int getIDVariavel_fk() {
		return IDVariavel_fk;
	}

	/**
	 * Sets the ID variavel fk.
	 *
	 * @param iDVariavel_fk the new ID variavel fk
	 */
	public void setIDVariavel_fk(int iDVariavel_fk) {
		IDVariavel_fk = iDVariavel_fk;
	}

	/**
	 * Gets the data hora medicao.
	 *
	 * @return the data hora medicao
	 */
	public Date getDataHoraMedicao() {
		return DataHoraMedicao;
	}

	/**
	 * Gets the data hora medicao string.
	 *
	 * @return the data hora medicao string
	 */
	public String getDataHoraMedicaoString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dateFormat.format(DataHoraMedicao);
	}

	/**
	 * Sets the data hora medicao.
	 *
	 * @param dataHoraMedicao the new data hora medicao
	 */
	public void setDataHoraMedicao(Date dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
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
	 * Sets the valor medicao.
	 *
	 * @param valorMedicao the new valor medicao
	 */
	public void setValorMedicao(double valorMedicao) {
		ValorMedicao = valorMedicao;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicoes, this.NomeCultura, this.NomeVariavel, getDataHoraMedicaoString(),
				this.ValorMedicao };
	}
}
