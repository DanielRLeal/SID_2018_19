package bancoDeDados;

public class Sistema implements ObjectBD {
	private double LimiteSuperiorTemperatura;
	private double LimiteInferiorTemperatura;
	private double LimiteSuperiorLuminosidade;
	private double LimiteInferiorLuminosidade;
	/**
	 * @param limiteSuperiorTemperatura
	 * @param limiteInferiorTemperatura
	 * @param limiteSuperiorLuminosidade
	 * @param limiteInferiorLuminosidade
	 */
	public Sistema(double limiteSuperiorTemperatura, double limiteInferiorTemperatura,
			double limiteSuperiorLuminosidade, double limiteInferiorLuminosidade) {
		LimiteSuperiorTemperatura = limiteSuperiorTemperatura;
		LimiteInferiorTemperatura = limiteInferiorTemperatura;
		LimiteSuperiorLuminosidade = limiteSuperiorLuminosidade;
		LimiteInferiorLuminosidade = limiteInferiorLuminosidade;
	}
	
	@Override
	public Object[] toObjectArray() {
		return new Object[] { this.LimiteSuperiorTemperatura, this.LimiteInferiorTemperatura, this.LimiteSuperiorLuminosidade, this.LimiteInferiorLuminosidade };
	}
}
