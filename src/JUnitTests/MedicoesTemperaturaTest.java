package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import bancoDeDados.BancoDeDados;
import bancoDeDados.MedicaoTemperatura;

class MedicoesTemperaturaTest {

	@Test
	void test() throws ParseException {

		/**
		 * Test:
		 * add temperature measurements,
		 * verify temperature entry exist.
		 */
		
		int IDMedicao = 4;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTemp = new Date();
		String dateTempString = new String (dateFormat.format(dateTemp));
		
		double valueTemp = 22.50;
		
		BancoDeDados db = new BancoDeDados();
		MedicaoTemperatura medicaoTemperaturaTest = new MedicaoTemperatura(IDMedicao, dateTemp, valueTemp);
		
		db.inserirMedicoesTemperatura(dateTempString, valueTemp);
		
		boolean measurementEntry = db.listaMedicoesTemperatura().contains(medicaoTemperaturaTest);
		assertEquals (true, measurementEntry);
		
	}
}