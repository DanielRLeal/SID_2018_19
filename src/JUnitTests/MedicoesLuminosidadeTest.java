package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import bancoDeDados.BancoDeDados;
import bancoDeDados.MedicaoLuminosidade;

class MedicoesLuminosidadeTest {

	@Test
	void test() throws ParseException {
		/**
		 * Test:
		 * add light measurements,
		 * verify light entry exist.
		 */

		int IDMedicao = 4;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateLight = new Date();
		String dateLightString = new String (dateFormat.format(dateLight));
		
		double valueLum = 4002;
		
		BancoDeDados db = new BancoDeDados();
		MedicaoLuminosidade medicaoLuminosidadeTest = new MedicaoLuminosidade(IDMedicao, dateLight, valueLum);
		
		db.inserirMedicoesLuminosidade(dateLightString, valueLum);
		
		boolean measurementEntry = db.listaMedicoesLuminosidade().contains(medicaoLuminosidadeTest);
		assertEquals (true, measurementEntry);
		
	}

}
