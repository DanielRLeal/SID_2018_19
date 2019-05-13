package bancoDeDados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Medicoes implements ObjectBD {
	private int IDMedicoes;
	private int IDCultura_fk;
	private String NomeCultura;
	private int IDVariavel_fk;
	private String NomeVariavel;
	private Date DataHoraMedicao;
	private double ValorMedicao;

	/**
	 * @param iD
	 * @param nomeUtilizador
	 * @param categoriaProfissional
	 * @param email
	 * @param ativo
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
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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
		return new Object[] { this.IDMedicoes, this.NomeCultura, this.NomeVariavel, getDataHoraMedicaoString(),
				this.ValorMedicao };
	}
}
