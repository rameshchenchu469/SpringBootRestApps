package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

public class MessageConsumer {

	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1_consumer");
		
		@SuppressWarnings("resource")
		KafkaConsumer<String,String> consumer=new KafkaConsumer<String,String>(props);
		
		consumer.subscribe(Arrays.asList("nit-tpc"));
		
		while(true) {
			ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(2000));
			for(ConsumerRecord<String, String> record:records) {
				System.out.println("message is"+record.value());
			}
		}
	}

}
