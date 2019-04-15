import com.mongodb.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MongoWrite implements MqttCallback{
	String topic = "sid_2019_g19";
	String content      = "teste123";
    int qos             = 2;
    String broker       = "tcp://iot.eclipse.org:1883";
    String clientId     = "js-utility-452";
	
	MqttClient sampleClient;
	
	public static void main(String[] args) {
	    new MongoWrite();
	}
	
	public MongoWrite(){
	    MemoryPersistence persistence = new MemoryPersistence();
	    
		try {
			//Leitura Do servidor Paho
			sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            
            sampleClient.setCallback(this);
            
            //subscreve o topico e publica uma mensagem
            /*sampleClient.subscribe(topic);
            System.out.println("Publishing message: teste123");
            MqttMessage message = new MqttMessage("teste123".getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");*/
            
            //sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
		} catch (MqttException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		System.out.println("connectionLost");
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("deliveryComplete");
		
	}

	@Override
	public void messageArrived(String topicArrived, MqttMessage message) throws Exception {
		if(this.topic.equals(topicArrived))
			System.out.println(message.toString());
		
		//Escrita na BD Mongo
        /*MongoClient mongoClient1 = new MongoClient("127.0.0.1", 27017);
		DB db = mongoClient1.getDB("sid_mongodb");
		
		DBCollection table = db.getCollection("newcol");
		BasicDBObject document = new BasicDBObject();
		document.put("ValorMedicao", 10);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
        document.put("DataHoraMedicao", dateFormat.format(date));
		try { table.insert(document);} catch (Exception e) {}
		mongoClient1.close();*/
		
	}
}	
