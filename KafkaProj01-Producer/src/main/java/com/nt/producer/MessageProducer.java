package com.nt.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class MessageProducer {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String,String> producer=new KafkaProducer<String,String>(props);
		String msg="welcome to apache kafka messaging";
		String topicName="nit-tpc";
		ProducerRecord<String,String> record=new ProducerRecord<String,String>(topicName,msg);
        producer.send(record);
        producer.flush();
        producer.close();
        System.out.println("message sent");
	}

}
