package com.moneib.designpatterns.multithreading.producerconsumer;

import java.util.Queue;

public class StringProducer extends Producer<String> {

	public StringProducer(Queue<String> buffer, int maxSize) {
		super(buffer, maxSize);
	}

	@Override
	protected String produce() {
		String s = "String " + Math.random();
		System.out.println(s + " is produced.");
		return s;
	}
}
