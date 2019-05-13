package MongoBD;

import com.mongodb.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.bson.json.*;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MongoWrite implements MqttCallback {
	// Nome do topico subscrito
	String topic = "sid_2019_g19_";
	// conteudo a escrever no servidor Paho, utilizado quando se for publicar
	// mensagens
	// String content = "teste123";
	// QoS 2 pois queremos rapidade de servi�o mas que a mensagem apenas seja
	// entregue uma vez
	// preferimos velocidade pois o que nos interessa � a varia��o dos valores ao
	// longo do tempo
	int qos = 0;
	// Caminho do servidor Paho a utilizar na conec��o
	String broker = "tcp://iot.eclipse.org:1883";
	// Id do cliente a utilizar na connec��o
	String clientId = "js-utility-452";
	DBCollection table;

	public static void main(String[] args) {
		new MongoWrite();
	}

	public MongoWrite() {
		// Objecto que torna a liga��o persistente, caso venha a ser utilizado
		MemoryPersistence persistent = new MemoryPersistence();
		try {
			/************* Iniciar Liga��o com o Paho *************/
			// Cria o objecto cliente com os parametros do link de acesso e com o id de
			// cliente
			// A MemoryPersistence permite que caso a liga��o seja perdida este guarda as
			// mensagens de QoS 1 e 2
			// em fila associadas ao ClientID para quando existir reconec��o se receba as
			// mensagens de volta
			MqttClient sampleClient = new MqttClient(broker, clientId, persistent);

			// cleansession a true indica que a liga��o n�o foi persistente
			// ou seja � uma liga��o nova que vai limpar as mensagens da liga��o antiga que
			// ficaram em fila
			// colocar a false para permitir receber mensagens que n�o foram entregues na
			// sess�o anterior
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			// Connecta ao cliente
			System.out.println("Connecting to broker: " + broker);
			sampleClient.connect(connOpts);

			// Define que � esta classe que vai implementar o CallBack
			System.out.println("Connected");
			sampleClient.setCallback(this);

			// Subscreve o topico no servidor
			sampleClient.subscribe(topic, qos);

			/************* Publica mensagem no Paho *************/
			/*
			 * System.out.println("Publishing message: "+content); //inicia objecto da
			 * mensagem a publicar MqttMessage message = new
			 * MqttMessage(content.getBytes()); //Define a Qualidade de mensagem a utilizar
			 * message.setQos(qos); //publica a mensagem sampleClient.publish(topic,
			 * message); System.out.println("Message published");
			 */

			// desconecta a sess�o
			// sampleClient.disconnect();
			// System.out.println("Disconnected");
			// termina o programa
			// System.exit(0);

			/************* Iniciar Liga��o com o MongoBD *************/
			// liga��o � instancia mongo de porta 27017
			MongoClient mongoClient1 = new MongoClient("127.0.0.1", 27017);
			// vai buscar a bd de sid
			DB db = mongoClient1.getDB("sid_mongodb");
			// Colec��o a inserir os dados
			table = db.getCollection("DadosSensor");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/************* Ler mensagem do Paho *************/
	@Override
	public void messageArrived(String topicArrived, MqttMessage message) throws Exception {
		// formato dos dados recebidos pelo sensor
		// {"tmp":"22.40","hum":"61.30","dat":"9/4/2019","tim":"14:59:32","cell":"3138","sens":"wifi"}

		// no caso do topico n�o for igual ao da mensagem que estamos a espera sai da
		// fun��o
		// ou no caso da qualidade de servi�o ser outra n�o � de confian�a
		if (!this.topic.equals(topicArrived) || message.getQos() != qos)
			return;

//		if (!isJSONValid(message.toString())) {
//			System.out.println("mensagem de formato JSON incorrecto:" + message.toString());
//			return;
//		}

		JSONObject jsonObj = new JSONObject(message.toString());

		if (!jsonObj.has("tmp") || !jsonObj.has("cell")) {
			System.out.println("mensagem n�o cont�m todos os dados necess�rios (dat, tim, tmp, cell)");
			return;
		}

		if (jsonObj.get("cell").toString().equals("") || jsonObj.get("tim").toString().equals("")) {

			System.out.println("Dados invalidos para serem inseridos na db");
			return;
		}

		//String dataValor2 = jsonObj.get("dat").toString() + " " + jsonObj.get("tim").toString();

		// valor da temperatura
		String tempValor = jsonObj.get("tmp").toString();
		// valor da luminosidade
		String lumValor = jsonObj.get("cell").toString();

		/************* Escrever dados do sensor na MongoBD *************/
		// documento a inserir na cole��o
		BasicDBObject document = new BasicDBObject();
		document.put("ValorTemperatura", tempValor);
		document.put("ValorLuminosidade", lumValor);

		// Valida se data � valida para o java

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		document.put("DataHoraMedicao", dateFormat.format(date));

		System.out.println(document.toString());

		// insere o documento na cole��o
		try {
			table.insert(document);
		} catch (Exception e) {
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
	}

	public boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	public boolean isDateValid(String test) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(test);
			dateFormat.format(date);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
