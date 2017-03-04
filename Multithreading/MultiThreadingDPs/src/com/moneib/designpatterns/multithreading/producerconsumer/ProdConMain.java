package com.moneib.designpatterns.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConMain {

	public static void main(String[] args) {
		Queue<String> buffer = new LinkedList<>();

		Thread producer = new StringProducer(buffer, Integer.MAX_VALUE);
		Thread consumer = new StringConsumer(buffer);

		producer.start();
		consumer.start();
	}

}
