package com.producer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.bean.Order;

public class ObjectSerializer implements Serializer<Order> {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String arg0, Order arg1) {
		// TODO Auto-generated method stub
		 try {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ObjectOutputStream oos = new ObjectOutputStream(baos);
	            oos.writeObject(arg1);
	            oos.close();
	            byte[] b = baos.toByteArray();
	            return b;
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return new byte[0];
	        }
		
	}
	

}
