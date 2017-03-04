package com.moneib.designpatterns.multithreading.producerconsumer;

import java.util.Queue;

public class StringConsumer extends Consumer<String> {

	public StringConsumer(Queue<String> buffer) {
		super(buffer);
	}

	@Override
	protected void consume(String product) {
		System.out.println(product + " is consumed.");
	}
}
