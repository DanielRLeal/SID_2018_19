package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Medicoes implements ObjectBD {
	private int IDMedicoes;
	private int IDCultura_fk;
	private int IDVariavel_fk;
	private Date DataHoraMedicao;
	private double ValorMedicao;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
	 */
	public Medicoes(int IDMedicoes, int IDCultura_fk, int IDVariavel_fk, Date DataHoraMedicao, double ValorMedicao) {
		this.IDMedicoes = IDMedicoes;
		this.IDCultura_fk = IDCultura_fk;
		this.IDVariavel_fk = IDVariavel_fk;
		this.DataHoraMedicao = DataHoraMedicao;
		this.ValorMedicao = ValorMedicao;
	}

	public int getIDMedicoes() {
		return IDMedicoes;
	}

	public void setIDMedicoes(int iDMedicoes) {
		IDMedicoes = iDMedicoes;
	}

	public int getIDCultura_fk() {
		return IDCultura_fk;
	}

	public void setIDCultura_fk(int iDCultura_fk) {
		IDCultura_fk = iDCultura_fk;
	}

	public int getIDVariavel_fk() {
		return IDVariavel_fk;
	}

	public void setIDVariavel_fk(int iDVariavel_fk) {
		IDVariavel_fk = iDVariavel_fk;
	}

	public Date getDataHoraMedicao() {
		return DataHoraMedicao;
	}
	
	public String getDataHoraMedicaoString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(DataHoraMedicao);
	}
	
	public void setDataHoraMedicao(Date dataHoraMedicao) {
		DataHoraMedicao = dataHoraMedicao;
	}

	public double getValorMedicao() {
		return ValorMedicao;
	}

	public void setValorMedicao(double valorMedicao) {
		ValorMedicao = valorMedicao;
	}

	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.IDMedicoes, this.IDCultura_fk, this.IDVariavel_fk, getDataHoraMedicaoString(), this.ValorMedicao };
	}
}
