package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class MedicaoTemperatura.
 */
public class MedicaoTemperatura implements ObjectBD {
	
	/** The ID medicao. */
	int IDMedicao;
	
	/** The Data hora medicao. */
	Date DataHoraMedicao;
	
	/** The Valor medicao temperatura. */
	double ValorMedicaoTemperatura;

	/**
	 * Instantiates a new medicao temperatura.
	 *
	 * @param IDMedicao the ID medicao
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicaoTemperatura the valor medicao temperatura
	 */
	public MedicaoTemperatura(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoTemperatura) {
		this.IDMedicao = IDMedicao;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicaoTemperatura = ValorMedicaoTemperatura;
	}

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicao, getDataHoraMedicaoString(), this.ValorMedicaoTemperatura };
	}

	/**
	 * Gets the ID medicao.
	 *
	 * @return the ID medicao
	 */
	public int getIDMedicao() {
		return IDMedicao;
	}

	/**
	 * Sets the ID medicao.
	 *
	 * @param iDMedicao the new ID medicao
	 */
	public void setIDMedicao(int iDMedicao) {
		IDMedicao = iDMedicao;
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
	 * Sets the data hora medicao.
	 *
	 * @param dataHoraMedicao the new data hora medicao
	 */
	public void setDataHoraMedicao(Date dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
	}

	/**
	 * Gets the valor medicao temperatura.
	 *
	 * @return the valor medicao temperatura
	 */
	public double getValorMedicaoTemperatura() {
		return ValorMedicaoTemperatura;
	}

	/**
	 * Sets the valor medicao temperatura.
	 *
	 * @param valorMedicaoTemperatura the new valor medicao temperatura
	 */
	public void setValorMedicaoTemperatura(double valorMedicaoTemperatura) {
		ValorMedicaoTemperatura = valorMedicaoTemperatura;
	}

	/**
	 * Gets the data hora medicao string.
	 *
	 * @return the data hora medicao string
	 */
	public String getDataHoraMedicaoString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(DataHoraMedicao);
	}

}
