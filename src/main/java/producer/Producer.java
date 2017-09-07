package producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args){
            Properties props = new Properties();

            props.put("bootstrap.servers","localhost:9092, localhost:9093");
            props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

            KafkaProducer<String,String> myProducer = new KafkaProducer<String,String>(props);

            try{
                for (int key = 0; key < 50; key++) {
                    myProducer.send(new ProducerRecord<String, String>("topic_2", Integer.toString(key), "My test message for key:"+key));
                    System.out.println("Kafka topic Key=" + key +", Kafka Message:"+"My test message for key:"+key);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                myProducer.close();

        }

    }
}
