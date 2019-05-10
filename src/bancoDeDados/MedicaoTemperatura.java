package bancoDeDados;

import java.util.Date;

public class MedicaoTemperatura implements ObjectBD {
	int IDMedicao;
	Date DataHoraMedicao;
	double ValorMedicaoTemperatura;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public MedicaoTemperatura(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoTemperatura) {
		this.IDMedicao = IDMedicao;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicaoTemperatura = ValorMedicaoTemperatura;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicao, this.DataHoraMedicao, this.ValorMedicaoTemperatura };
	}

	public int getIDMedicao() {
		return IDMedicao;
	}

	public void setIDMedicao(int iDMedicao) {
		IDMedicao = iDMedicao;
	}

	public Date getDataHoraMedicao() {
		return DataHoraMedicao;
	}

	public void setDataHoraMedicao(Date dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
	}

	public double getValorMedicaoTemperatura() {
		return ValorMedicaoTemperatura;
	}

	public void setValorMedicaoTemperatura(double valorMedicaoTemperatura) {
		ValorMedicaoTemperatura = valorMedicaoTemperatura;
	}

}
