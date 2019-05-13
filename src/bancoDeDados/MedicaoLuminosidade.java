package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicaoLuminosidade implements ObjectBD {
	int IDMedicao;
	Date DataHoraMedicao;
	double ValorMedicaoLuminosidade;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public MedicaoLuminosidade(int IDMedicao, Date DataHoraMedicao, double ValorMedicaoLuminosidade) {
		this.IDMedicao = IDMedicao;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicaoLuminosidade = ValorMedicaoLuminosidade;
	}

	public String getDataHoraMedicaoString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(DataHoraMedicao);
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicao, getDataHoraMedicaoString(), this.ValorMedicaoLuminosidade };
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

	public double getValorMedicaoLuminosidade() {
		return ValorMedicaoLuminosidade;
	}

	public void setValorMedicaoLuminosidade(double valorMedicaoLuminosidade) {
		ValorMedicaoLuminosidade = valorMedicaoLuminosidade;
	}

}
