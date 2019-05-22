package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class MedicaoLuminosidade.
 */
public class MedicaoLuminosidade implements ObjectBD {
	
	/** The ID medicao. */
	int IDMedicao;
	
	/** The Data hora medicao. */
	Date DataHoraMedicao;
	
	/** The Valor medicao luminosidade. */
	double ValorMedicaoLuminosidade;

	/**
	 * Instantiates a new medicao luminosidade.
	 *
	 * @param IDMedicao the ID medicao
	 * @param DataHoraMedicao the data hora medicao
	 * @param ValorMedicaoLuminosidade the valor medicao luminosidade
	 */
	public MedicaoLuminosidade(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoLuminosidade) {
		this.IDMedicao = IDMedicao;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicaoLuminosidade = ValorMedicaoLuminosidade;
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

	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicao, getDataHoraMedicaoString(), this.ValorMedicaoLuminosidade };
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
	 * Gets the valor medicao luminosidade.
	 *
	 * @return the valor medicao luminosidade
	 */
	public double getValorMedicaoLuminosidade() {
		return ValorMedicaoLuminosidade;
	}

	/**
	 * Sets the valor medicao luminosidade.
	 *
	 * @param valorMedicaoLuminosidade the new valor medicao luminosidade
	 */
	public void setValorMedicaoLuminosidade(double valorMedicaoLuminosidade) {
		ValorMedicaoLuminosidade = valorMedicaoLuminosidade;
	}

}
