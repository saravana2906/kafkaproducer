package com.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.bean.Order;

public class OrderProducer {
	
	public static void main(String args[])
	{
		Properties props = new Properties();
		Order ord=new Order();
		ord.setOrderId("12360");
		ord.setBrand("sars");
		ord.setPayment("credit");
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "com.producer.ObjectSerializer");
		try (Producer<String, Order> producer = new KafkaProducer<>(props))
		{
			   producer.send(new ProducerRecord<String, Order>("ordertopic", ord));
			   System.out.println("Message " + ord.toString() + " sent !!");
			} catch (Exception e) {
			   e.printStackTrace();
			}
	}

}
