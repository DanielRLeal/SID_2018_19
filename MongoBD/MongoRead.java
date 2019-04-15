import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

import org.bson.Document;

public class MongoRead   {
	public static void main(String[] args) {		
		/*MongoClient mongoClient1 = new MongoClient("127.0.0.1", 27017);
		
		MongoDatabase db = mongoClient1.getDatabase("sid_mongodb");
		FindIterable<Document> iterable = db.getCollection("MedicoesLuminosidade").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });*/
		
		String servidor = "jdbc:mysql://localhost:3306/dbphp";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(servidor, "sensorTeste", "pass123");
			statement = connection.createStatement();
			
			String query = "INSERT INTO MedicoesLuminosidade";
			statement.executeUpdate(query);
		} catch (Exception e) {
		}
    }
}
