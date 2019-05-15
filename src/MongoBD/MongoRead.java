package MongoBD;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.bson.Document;

public class MongoRead {
	public static void main(String[] args) {
		try {
			while (true) {
				String queryTemperatura = "INSERT INTO medicoestemperatura (DataHoraMedicao, ValorMedicaoTemperatura) VALUES ";
				String queryLuminosidade = "INSERT INTO medicoesluminosidade (DataHoraMedicao, ValorMedicaoLuminosidade) VALUES ";

				/************* Ler os dados da MongoBD *************/

				/************* Iniciar Ligação com o MongoBD *************/
				// ligação á instancia mongo de porta 27017
				MongoClient mongoClient1 = new MongoClient("127.0.0.1", 27017);
				// vai buscar a bd de sid
				DB db = mongoClient1.getDB("sid_mongodb");
				// Colecção a inserir os dados
				DBCollection table = db.getCollection("DadosSensor");

				DBCursor myCursor = table.find();
				boolean temTemp = false;
				boolean temLum = false;
				while (myCursor.hasNext()) {
					DBObject jsonObject = myCursor.next(); // todo o objecto
					if ((!jsonObject.containsKey("ValorTemperatura") && !jsonObject.containsKey("ValorLuminosidade"))
							|| !jsonObject.containsKey("DataHoraMedicao"))
						continue;
					
					if(jsonObject.containsKey("ValorTemperatura")){
						queryTemperatura += "('" + jsonObject.get("DataHoraMedicao").toString() + "','"
								+ jsonObject.get("ValorTemperatura").toString() + "')";
						temTemp = true;
					}
					
					if(jsonObject.containsKey("ValorLuminosidade")){
						queryLuminosidade += "('" + jsonObject.get("DataHoraMedicao").toString() + "','"
								+ jsonObject.get("ValorLuminosidade").toString() + "')";
						temLum = true;
					}

					if (myCursor.hasNext()) {
						queryTemperatura += ",";
						queryLuminosidade += ",";
					} else {
						queryTemperatura += ";";
						queryLuminosidade += ";";
					}
				}

				System.out.println(queryLuminosidade);
				System.out.println(queryTemperatura);

				/************* Inserir os dados na MySQL *************/
				// caminho para a instancia MySQL
				String servidor = "jdbc:mysql://localhost:3306/";
				// base dados de sid
				String baseDados = "sid_bd_php";
				// driver da bd MySQL
				String driver = "com.mysql.jdbc.Driver";
				// nome do utilizador
				String username = "root";
				// password do utilizador
				String pass = "";

				Class.forName(driver);

				// inicia uma conecção com a base de dados sid MySQL
				Connection connection = DriverManager.getConnection(servidor + baseDados, username, pass);
				System.out.println("connectou");
				// Prepara para correr uma query SQL
				Statement statement = connection.createStatement();

				// Executa a Query
				if(temLum)
					statement.executeUpdate(queryLuminosidade);
				if(temTemp)
					statement.executeUpdate(queryTemperatura);

				connection.close();
//				db.getCollection("sid_mongodb").drop();
				table.remove(new BasicDBObject());
				mongoClient1.close();

				TimeUnit.SECONDS.sleep(30);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
