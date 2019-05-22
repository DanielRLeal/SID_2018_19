package bancoDeDados;

/**
 * Class Sistema.
 */
public class Sistema implements ObjectBD {
	
	/** The Limite superior temperatura. */
	private double LimiteSuperiorTemperatura;
	
	/** The Limite inferior temperatura. */
	private double LimiteInferiorTemperatura;
	
	/** The Limite superior luminosidade. */
	private double LimiteSuperiorLuminosidade;
	
	/** The Limite inferior luminosidade. */
	private double LimiteInferiorLuminosidade;
	
	/** The Percentagem limiar temperatura. */
	private double PercentagemLimiarTemperatura;
	
	/** The Percentagem limiar luminosidade. */
	private double PercentagemLimiarLuminosidade;
	
	/** The Numero medicoes para alerta temperatura. */
	private int NumeroMedicoesParaAlertaTemperatura;
	
	/** The Numero medicoes para alerta luminosidade. */
	private int NumeroMedicoesParaAlertaLuminosidade;
	
	/** The Intervalo entre alertas minutos. */
	private double IntervaloEntreAlertasMinutos;
	
	/**
	 * Instantiates a new sistema.
	 *
	 * @param limiteSuperiorTemperatura the limite superior temperatura
	 * @param limiteInferiorTemperatura the limite inferior temperatura
	 * @param limiteSuperiorLuminosidade the limite superior luminosidade
	 * @param limiteInferiorLuminosidade the limite inferior luminosidade
	 * @param percentagemLimiarTemperatura the percentagem limiar temperatura
	 * @param percentagemLimiarLuminosidade the percentagem limiar luminosidade
	 * @param numeroMedicoesParaAlertaTemperatura the numero medicoes para alerta temperatura
	 * @param numeroMedicoesParaAlertaLuminosidade the numero medicoes para alerta luminosidade
	 * @param intervaloEntreAlertasMinutos the intervalo entre alertas minutos
	 */
	public Sistema(double limiteSuperiorTemperatura, double limiteInferiorTemperatura,
			double limiteSuperiorLuminosidade, double limiteInferiorLuminosidade,
			double percentagemLimiarTemperatura, double percentagemLimiarLuminosidade,
			int numeroMedicoesParaAlertaTemperatura, int numeroMedicoesParaAlertaLuminosidade,
			double intervaloEntreAlertasMinutos) {
		LimiteSuperiorTemperatura = limiteSuperiorTemperatura;
		LimiteInferiorTemperatura = limiteInferiorTemperatura;
		LimiteSuperiorLuminosidade = limiteSuperiorLuminosidade;
		LimiteInferiorLuminosidade = limiteInferiorLuminosidade;
		PercentagemLimiarTemperatura = percentagemLimiarTemperatura;
		PercentagemLimiarLuminosidade = percentagemLimiarLuminosidade;
		NumeroMedicoesParaAlertaTemperatura = numeroMedicoesParaAlertaTemperatura;
		NumeroMedicoesParaAlertaLuminosidade = numeroMedicoesParaAlertaLuminosidade;
		IntervaloEntreAlertasMinutos = intervaloEntreAlertasMinutos;
	}
	
	/* (non-Javadoc)
	 * @see bancoDeDados.ObjectBD#toObjectArray()
	 */
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.LimiteSuperiorTemperatura, this.LimiteInferiorTemperatura,
				this.LimiteSuperiorLuminosidade, this.LimiteInferiorLuminosidade,
				this.PercentagemLimiarTemperatura, this.PercentagemLimiarLuminosidade,
				this.NumeroMedicoesParaAlertaTemperatura, this.NumeroMedicoesParaAlertaLuminosidade,
				this.IntervaloEntreAlertasMinutos };
	}
}
